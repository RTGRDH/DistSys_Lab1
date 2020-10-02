<%@ page import="bo.ItemHandler" %>
<%@ page import="bo.Item" %>
<%@ page import="bo.UserHandler" %>
<%@ page import="bo.CartHandler" %><%--
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
You are logged in as: ${username}
<form action='/hemsida' method='GET'>
    <b>User:</b><input type='text' name='name' >Name</input>
    <button name='getUser' value=' '>Search</button>
</form>
<%
    if(CartHandler.getCart("test").getItems() != null) {
        for (int i = 0; i < CartHandler.getCart("test").getItems().size(); i++) {
            out.println(CartHandler.getCart("test").getItems().get(i).getName());
        }
    }
%>
<%
    for(int i = 0; i < ItemHandler.getItems().size(); i++)
    {%>
        <form action='/hemsida' method='POST'>
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
                    <td><button name='addToCart' value=' '>Add</button></td>
                    <td><button name='removeFromCart' value=' '>Remove</button></td>
                </tr>
            </table>
            <%
    }
    %>
            <fieldset>
                <legend>Shopping cart</legend>
                <%
                for(int i = 0; i < 10; i++)
                {%>
                    <!-- Item 1 -->
                    <br>
                    <!-- Item 2.. -->
                    <%
                }%>
            </fieldset>
</body>
</html>
