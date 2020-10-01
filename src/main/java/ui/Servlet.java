package ui;

import bo.UserHandler;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("webshop.jsp");
        if(request.getParameter("getUser") != null) {
            request.setAttribute("username", UserHandler.getUser(request.getParameter("name")).getPassword());
        }else{
            request.setAttribute("username", "null");
        }
        rd.forward(request, response); //ALLTID SLUTET
    }
}
