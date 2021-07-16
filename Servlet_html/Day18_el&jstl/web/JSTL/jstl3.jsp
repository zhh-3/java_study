<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: zhaha
  Date: 2021/7/14
  Time: 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>foreach标签</title>
</head>
<body>
    <div>
        <%--
            begin:开始值
            end:结束值
            var:临时变量
            step:步长  ？i++ or i+=2 or...
            varStatus:循环状态对象
                index:循环的索引，从0开始
                count:循环的次数，从1开始
        --%>
        <c:forEach begin="1" end="10" var="i" step="2" varStatus="s">
            ${i} ${s.index} ${s.count}<br>
        </c:forEach>

        <%
            List list = new ArrayList();
            list.add("aaa");
            list.add("bbb");
            list.add("ccc");
            request.setAttribute("list", list);
        %>
        <%--
            for(User user : list){

            }
            items:容器对象,相当于list
            var:容器中元素的临时变量,相当于user

        --%>
        <h5>值 索引 次数</h5>
        <c:forEach items="${list}" var="l" varStatus="s">
            ${l} ${s.index} ${s.count}<br>
        </c:forEach>
    </div>
</body>
</html>
