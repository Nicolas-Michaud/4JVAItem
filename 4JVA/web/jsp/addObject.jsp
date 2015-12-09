<%-- 
    Document   : addObject
    Created on : 3 déc. 2015, 16:10:21
    Author     : nicolas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="POST" enctype="multipart/form-data" name="formObj" action="addObject">
            <div>
                <label for="title">Title : </label>
                <input type="text" id="title" name="title" />
            </div>
            <br/>
            <div>
                <label for="description">Description : </label>
                <textarea rows="4" cols="50" id="description" name="description" >Description</textarea>
            </div>
            <br/>
            <div>
                <label for="price">Price : </label>
                <input type="number" id="price" name="price" />
            </div>
            <div>
                <label for="typeof">Type of : </label>
                <input type="text" id="typeof" name="typeof" />
            </div>
            <br/>
            Select file to upload:
            <input type="file" name="fileChooser" id="fileChooser"/>
            <br/>
            <br/>
            <input type="submit" value="Create" />
        </form>
    </body>
</html>
