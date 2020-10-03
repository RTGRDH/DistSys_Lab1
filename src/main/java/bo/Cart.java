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

    public void addItemToCart(ItemInfo newItem, String username){
        CartDB.addItem(newItem.getName(), username);
        items.add(newItem);
    }

    public static Cart getCart(String username){
        return CartDB.getCart(username);
    }

    public int getItemSize(){
        return items.size();
    }

    public ItemInfo getItemFromCart(int index){
        return items.get(index);
    }
}
