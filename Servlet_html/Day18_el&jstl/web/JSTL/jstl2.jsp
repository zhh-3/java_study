<%--
  Created by IntelliJ IDEA.
  User: zhaha
  Date: 2021/7/14
  Time: 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>choose</title>
</head>
<body>
    <%
        request.setAttribute("day", 2);
    %>
    <div>
        <c:choose>
            <c:when test="${day == 1}">星期一</c:when>
            <c:when test="${day == 2}">星期二</c:when>
            <c:when test="${day == 3}">星期三</c:when>
            <c:when test="${day == 4}">星期四</c:when>
            <c:when test="${day == 5}">星期五</c:when>
            <c:when test="${day == 6}">星期六</c:when>
            <c:when test="${day == 7}">星期日</c:when>
            <c:otherwise>输入超出</c:otherwise>
        </c:choose>
    </div>
</body>
</html>
