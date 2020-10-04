package bo;

import sun.jvm.hotspot.StackTrace;
import ui.CartInfo;
import ui.ItemInfo;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

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

     public static void addToCart(String itemName, int i, String username){
         Cart c = Cart.getCart(username);
         int quantity = 0;
         for(int j = 0; j < c.getItemSize(); j++){
             if(c.getItems().get(j).getName().equals(itemName)){
                 quantity++;
             }
         }
         c.addItemToCart(new ItemInfo(itemName, ItemHandler.getItem(itemName).getDescription()), username, quantity);
    }

    static public void removeFromCart(String itemname, String username){
        Cart c = Cart.getCart(username);
        int quantity = 0;
        for(int i = 0; i < c.getItemSize(); i++){
            if(c.getItems().get(i).getName().equals(itemname)){
                quantity++;
            }
        }
        if((quantity - 1) == 0){
            c.removeItem(itemname, username);
        }else{
            quantity--;
            c.removeItem(itemname, username, quantity);
        }
    }
}
