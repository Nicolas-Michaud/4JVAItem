<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${not empty username}">
    <%@include file="template/user/head.jsp" %>
</c:if>
<c:if test="${empty username}">
    <%@include file="template/head.jsp" %>
</c:if>

<div class="container">
    <div class="row">
        <div class="col-mg-4 form-div">
            <form method="POST">
                <div class="form-group">
                    <input type="text" class="form-control" id="username" name="username" value="${user.username}" disabled="true" />
                    <input type="text" class="form-control" id="lastename" name="lastname" value="${user.lastname}" />
                    <input type="text" class="form-control" id="firstname" name="firstname" value="${user.firstname}" />
                    <input type="password" class="form-control" id="password" name="password" value="${user.password}" />
                    <input type="email" class="form-control" id="email" name="email" value="${user.email}"/>
                    <input type="number" class="form-control" id="zipcode" name="zipcode" value="${user.zipcode}"/>
                </div>

                <div class="form-group">
                    <button type="submit" class="btn btn-primary submit-btn">Update</button>
                </div>
            </form>
        </div>
    </div>
</div>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${not empty username}">
<%@include file="template/user/scripts.jsp" %>
</c:if>
<c:if test="${empty username}">
    <%@include file="template/scripts.jsp" %>
</c:if>
</body>
</html>