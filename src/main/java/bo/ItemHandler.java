package bo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import ui.ItemInfo;
public class ItemHandler {
    public static Collection<ItemInfo> getItemsWithGroup(String s){
        Collection c = Item.searchItems(s);
        ArrayList<ItemInfo> items = new ArrayList<ItemInfo>();
        for(Iterator it = c.iterator(); it.hasNext();){
            Item item = (Item) it.next();
            items.add(new ItemInfo(item.getName(), item.getDescription()));
        }
        return items;
    }

    public static ItemInfo getItem(String item){
        Item i = Item.getItem(item);
        ItemInfo itemI = new ItemInfo(i.getName(), i.getDescription());
        return itemI;
    }

    public static ArrayList<ItemInfo> getItems(){
        ArrayList<Item> it = Item.getItems();
        ArrayList<ItemInfo> items = new ArrayList<>();
        for(int i = 0; i < it.size(); i++){
            Item item = (Item) it.get(i);
            items.add(new ItemInfo(item.getName(), item.getDescription()));
        }
        return items;
    }

    public static void addItemToCart(String username, String item){

    }
}
