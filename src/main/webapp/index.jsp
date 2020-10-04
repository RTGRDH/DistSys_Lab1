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
    String username = request.getParameter("userName");
    String password = request.getParameter("password");
    if(password != null && username != null)
    {
        session.setAttribute("userName", username);
        if(db.DBUser.findUser(username, password) == true)
        {%>
            <jsp:forward page="webshop.jsp">
            <jsp:param name="userName" value="<%=username%>"/>
            </jsp:forward>
<%      }
        else
        {
            //Du kom inte in, ingen användare hittades
       }

    }
else {%>
<form action='/hemsida' method='GET'>
    <b>Username:</b><input type='text' name='userName' >Name</input>
    <button name='getUser' value=' '>Search</button>
</form>
<%}%>
<form method="GET" action="/hemsida">
    <label>You are logged in as: ${username}</label>
    <table border="3">
        <tbody>
        <tr>
            <td>Username</td>
            <td><input type="text" name="username" value=""></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="password" value=""></td>
        </tr>
        <tr>
            <td><button type="submit" value=" ">Login</button></td>
        </tr>
        </tbody>
    </table>
</form>
</body>
</html>
