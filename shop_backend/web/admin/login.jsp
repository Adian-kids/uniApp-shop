<%--
  Created by IntelliJ IDEA.
  User: 24815
  Date: 2021/11/2
  Time: 18:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>登陆</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <div class="page-header">
        <div class="container">
            <h1>后台登录系统<small>微商城
            </small></h1>
        </div>
    </div>

</head>

<body>
<div class="row">
    <div class="col-md-4"></div>
    <div class="col-md-4">
        <form class="form-horizontal" role="form" action="../admin" method="GET">
            <div class="form-group">
                <label for="username" class="col-sm-2 control-label">用户名</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="username" name="username"
                           placeholder="请输入用户名">
                </div>
            </div>
            <div class="form-group">
                <label for="passwd" class="col-sm-2 control-label">密码</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="passwd" name="passwd"
                           placeholder="请输入密码">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <br>
                    <button type="submit" class="btn btn-primary">登陆</button>
                </div>
            </div>
        </form>
        <c:if test="${loginResult == 0}">
            <div class="alert alert-danger" role="alert">用户名或密码错误</div>
        </c:if>
        <c:if test="${loginResult == 1}">
            <div class="alert alert-success" role="alert">登陆成功</div>
            <script> window.location.href = "goodManage"</script>
        </c:if>
    </div>
    <div class="col-md-4"></div>
</div>
</body>
</html>