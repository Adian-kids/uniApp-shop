<%--
  Created by IntelliJ IDEA.
  User: 24815
  Date: 2021/11/2
  Time: 18:45
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
    <form class="form-horizontal" role="form" action="../goodAdd" method="GET">

        <div class="form-group">
            <label for="title" class="col-sm-2 control-label">商品名称</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="title" name="title"
                       placeholder="请输入商品名称">
            </div>
        </div>
        <div class="form-group">
            <label for="content" class="col-sm-2 control-label">商品描述</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="content" name="content"
                       placeholder="请输入商品描述">
            </div>
        </div>
        <div class="form-group">
            <label for="price" class="col-sm-2 control-label">商品价格</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="price" name="price"
                       placeholder="请输入商品价格">
            </div>
        </div>
        <div class="form-group">
            <label for="img" class="col-sm-2 control-label">商品图片地址</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="img" name="img"
                       placeholder="请输入商品图片地址">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <br>
                <button type="submit" class="btn btn-primary">添加商品</button>
            </div>
        </div>
    </form>
    <c:if test="${addResult == 1}">
        <div class="alert alert-success" role="alert">添加成功</div>
        <script> window.location.href = "goodManage"</script>
    </c:if>
</div>


</body>
</html>
