<%-- 
    Document   : addUser
    Created on : 3 déc. 2015, 16:10:12
    Author     : nicolas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bartering - Add User</title>
    </head>
    <body>
        <form method="POST">
            <div>
                <label for="username">Username : </label>
                <input type="text" id="username" name="username" value="${user.username}" disabled="true" />
            </div>
            <div>
                <label for="lastname">Lastname : </label>
                <input type="text" id="lastename" name="lastname" value="${user.lastname}" />
            </div>
            <div>
                <label for="firstname">Firstname : </label>
                <input type="text" id="firstname" name="firstname" value="${user.firstname}" />
            </div>
            <div>
                <label for="password">Password : </label>
                <input type="password" id="password" name="password" value="${user.password}" />
            </div>
            <div>
                <label for="email">Email : </label>
                <input type="email" id="email" name="email" value="${user.email}"/>
            </div>
            <div>
                <label for="zipcode">Zip code : </label>
                <input type="text" id="zipcode" name="zipcode" value="${user.zipcode}"/>
            </div>
            <div>
                <input type="submit" value="Update" />
            </div>
        </form>
    </body>
</html>
