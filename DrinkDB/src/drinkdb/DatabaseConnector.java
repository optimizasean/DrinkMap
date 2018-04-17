package drinkdb;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;

/**
 *
 * @author Lorraine Jimenez, Sean Harding
 */
public class DatabaseConnector {
    private String hostName = "drinkmap.database.windows.net";
    private String port = "1433";
    private String dbName = "DrinkMap";
    private String user = "Application";
    private String password = "s5#d(V)2`c Ldj2#9!~";
    private String encrypt = "false";
    private String hostNameInCertificate = "*.database.windows.net";
    private String loginTimeout = "30";
    private String url = String.format("jdbc:sqlserver://%s:%s;database=%s;user=%s;password=%s;encrypt=%s;hostNameInCertificate=%s;loginTimeout=%s;",
        hostName, port, dbName, user, password, encrypt, hostNameInCertificate, loginTimeout);
    private Connection conn = null;
    //Statement statement = null; << Attempt to globalize
    
    //Default Constructor
    public DatabaseConnector() {
        try {
            conn = DriverManager.getConnection(url);
            String schema = conn.getSchema();
            System.out.println("Successful connection - Schema: " + schema);
        } catch (SQLException sqle) {
/*<<<<<<< HEAD
            //Should we break the system or something?
=======
>>>>>>> SQL-Connection*/
            sqle.printStackTrace();
            System.err.println("CONNECTION FAILED");
        } finally {
            System.err.println("Attempting 2nd connect...");
            System.out.println((connect()) ? "Connected" : "2nd CONNECT FAIL");
        }
    }

    public boolean connect() {
        try {
            conn = DriverManager.getConnection(url);
            String schema = conn.getSchema();
            System.out.println("Successful connection - Schema: " + schema);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            System.err.println("CONNECTION FAILED");
        }
        return (conn == null) ? false : true;
    }
    public disconnect() {
        //statement = null; << for globalize
        try {
            conn.close();
        } catch (SQLException sqle) {}
        conn = null;
    }

    //SQL Query method for SQL testing
    public ResultSet databaseQuery(String query) {
        //Finish this, figure out other ones...
        ResultSet result = null;
        try {
            Statement statement = conn.createStatement();
            result = statement.executeQuery(query);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            System.err.println("SQL STATEMENT FAILED");
        }
        return result;
    }
}