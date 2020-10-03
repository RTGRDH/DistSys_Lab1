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

    static public void addToCart(String itemName, int i){

    }




    static public void removeFromCart(String itemname, int i){

    }
}
