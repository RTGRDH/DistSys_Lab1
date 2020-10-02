package bo;

import db.DBUser;
import db.ItemDB;

import java.util.ArrayList;
import java.util.Collection;
public class Item {
    private String name;
    private String desc;
    private int id;
    static public Collection searchItems(String group){
        return ItemDB.searchItems(group);
    }

    protected Item(int id, String name, String desc){
        this.id = id;
        this.name = name;
        this.desc = desc;
    }

    public static Item getItem(String itemname){
        return ItemDB.getItem(itemname);
    }

    public static ArrayList<Item> getItems(){
        return ItemDB.getItems();
    }

    public String getName(){
        return this.name;
    }

    public void setName(String newName){
        this.name = newName;
    }

    public String getDescription(){
        return this.desc;
    }

    public void setDescription(String newDesc){
        this.name = newDesc;
    }
}
