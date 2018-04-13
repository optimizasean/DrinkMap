package drinkdb;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;

public class DatabaseConnector {
    String hostName = "drinkmap.database.windows.net";
    String port = "1433";
    String dbName = "DrinkMap";
    String user = "Application";
    String password = "s5#d(V)2`c Ldj2#9!~";
    String encrypt = "true";
    String loginTimeout = "30";
    String url = String.format("jdbc:sqlserver://%s:%s;database=%s;user=%s;password=%s;encrypt=%s;hostNameInCertificate=*.database.windows.net;loginTimeout=%s;",
        hostName, port, dbName, user, password, encrypt, loginTimeout);
    Connection connection = null;

    //Default Constructor
    public DatabaseConnector() {
        try {
            connection = DriverManager.getConnection(url);
            String schema = connection.getSchema();
            System.out.println("Successful connection - Schema: " + schema);
        } catch (SQLException sqle) {
            System.err.println("CONNECTION FAILED");
        }
    }

    //SQL Query method
    public ResultSet databaseQuery() {
        return null;
    }
}
