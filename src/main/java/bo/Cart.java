package bo;

import db.CartDB;
import ui.ItemInfo;

import java.util.ArrayList;

public class Cart {

    private String username;
    private ArrayList<ItemInfo> items;

    protected Cart(String username){
        this.username = username;
        items = new ArrayList<>();
    }

    public void addItemToCart(ItemInfo newItem){
        items.add(newItem);
    }

    public void addItemToCart(ItemInfo newItem, String username, int currentQuantity){
        if(currentQuantity != 0){
            CartDB.addItem(newItem.getName(), username, currentQuantity);
        }else{
            CartDB.addItem(newItem.getName(), username);
        }

        items.add(newItem);
    }

    public static void removeItem(String item, String username){
        CartDB.removeItem(item, username);
        //items.remove(item);
    }

    public static void removeItem(String item, String username, int newQuantity){
        CartDB.removeItem(item, username, newQuantity);
        //items.remove(item);
    }

    public static Cart getCart(String username){
        return CartDB.getCart(username);
    }

    public int getItemSize(){
        return items.size();
    }

    public ArrayList<ItemInfo> getItems(){
        return this.items;
    }

    public ItemInfo getItemFromCart(int index){
        return items.get(index);
    }
}
