package drinkdb;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;

public class DatabaseConnector {
    String hostName = "drinkmap.database.windows.net";
    String dbname = "DrinkMap";
    String user = "Application";
    String password = "s5#d(V)2`c Ldj2#9!~";
    String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;hostNameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
    Connection connection = null;

    //Default Constructor
    public DatabaseConnector() {

    }


}
