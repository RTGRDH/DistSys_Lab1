<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="bo.UserHandler" %><%--
  Created by IntelliJ IDEA.
  User: ernstreutergardh
  Date: 2020-09-29
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%

      String l= bo.CartHandler.addToCart();
    out.println("kooo:"+l);
%>










<div class="items">
    <%
        ArrayList<ItemInfo> items = ItemHandler.getItems();
        //CartHandler.removeFromCart("äpple", "test");
        for(int i = 0; i < items.size(); i++)
        {%>
    <form action ="/hemsida" method='POST'>
        <table border="3">
            <tr>
                <td>Item</td>
                <td><%=items.get(i).getName()%></td>
            </tr>
            <tr>
                <td>Description</td>
                <td><%=items.get(i).getDescription()%></td>
            </tr>
            <tr>
                <td><button name='addItem<%=i%>' value='add'>Add</button></td><!-- KOPPLA TILL CartHandler.addToCart(itemname) -->
                <td><button name='removeItem<%=i%>' value=' '>Remove</button></td> <!-- KOPPLA TILL CartHandler.removeFromCart(itemname) -->
            </tr>
        </table>
    </form>
    <%
        }
        for (int i = 0; i < items.size(); i++)
        {
            if(request.getParameter("addItem"+i) != null)
            {
                System.out.println("HEEJEJEJEJJE");
            }
        }
    %>
</div>








</body>
</html>
