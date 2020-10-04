<%@ page import="bo.*" %>
<%@ page import="ui.ItemInfo" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="db.DBUser" %>
<%@ page import="ui.UserInfo" %><%--
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
<%
    if(request.getParameter("login") != null && request.getParameter("username") != "" && request.getParameter("password") != ""){
        UserInfo user = new UserInfo(request.getParameter("username"), request.getParameter("password"));
        if(UserHandler.getUser(user.getUsername(), user.getPassword()) != null){
            session.setAttribute("username", user.getUsername());
        }
    }
%>
    <div class = "login">
        <form>
            <%
                if(session.getAttribute("username") != null){%>
                <label>You are logged in as: <%=session.getAttribute("username")%></label>
                <%
            }else{%>
                <label>You are logged in as: null</label>
<%
            }%>
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
                    <td><button type="submit" name="login" value=" ">Login</button></td>
                    <td><button type="submit" name=createUser" value=" ">Create User</button></td>
                </tr>
                </tbody>
            </table>
        </form>
    </div>
    <div class="items">
    <form>
        <%
            ArrayList<ItemInfo> items = ItemHandler.getItems();
            for(int i = 0; i < items.size(); i++){
                %>
                <table border="3">
                    <tr>
                        <td>Item</td>
                        <td>Description</td>
                    </tr>
                    <tr>
                        <td><%=items.get(i).getName()%></td>
                        <td><%=items.get(i).getDescription()%></td>
                    </tr>
                    <tr>
                        <td><button name='addItem<%=i%>' value='add'>Add</button></td>
                        <td><button name='removeItem<%=i%>' value='remove'>Remove</button></td>
                    </tr>
                </table>

            <%}
            for(int i = 0; i < items.size(); i++)
            {
                if(request.getParameter("addItem"+i) != null )
                {
                    if(session.getAttribute("username") != null){
                        CartHandler.addToCart(items.get(i).getName(), i, session.getAttribute("username").toString());
                    }
                }else if(request.getParameter("removeItem"+i) != null){
                    if(session.getAttribute("username") != null){
                        CartHandler.removeFromCart(items.get(i).getName(), session.getAttribute("username").toString());
                    }
                }
            }
            %>

    </form>
</div>
            <div class="shoppingCart">
                <fieldset>
                    <legend>Shopping cart</legend>
                    <%
                        if(session.getAttribute("username") != null){
                            for(int i = 0; i < CartHandler.getCart(session.getAttribute("username").toString()).getItems().size(); i++){
                                %>
                                <tr>
                                    <td><%=CartHandler.getCart(session.getAttribute("username").toString()).getItems().get(i).getName()%></td>
                                </tr>
                                <br><%
                            }
                        }%>
                </fieldset>
            </div>
</body>
</html>
