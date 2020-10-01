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
    Connection con = null;
    try{
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        String connectionURL = "jdbc:mysql://localhost:3306/test_user" + "?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
        con = DriverManager.getConnection(connectionURL, "root", "Test1234");
        /*PreparedStatement stmt = null;
        try{
            stmt = con.prepareStatement("SELECT * FROM test_user.user");
            ResultSet rs = stmt.executeQuery("SELECT * FROM test_user.user");
            while(rs.next()){
                out.println(rs.getString(1) + ", " + rs.getString(2));
            }
        }finally {
            stmt.close();
        }*/ //DETTA FUNGERAR. ^
        //con = DriverManager.getConnection("jdbc:mysql://localhost/carl-bernhardhallberg", "root", "123");
    }catch(Exception e)
    {
        e.printStackTrace();
        out.println("Fail");
    }
%>
</body>
</html>
