package ui;


import java.util.ArrayList;

public class CartInfo {
    private String username;
    private ArrayList<ItemInfo> items;

    public CartInfo(String username) {
        this.username = username;
        this.items = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ArrayList<ItemInfo> getItems() {
        return items;
    }

    public void addItem(ItemInfo newItem) {
        this.items.add(newItem);
    }
}
