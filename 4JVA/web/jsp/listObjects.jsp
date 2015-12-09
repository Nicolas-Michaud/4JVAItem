<%-- 
    Document   : listObjects
    Created on : 6 déc. 2015, 16:03:23
    Author     : nicolas
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <ul>
            <c:forEach items="${listObjects}" var="obj">
                <li><c:out value="${obj.title} ${obj.price} "/>
                    <a href="/4JVA/detailObject">View details</a>
                </li>
            </c:forEach>
        </ul>
    </body>
</html>
