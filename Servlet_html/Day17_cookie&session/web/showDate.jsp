<%@ page import="java.net.URLDecoder" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.net.URLEncoder" %><%--
  Created by IntelliJ IDEA.
  User: zhaha
  Date: 2021/7/8
  Time: 1:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Cookie[] cs = request.getCookies();
        boolean flag = false;
        if (cs != null && cs.length != 0){

            for (Cookie c : cs) {
                if (c.getName().equals("LastTime")){
                    //有Cookie，不是第一次访问
                    flag = true;
                    //获取上次访问时间数据
                    String value = c.getValue();
                    System.out.println("解码前：value="+value);
                    value = URLDecoder.decode(value, "utf-8");
                    System.out.println("解码后：value="+value);
                    out.write("<h1>欢迎回来，您上次访问时间为：" + value + "</h1>");

                    //重新设置时间数据
                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                    String new_date = sdf.format(date);
                    /**
                     * cookie中不能存在特殊字符如空格 对应ASCII码为 32
                     * 应使用URL编码和解码
                     */
                    System.out.println("URL编码前："+new_date);
                    new_date = URLEncoder.encode(new_date, "utf-8");
                    System.out.println("URL编码后："+new_date);

                    c.setValue(new_date);
                    c.setMaxAge(60 * 60 * 24);
                    response.addCookie(c);
                }
            }
        }

        if (cs == null || cs.length == 0 || !flag){
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            String new_date = sdf.format(date);
            System.out.println("URL编码前："+new_date);
            new_date = URLEncoder.encode(new_date, "utf-8");
            System.out.println("URL编码后："+new_date);
            Cookie cookie = new Cookie("LastTime", new_date);
            cookie.setMaxAge(60 * 60 * 24);
            response.addCookie(cookie);
            out.write("<h1>您好，欢迎首次访问</h1>");
        }
    %>
</body>
</html>
