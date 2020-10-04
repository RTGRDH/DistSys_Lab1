package bo;

import db.DBUser;

import java.sql.SQLException;
import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private ArrayList<Item> items;

    public User(String username, String password){
        this.username = username;
        this.password = password;
        items = null;
    }

    public static User getUser(String username){
        return DBUser.getUser(username);
    }

    public static void createUser(String username, String password) throws SQLException {
        DBUser.createUser(username, password);
    }

    public String getUsername(){
        return this.username;
    }

    public ArrayList<Item> getItems(){
        ArrayList<Item> copy = new ArrayList(this.items);
        return copy;
    }

    public String getPassword(){
        return this.password;
    }
}
