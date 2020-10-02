<%@ page import="bo.ItemHandler" %>
<%@ page import="bo.Item" %>
<%@ page import="bo.UserHandler" %><%--
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
</head>
<body>
You are logged in as: ${username}
<form action='/hemsida' method='GET'>
    <b>User:</b><input type='text' name='name' >Name</input>
    <button name='getUser' value=' '>Search</button>
<%
    out.println(ItemHandler.getItems().get(0).getName() + ItemHandler.getItems().get(1).getName());
%>
</form>
</body>
</html>
