<%@ page import="domain.User" %>
<%@ page import="java.util.*" %>
<%--
  Created by IntelliJ IDEA.
  User: zhaha
  Date: 2021/7/13
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>获取对象数据</title>
</head>
<body>
    <%
        User user = new User();
        user.setUsername("zhh");
        user.setPassword("123456");
        user.setAge(18);
        user.setSex("man");
        user.setBirthDay(new Date());
        request.setAttribute("u", user);

        List list = new ArrayList();
        list.add("aaa");
        list.add("bbb");
        list.add(user);
        request.setAttribute("list", list);

        Map map = new HashMap();
        map.put("s_name", "李四");
        map.put("gender", "男");
        map.put("user", user);
        request.setAttribute("map", map);
    %>

    <div>
        <h3>el获取对象值</h3>
        ${requestScope.u}<br><%-- User{username='zhh', password='123456', age=18, sex='man', birthDay=null} --%>
        ${requestScope.u.username}<br>
        ${u.age}<br>
        ${u.birthDay}<br>
        ${u.birthZH}<br>
        <%--
            birthZH为User对象的属性，属性由set或get方法决定
            setAttribute/getAttriBute   -->  AttriBute ---> attriBute(只有首字母变成小写)
            调用属性的方法为：user.userName     值为调用user的getUserName()方法返回的值
        --%>
        ${u.birthDay.month}<hr>

        <h3>el获取列表list</h3>
        ${list}<br>
        ${list[0]}<br>
        ${list[1]}<br>
        ${list[2].birthZH}<hr>

        <h3>el获取map集合</h3>
        ${map.get("s_name")}<br>
        ${map.gender}<br>
        ${map["gender"]}<br>
        ${map.user.sex}<hr>

        ${pageContext.request.contextPath}
    </div>
</body>
</html>
