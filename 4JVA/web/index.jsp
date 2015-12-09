<%-- 
    Document   : login
    Created on : 3 déc. 2015, 16:41:29
    Author     : nicolas
--%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <c:if test="${not empty username}">
            <p>Hello ${username}</p>
        </c:if>
        
        <a href="/4JVA/login"><input type="button" value="Login" name="Login"/></a>
        <a href="/4JVA/addUser"><input type="button" value="Add user" name="addUser"/></a>
        <a href="/4JVA/updateUser"><input type="button" value="Update user" name="updateUser"/></a>
        <a href="/4JVA/addObject"><input type="button" value="Add object" name="addObject"/></a>
        <a href="/4JVA/logout"><input type="button" value="Log Out" name="logout"/></a>
        <a href="/4JVA/listObjects"><input type="button" value="List Objects" name="listObjects"/></a>

        
        
        <div>
            Number of Users : ${countUsers}
            <br/>
            Number of Objects : ${countObjects}
        </div>
        </div>
    </body>
</html>
