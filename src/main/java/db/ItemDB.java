package db;

import bo.Item;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;
public class ItemDB extends bo.Item {
    public static Collection searchItems(String item_group){
        Vector v = new Vector();
        try{
            Connection con = DBManager.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select id, name, description from T_ITEM");
            while(rs.next()){
                int i = rs.getInt("id");
                String name = rs.getString("name");
                String desc = rs.getString("description");
                v.addElement(new ItemDB(i, name, desc));
            }
        }catch(SQLException e) { e.printStackTrace(); }
        return v;
    }

    public static ArrayList<Item> getItems(){
        //SQL
        Connection con = null;
        PreparedStatement stmt = null;
        ArrayList<Item> items = new ArrayList<>();
        String user = null, pass = null;
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
    }

    private ItemDB(int id, String name, String desc){
        super(id, name, desc);
    }
}
