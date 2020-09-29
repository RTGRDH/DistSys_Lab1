<%--
  Created by IntelliJ IDEA.
  User: ernstreutergardh
  Date: 2020-09-30
  Time: 00:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login prompt</title>
</head>
<body>
<%
    String userID = request.getParameter("userName");
    String password = request.getParameter("password");
    if(password != null && userID != null)
    {
        session.setAttribute("userID",userID); %>
You are logged in as: <%= userID%>
<%
    }
else {%>
<form method="post" action="login.jsp">
    <table border="3">
        <tbody>
        <tr>
            <td>Username</td>
            <td><input type="text" name="uname" value=""></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="text" name="password" value=""></td>
        </tr>
        <tr>
            <td><input type="submit" value="Login"></td>
        </tr>
        </tbody>
    </table>
</form>
<%}%>

</body>
</html>
