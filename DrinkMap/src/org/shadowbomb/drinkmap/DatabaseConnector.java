package org.shadowbomb.drinkmap;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;

//import com.microsoft.sqlserver.jdbc.SQLServerDriver;

/**
*
* @author Lorraine Jimenez, Sean Harding
*/
public class DatabaseConnector {
	private final String hostName = "drinkmap.database.windows.net";
    private final String port = "1433";
    private final String dbName = "DrinkMap";
    //private final String user = "DrinkMap_Application_User@DrinkMap";
    //private final String password = "psw321$@pp";
    private final String user = "lorrainej";
    private final String password = "somethingREALLY!!!hard";
    private final String encrypt = "true";
    private final String trustServerCertificate = "false";
    private final String hostNameInCertificate = "*.database.windows.net";
    private final String loginTimeout = "30";
    private final String url = String.format("jdbc:sqlserver://%s:%s;database=%s;user=%s;password=%s;encrypt=%s;trustServerCertificate=%s;hostNameInCertificate=%s;loginTimeout=%s;",
        hostName, port, dbName, user, password, encrypt, trustServerCertificate, hostNameInCertificate, loginTimeout);
    private transient Connection conn = null;
    private String schema = null;
    private volatile transient boolean error = false;
    
	//Driver SQLServerDriver = null;
	//Statement stmt = null; << Attempt to globalize
	
	//Preset Functions
	private final transient String SELECT_MIXED_DRINK = "SELECT * FROM dbo.SELECT_MIXED_DRINK";
	private final transient String SEARCH_ALL = "SELECT * FROM dbo.SEARCH_ALL;";
	private final transient String SEARCH_FULLTEXT = "SELECT MIXED_DRINK.NAME FROM MIXED_DRINK ";
	
	// BLAH

	
    //Default Constructor
    public DatabaseConnector() {
		connect();
        if (conn == null) {
        	System.err.println("Attempting 2nd connect...");
        	System.out.println((connect()) ? "Connected" : "2nd CONNECT FAIL");
        } else System.out.println("Successfully Connected...Continuing Application");
    }
    
    private boolean connect() {
		try {
			conn = DriverManager.getConnection(url);
			schema = conn.getSchema();
			System.out.println("Successful connection - Schema: " + schema);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			System.err.println("CONNECTION FAILED");
			conn = null;
		}
        return (conn == null) ? false : true;
    }
    public boolean reconnect() {
    	//statement = create new one bruh; << for globalize
    	boolean rc_con = false;
    	//If no con, discon then recon, both true, then success, else something failed
    	rc_con = (conn == null) ? connect() : disconnect() && connect();
		return rc_con;
    } 
    public boolean disconnect() {
        //stmt = null; << for globalize
    	boolean ds_con = false;
		try {
			conn.close();
			conn = null;
			ds_con = true;
		} catch (SQLException sqle) {
			System.err.println("DISCONNECT FAILURE");
			ds_con = false;
		}
		return ds_con;
    }
    
    public boolean connected() {
    	return !(conn == null);
	}
	
	private String process_String(String args) {
		String proc = args;
		proc = proc.replaceAll("'", "''");
		return proc;
	}
    
    //SQL Query method for SQL testing
    public ResultSet query(String query) {
        //Finish this, figure out other ones...
        ResultSet result = null;
        try {
        	//Globalize that v
            Statement stmt = conn.createStatement();
			result = stmt.executeQuery(query);
			//stmt.close();
			//stmt = null;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            System.err.println("SQL STATEMENT FAILED");
        }
        return result;
    }
    
    //Multiquery
    public ResultSet[] multiQuery(String... multiQuery) {
    	ResultSet[] rs = new ResultSet[multiQuery.length];
    	try {
    		Statement stmt = conn.createStatement();
    		int indx = 0;
        	for (String query : multiQuery) {
        		rs[indx++] = stmt.executeQuery(process_String(query));
			}
			//stmt.close();
			//stmt = null;
    	} catch (SQLException sqle) {
    		sqle.printStackTrace();
    		System.err.println("MULTIQUERY FAILURE");
    		rs = null;
    	}
    	return rs;
    }
    
	//Special Queries:::
	public ResultSet select_all_mixed_drink() {
		ResultSet rs = null;
    	rs = query(SEARCH_ALL);
    	return rs;
	}
	
    public ResultSet select_mixed_drink(String mixed_drink) {
		ResultSet rs = null;
    	rs = query(SELECT_MIXED_DRINK + "('" + process_String(mixed_drink) + "');");
    	return rs;
	}

