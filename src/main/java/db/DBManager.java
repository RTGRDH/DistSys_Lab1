package db;

import java.sql.Connection;
import java.sql.DriverManager;
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
            con = DriverManager.getConnection("jdbc:mysql://localhost/ernstreutergardh", "root", "");
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
        }catch(Exception e) { e.printStackTrace(); }
        return false;
    }

    public static String toLow(String t){ return t.toLowerCase(); }
}
