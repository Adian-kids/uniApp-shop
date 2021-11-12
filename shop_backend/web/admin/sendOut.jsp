<%--
  Created by IntelliJ IDEA.
  User: 24815
  Date: 2021/11/2
  Time: 18:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="header.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <form class="form-horizontal" role="form" action="sendAction" method="GET">
        <div class="form-group">
            <div class="col-sm-10">
                <input class="form-control" id="orderId" type="hidden" name="orderId" value="${orderId}">
            </div>
        </div>

        <div class="form-group">
            <label for="express" class="col-sm-2 control-label">物流单号</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="express" name="express"
                       placeholder="请输入物流单号">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <br>
                <button type="submit" class="btn btn-primary">发货</button>
            </div>
        </div>
    </form>
    <c:if test="${updateResult == 1}">
        <div class="alert alert-success" role="alert">发货成功</div>
        <script> window.location.href = "orderManage"</script>
    </c:if>
</div>


</body>
</html>
