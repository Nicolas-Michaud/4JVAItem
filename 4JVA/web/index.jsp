<%-- 
    Document   : login
    Created on : 3 déc. 2015, 16:41:29
    Author     : nicolas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <c:if test="${username != null}">
            <p>Hello ${username}</p>
        </c:if>
        
        <a href="/4JVA/login"><input type="button" value="Login" name="Login"/></a>
        <a href="/4JVA/addUser"><input type="button" value="Add user" name="addUser"/></a>
        <a href="/4JVA/logout"><input type="button" value="LogOut" name="lougout"/></a>
        
        <div>
            <label>Number of Users : ${countUsers}</label>
        </div>
    </body>
</html>
