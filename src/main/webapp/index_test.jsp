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
    if(UserHandler.getUser("test")){
        out.println("Lyckat");
    }else{
        out.println("Misslyckat");
    }
%>
</body>
</html>
