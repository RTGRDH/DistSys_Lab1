package db;

import bo.Cart;
import bo.Item;
import bo.ItemHandler;
import ui.ItemInfo;

import java.sql.*;
import java.util.ArrayList;

public class CartDB extends bo.Cart {

    private CartDB(String username) {
        super(username);
    }

    public static Cart getCart(String username){
        Connection con = null;
        PreparedStatement stmt = null;
        CartDB cart = new CartDB(username);
        try{
            con = DBManager.getConnection();
            String query = "SELECT itemname, quantity FROM cart WHERE username = '" + username + "'";
            stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                for(int i = 0; i < rs.getInt(2); i++){
                    ItemInfo item = new ItemInfo(ItemHandler.getItem(rs.getString(1)).getName(), ItemHandler.getItem(rs.getString(1)).getDescription());
                    cart.addItemToCart(item);
                }
            }
        }catch(SQLException e ){
            e.printStackTrace();
        }
        return cart;
    }

    public static void removeItem(String item, String username){
        Connection con = null;
        Statement stmt = null;
        try{
            con = DBManager.getConnection();
            String query = "DELETE FROM cart WHERE itemname = '" + item + "' AND username = '" + username + "'";
            stmt = con.createStatement();
            stmt.executeUpdate(query);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static void removeItem(String item, String username, int newQuantity){
        Connection con = null;
        Statement stmt = null;
        try{
            con = DBManager.getConnection();
            String query = "UPDATE cart SET quantity = '" + newQuantity + "' WHERE username = '" + username + "' AND itemname = '" + item + "';";
            stmt = con.createStatement();
            stmt.executeUpdate(query);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static void addItem(String item, String username, int currentQuantity){
        Connection con = null;
        Statement stmt = null;
        currentQuantity += 1;
        try{
            con = DBManager.getConnection();
            String query = "UPDATE test_user.cart SET quantity = '" + currentQuantity + "' WHERE username = '" + username + "' AND itemname = '" + item + "';";
            stmt = con.createStatement();
            stmt.executeUpdate(query);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static void addItem(String item, String username){
        Connection con = null;
        Statement stmt = null;
        try{
            con = DBManager.getConnection();
            String query = "INSERT INTO test_user.cart(username, itemname, quantity) VALUES('" + username + "', '" + item + "', '1')";
            stmt = con.createStatement();
            stmt.executeUpdate(query);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
