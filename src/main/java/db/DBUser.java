package db;

import bo.User;

import java.sql.*;

public class DBUser extends bo.User{

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

    public static void createUser(String username, String password) throws SQLException {
        Statement createUser = null;
        Connection con = null;
        try{
            con = DBManager.getConnection();
            createUser = con.createStatement();
            String q = "INSERT INTO test_user.user(username, password) VALUES('" + username +"', '" + password + "')";
            createUser.executeUpdate(q);
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
