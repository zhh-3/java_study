<%--
  Created by IntelliJ IDEA.
  User: zhaha
  Date: 2021/7/13
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    ${3 > 4}
    \${3 > 4}
    <hr>
    <h3>算数运算符</h3>
    ${3 / 4}<br>
    ${3 div 4}<br>
    ${3 % 4}<br>
    ${3 mod 4}<hr>
    <%
        String str1 = "123";
        String str2 = null;
        String str3 = "";
        request.setAttribute("str1", str1);
        request.setAttribute("str2", str2);
        request.setAttribute("str3", str3);
    %>
    str1 is empty ? ${empty str1} ${str1}<br>
    str2 is empty ? ${empty str2}<br>
    str3 is empty ? ${empty str3}<br>
</body>
</html>
