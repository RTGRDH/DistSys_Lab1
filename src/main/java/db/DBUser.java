package db;

import bo.User;

import java.sql.*;

public class DBUser extends bo.User{
    private String database = "test_user";

    private DBUser(String username, String password) {
        super(username, password);
    }

    public static DBUser getUser(String username){
        //SQL
        Connection con = null;
        PreparedStatement stmt = null;
        String user = null, pass = null;
        try{
            con = DBManager.getConnection();
            String query = "SELECT username, password FROM user WHERE username = ?";
            stmt = con.prepareStatement(query);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            user = rs.getString("username");
            pass = rs.getString("password");
        }catch(SQLException e){
            e.printStackTrace();
        }
        return new DBUser(user, pass);
    }

    public Boolean findUser(String username, String password) throws SQLException {
        Connection con = DBManager.getConnection();
        PreparedStatement stmt = null;
        String query = "SELECT * FROM " + this.database + ".user WHERE username = '" + username + "'";
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

    public void createUser(String username, String password) throws SQLException {
        Statement createUser = null;
        Connection con = null;
        try{
            con = DBManager.getConnection();
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
