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
                <input type="username" id="username" name="username" />
            </div>
            <div>
                <label for="lastename">Lastname : </label>
                <input type="lastename" id="lastename" name="lastename" />
            </div>
            <div>
                <label for="firstname">Firstname : </label>
                <input type="firstname" id="firstname" name="firstname" />
            </div>
            <div>
                <label for="password">Password : </label>
                <input type="password" id="password" name="password" />
            </div>
            <div>
                <label for="email">Email : </label>
                <input type="email" id="email" name="email" />
            </div>
            <div>
                <label for="zipcode">Zip code : </label>
                <input type="zipcode" id="lastename" name="zipcode" />
            </div>
            <div>
                <input type="submit" value="Register" />
            </div>
        </form>
    </body>
</html>
