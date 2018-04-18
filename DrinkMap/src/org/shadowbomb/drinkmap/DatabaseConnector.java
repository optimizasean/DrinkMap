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
    private final String user = "Shadowbomb@DrinkMap";
    private final String password = "Administrator2545";//"s5#d(V)2`c Ldj2#9!~";
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
    
    //SQL Query method for SQL testing
    public ResultSet query(String query) {
        //Finish this, figure out other ones...
        ResultSet result = null;
        try {
        	//Globalize that v
            Statement stmt = conn.createStatement();
            result = stmt.executeQuery(query);
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
        		rs[indx++] = stmt.executeQuery(query);
        	}
    	} catch (SQLException sqle) {
    		sqle.printStackTrace();
    		System.err.println("MULTIQUERY FAILURE");
    		rs = null;
    	}
    	return rs;
    }
    
    //Special Queries:::
    
    
	/*public static void main(String[] args) {
		DatabaseConnector dbc = new DatabaseConnector();
		dbc.databaseQuery("select * from BRAND;");
	}*/
}