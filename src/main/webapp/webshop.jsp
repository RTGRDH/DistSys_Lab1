<%--
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
You are logged in as: <%= request.getParameter("username")%>
</body>
</html>
