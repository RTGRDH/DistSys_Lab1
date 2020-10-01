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

    /**
     * Returns if the user exists and the password is correct
     * @param username
     * @param password
     * @return
     * @throws SQLException
     */
    public static Boolean findUser(String username, String password) throws SQLException {
        Connection con = getConnection();
        PreparedStatement stmt = null;
        String query = "SELECT * FROM " + database + ".user WHERE username = '" + username + "'";
        try{
            stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                if(rs.getString(2).equals(password)){
                    return true;
                }else{
                    return false;
                }
            }
        }catch(SQLException e ){
            e.printStackTrace();
        }finally{
            if(stmt != null) { stmt.close(); }
        }
        return false;
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
                        "INTO " + database + ".user(username, password)" +
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
}
