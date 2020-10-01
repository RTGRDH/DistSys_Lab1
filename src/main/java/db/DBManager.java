package db;

import java.sql.*;

public class DBManager {
    private static DBManager instance = null;
    private Connection con = null;
    private static String database = "test_user";

    private static DBManager getInstance(){
        if(instance == null){
            instance = new DBManager();
        }
        return instance;
    }
    private DBManager(){
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String connectionURL = "jdbc:mysql://localhost:3306/" + this.database + "?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
            //Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(connectionURL, "root", "Test1234");
            //con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + this.database, "root", "Test1234");
            //con = DriverManager.getConnection("jdbc:mysql://localhost/carl-bernhardhallberg", "root", "123");
        }catch(Exception e) { e.printStackTrace(); }
    }

    public static Connection getConnection(){
        return getInstance().con;
    }
}
