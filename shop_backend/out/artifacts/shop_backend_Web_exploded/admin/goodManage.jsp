<%--
  Created by IntelliJ IDEA.
  User: 24815
  Date: 2021/11/2
  Time: 18:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="header.jsp"%>
<html>
<head>
    <title>商品管理</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<c:if test="${deleteResult == 1}">
    <div class="alert alert-success" role="alert">删除成功</div>
    <script> window.location.href = "goodManage"</script>
</c:if>

<div class="container">
    <div class="jumbotron">
        <c:forEach var="good" items="${goodList}">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">
                        商品
                    </h3>
                </div>
                <div class="panel-body">
                    <img src="${good.img}" alt="Paris" width="100" height="100">
                    ${good.title}
                </div>
                <a href="goodDelete?goodId=${good.goodId}" class="list-group-item">删除</a>
            </div>

        </c:forEach>
    </div>
</div>

</body>
</html>
