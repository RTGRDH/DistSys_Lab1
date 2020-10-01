package bo;

import java.util.ArrayList;

public class user {
    private String username;
    private String password;
    private ArrayList<Item> items;

    public user(String username, String password){
        this.username = username;
        this.password = password;
        items = null;
    }

    public String getUsername(){
        return this.username;
    }

    public ArrayList<Item> getItems(){
        ArrayList<Item> copy = new ArrayList(this.items);
        return copy;
    }
}
