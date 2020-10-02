package bo;

import ui.CartInfo;
import ui.ItemInfo;

import java.util.ArrayList;

public class CartHandler {

    public static CartInfo getCart(String username){
        Cart c = Cart.getCart(username);
        CartInfo cart = new CartInfo(username);
        for(int i = 0; i < c.getItemSize(); i++){
            ItemInfo item = new ItemInfo(c.getItemFromCart(i).getName(), c.getItemFromCart(i).getDescription());
            cart.addItem(item);
        }
        return cart;
    }

    public void addToCart(String itemname){

    }

    public void removeFromCart(String itemname){

    }
}