	public ResultSet search_fulltext(String args, boolean MIXED_DRINK, boolean INGREDIENT, boolean BRAND) {
		ResultSet rs = null;
		
		String[] arr = process_String(args).split(",|\\s");
		
		String param = "'";
		for (int i = 0; i < arr.length; i++) {
			param += "\"" + arr[i] + "\"";
			if (i != arr.length - 1) param += " OR ";
			else param += "'";
		}
		
		String search = SEARCH_FULLTEXT;

		
		if (MIXED_DRINK) {
			if (INGREDIENT) {
				if (BRAND) {
					search += "LEFT JOIN INGREDIENT_MIX ON MIXED_DRINK.ID = INGREDIENT_MIX.ID" + " "
							+ "LEFT JOIN INGREDIENT ON INGREDIENT_MIX.ID = INGREDIENT.ID" + " "
							+ "LEFT JOIN BRAND ON INGREDIENT.BRAND_ID = BRAND.ID" + " "
						+ "WHERE CONTAINS(BRAND.Name, " + param + ")" + " "
							+ "OR" + " "
						+ "CONTAINS(INGREDIENT.Name, " + param + ")" + " "
							+ "OR" + " "
						+ "CONTAINS(MIXED_DRINK.Name, " + param + ");";
				} else {
					search += "LEFT JOIN INGREDIENT_MIX ON MIXED_DRINK.ID = INGREDIENT_MIX.ID" + " "
							+ "LEFT JOIN INGREDIENT ON INGREDIENT_MIX.ID = INGREDIENT.ID" + " "
						+ "WHERE CONTAINS(INGREDIENT.Name, " + param + ")" + " "
							+ "OR" + " "
						+ "CONTAINS(MIXED_DRINK.Name, " + param + ");";
				}
			} else if (BRAND) {
				search += "LEFT JOIN INGREDIENT_MIX ON MIXED_DRINK.ID = INGREDIENT_MIX.ID" + " "
							+ "LEFT JOIN INGREDIENT ON INGREDIENT_MIX.ID = INGREDIENT.ID" + " "
							+ "LEFT JOIN BRAND ON INGREDIENT.BRAND_ID = BRAND.ID" + " "
						+ "WHERE CONTAINS(BRAND.Name, " + param + ")" + " "
							+ "OR" + " "
						+ "CONTAINS(MIXED_DRINK.Name, " + param + ");";
			} else {
				search += "WHERE CONTAINS(MIXED_DRINK.Name, " + param + ");";
			}
		} else if (INGREDIENT) {
			if (BRAND) {
				search += "LEFT JOIN INGREDIENT_MIX ON MIXED_DRINK.ID = INGREDIENT_MIX.ID" + " "
							+ "LEFT JOIN INGREDIENT ON INGREDIENT_MIX.ID = INGREDIENT.ID" + " "
							+ "LEFT JOIN BRAND ON INGREDIENT.BRAND_ID = BRAND.ID" + " "
						+ "WHERE CONTAINS(BRAND.Name, " + param + ")" + " "
							+ "OR" + " "
						+ "CONTAINS(INGREDIENT.Name, " + param + ");";
			} else {
				search += "LEFT JOIN INGREDIENT_MIX ON MIXED_DRINK.ID = INGREDIENT_MIX.ID" + " "
							+ "LEFT JOIN INGREDIENT ON INGREDIENT_MIX.ID = INGREDIENT.ID" + " "
						+ "WHERE CONTAINS(INGREDIENT.Name, " + param + ");";
			}
		} else if (BRAND) {
			search += "LEFT JOIN INGREDIENT_MIX ON MIXED_DRINK.ID = INGREDIENT_MIX.ID" + " "
							+ "LEFT JOIN INGREDIENT ON INGREDIENT_MIX.ID = INGREDIENT.ID" + " "
							+ "LEFT JOIN BRAND ON INGREDIENT.BRAND_ID = BRAND.ID" + " "
						+ "WHERE CONTAINS(BRAND.Name, " + param + ");";
		}
		rs = query(search);
    	return rs;
	}
	
	public void insert_query(int star, String name) throws SQLException {
		Statement stmt = conn.createStatement();
		String s = "insert into review_drink(rating, mixed_drink_id) values(" +
					star + ", " + "(SELECT dbo.FUNCTION_MIXED_DRINK_ID('" +
					name + "')))";
		stmt.execute(s);
	}
    
	/*
	public static void main(String[] args) {
		DatabaseConnector dbc = new DatabaseConnector();
		dbc.databaseQuery("select * from BRAND;");
	}*/
}