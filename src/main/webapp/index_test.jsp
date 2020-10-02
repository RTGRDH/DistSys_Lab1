<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %><%--
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
    if(db.DBManager.findUser("HEJ", "123") == true){
        out.println("Lyckat");
    }else{
        out.println("Misslyckat");
    }
%>
You are logged in as: ${username}
You are logged in as: ${username}
<form action='/hemsida' method='GET'>
    <b>User:</b><input type='text' name='name' >Name</input>
    <button name='getUser' value=' '>Search</button>
</form>
</body>
</html>
