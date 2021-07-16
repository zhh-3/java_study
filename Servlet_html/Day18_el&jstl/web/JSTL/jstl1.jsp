<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: zhaha
  Date: 2021/7/14
  Time: 9:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div>
        <c:if test="true">
            <h1>直接真...</h1>
        </c:if>
        <%
            List list = new ArrayList();
            list.add("aaa");
            request.setAttribute("list", list);

            request.setAttribute("number", 2);
            request.setAttribute("num", 3);
        %>
        <c:if test="${not empty list}">
            列表循环.....
        </c:if><br>
        <c:if test="${number % 2 == 0}">
            ${number} 是偶数
        </c:if><br>
        <c:if test="${num % 2 != 0}">
            ${num} 是奇数
        </c:if><br>
    </div>
</body>
</html>
