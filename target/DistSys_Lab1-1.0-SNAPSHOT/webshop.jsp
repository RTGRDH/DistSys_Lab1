<%@ page import="bo.*" %><%--
  Created by IntelliJ IDEA.
  User: ernstreutergardh
  Date: 2020-10-01
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Webshop</title>
    <link rel="stylesheet" href="main.css">
</head>
<body>
    <div class = "login">
        <label>You are logged in as: ${username}</label>
        <form action='/hemsida' method='GET'>
            <b>Username:</b><input type='text' name='userName' >Name</input>
            <button name='getUser' value=' '>Search</button>
        </form>
    </div>
    <div class="items">
<%
    for(int i = 0; i < ItemHandler.getItems().size(); i++)
    {%>

        <form action ="/hemsida" method='POST'>
            <table border="3">
                <tbody>
                <tr>
                    <td>Item</td>
                    <td><%=ItemHandler.getItems().get(i).getName()%></td>
                </tr>
                <tr>
                    <td>Description</td>
                    <td><%=ItemHandler.getItems().get(i).getDescription()%></td>
                </tr>
                <tr>
                    <td><button type="submit" name='addItem<%=i%>' value=' '>Add</button></td><!-- KOPPLA TILL CartHandler.addToCart(itemname) -->
                    <%if (request.getParameter("addItem" + i) != null) {
                        CartHandler.addToCart(ItemHandler.getItems().get(i).getName(),i, "test");
                    }%>
                    <td><button type="submit" name='removeItem<%=i%>' value=' '>Remove</button></td> <!-- KOPPLA TILL CartHandler.removeFromCart(itemname) -->
                    <%if (request.getParameter("removeItem" + i) != null) {
                        CartHandler.removeFromCart(ItemHandler.getItems().get(i).getName(),i);
                    }%>
                </tr>
            </table>
        </form>
            <%
    }
    %>
    </div>
            <div class="shoppingCart">
                <fieldset>
                    <legend>Shopping cart</legend>
                    <%
                    for(int i = 0; i < CartHandler.getCart("test").getItems().size(); i++)
                    {%>
                    <tr>
                        <td><%=CartHandler.getCart("test").getItems().get(i).getName()%></td>
                    </tr>
                        <%
                    }%>
                </fieldset>
            </div>
</body>
</html>
