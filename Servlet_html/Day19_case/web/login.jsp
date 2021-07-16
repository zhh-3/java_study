<%--
  Created by IntelliJ IDEA.
  User: zhaha
  Date: 2021/7/14
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>管理员登录</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/login.css">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="js/jquery.min.js" ></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript">
        function refreshCode() {
            var img = document.getElementById("vcode");
            img.src = "${pageContext.request.contextPath}/CheckCode?time="+new Date().getTime();
        }
    </script>
</head>
<body>
    <div class="container div">
        <h3 style="text-align: center">管理员登录</h3>
        <form action="${pageContext.request.contextPath}/LoginServlet" method="post">
            <div class="form-group">
                <label for="exampleInputEmail1">用户名</label>
                <input type="text" class="form-control" id="exampleInputEmail1" placeholder="请输入用户名" name="username">
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">密码</label>
                <input type="password" class="form-control" id="exampleInputPassword1" placeholder="请输入密码" name="password">
            </div>
            <div class="form-inline">
                <label for="vcode">验证码</label>
                <input type="text" name="verifycode" class="form-control">
                <a href="javascript:refreshCode();"><img src="${pageContext.request.contextPath}/CheckCode" title="看不清，点击刷新" id="vcode"></a>
            </div>
            <hr>
            <div class="form-group" style="text-align: center">
                <input type="submit" class="btn btn-primary btn-lg" value="登录">
            </div>
        </form>

        <c:if test="${not empty login_msg}">
            <div class="alert alert-warning alert-dismissable" role="alert">
                <button type="button" class="close" data-dismiss="alert">
                    <span>x</span>
                </button>
                <strong>${login_msg}</strong>
            </div>
        </c:if>
    </div>
</body>
</html>
