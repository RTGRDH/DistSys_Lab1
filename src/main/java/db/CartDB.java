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
            String query = "SELECT itemname FROM cart WHERE username = '" + username + "'";
            stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                ItemInfo item = new ItemInfo(ItemHandler.getItem(rs.getString(1)).getName(), ItemHandler.getItem(rs.getString(1)).getDescription());
                cart.addItemToCart(item);
            }
        }catch(SQLException e ){
            e.printStackTrace();
        }
        return cart;
    }

    public static void addItem(String item, String username){
        Connection con = null;
        Statement stmt = null;
        try{
            con = DBManager.getConnection();
            String query = "INSERT INTO cart(username, itemname) VALUES('" + username + "', '" + item + "')";
            stmt = con.createStatement();
            stmt.executeUpdate(query);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
