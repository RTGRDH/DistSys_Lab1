package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager {
    private static DBManager instance = null;
    private Connection con = null;

    private static DBManager getInstance(){
        if(instance == null){
            instance = new DBManager();
        }
        return instance;
    }
    private DBManager(){
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_user", "root", "");
            System.out.println("Hej");
            //con = DriverManager.getConnection("jdbc:mysql://localhost/carl-bernhardhallberg", "root", "123");
        }catch(Exception e) { e.printStackTrace(); }
    }

    public static Connection getConnection(){
        return getInstance().con;
    }

    public static Boolean findUser(String username, String password){

        try{
            Connection con = getConnection();
            //Använd con för att hitta user med username och password.
            //Returnera true om den hittas, annars false. Default är false
            return true;
        }catch(Exception e) { e.printStackTrace(); }
        return true;
    }

    public static void createUser(String username, String password) throws SQLException {
        Statement createUser = null;
        Connection con = null;
        try{
            con = getConnection();
            con.setAutoCommit(false);
            if(username != null && password != null){
                createUser = con.createStatement();
                String query = "INSERT" +
                        "INTO user(username, password)" +
                        "VALUES('"+ username + "', '" + password + "')";
                createUser.executeQuery(query);
                con.setAutoCommit(true);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(con != null){
                con.close();
            }
        }
    }

    public static String toLow(String t){ return t.toLowerCase(); }
}
