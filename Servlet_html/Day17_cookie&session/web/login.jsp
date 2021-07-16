<%--
  Created by IntelliJ IDEA.
  User: zhaha
  Date: 2021/7/12
  Time: 23:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
    <script>
        window.onload = function () {
            document.getElementById("img").onclick = function () {
                this.src = "/Day17/CheckCode?time="+new Date().getTime();
            }
        }
    </script>
</head>
<body>
    <form action="${pageContext.request.contextPath}/loginServlet" method="post">
        <table>
            <tr>
                <td>用户名</td>
                <td><input type="text" name="username"></td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td>验证码</td>
                <td><input type="text" name="checkCode"></td>
            </tr>
            <tr>
                <td colspan="2"><img id="img" src="/Day17/CheckCode"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="登录"></td>
            </tr>
        </table>
    </form>
    <div style="color: red">
        <%
            String err_msg = (String)request.getAttribute("err_msg");
            if (err_msg!=null){
                %>
        <%=err_msg%>
        <%}%>
    </div>


</body>
</html>
