package db;

import bo.Cart;
import bo.Item;
import bo.ItemHandler;
import ui.ItemInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    /*public static ArrayList<Item> getItems(){
        //SQL
        Connection con = null;
        PreparedStatement stmt = null;
        ArrayList<Item> items = new ArrayList<>();
        try{
            con = DBManager.getConnection();
            String query = "SELECT * FROM item";
            stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                items.add(new ItemDB(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return items;
    }*/

}
