package bo;

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

    public void addToCart(String itemname, int i, HttpServletRequest request, HttpServletResponse response){
        RequestDispatcher rd = request.getRequestDispatcher("webshop.jsp");
        if(request.getParameter("addToCart"+i) != null)
        {

        }
    }

    public void removeFromCart(String itemname, int i, HttpServletRequest request, HttpServletResponse response){
        if(request.getParameter("removeFromCart"+i) != null)
        {

        }
    }
}
