<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="domain.User" %><%--
  Created by IntelliJ IDEA.
  User: zhaha
  Date: 2021/7/14
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户信息管理</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/list.css">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="js/jquery.min.js" ></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container">
        <h3 style="text-align: center">用户信息列表</h3>
        <div class="find">
            <form class="form-inline">
                <div class="form-group">
                    <label for="exampleInputName2">姓名</label>
                    <input type="text" class="form-control" id="exampleInputName2">
                </div>
                <div class="form-group">
                    <label for="exampleInputEmail2">年龄</label>
                    <input type="text" class="form-control" id="exampleInputEmail2">
                </div>
                <div class="form-group">
                    <label for="exampleInputEmail3">籍贯</label>
                    <input type="text" class="form-control" id="exampleInputEmail3">
                </div>
                <button type="submit" class="btn btn-default">搜索</button>
            </form>
        </div>
        <div class="func">
            <a class="btn btn-primary" href="#">添加用户</a>
            <a class="btn btn-primary" href="#">删除用户</a>
        </div>
        <table class="table table-hover table-bordered">
            <tr class="success">
                <th>编号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>籍贯</th>
                <th>操作</th>
            </tr>

            <%
                List list = new ArrayList();
                list.add(new User("张三", "男", 18, "湖北"));
                list.add(new User("李四", "男", 19, "湖北"));
                list.add(new User("王五", "男", 20, "湖北"));
                list.add(new User("赵六", "男", 21, "湖北"));
                request.setAttribute("list", list);
            %>
            <c:forEach items="${list}" var="user" varStatus="s">
                <tr>
                    <td>${s.count}</td>
                    <td>${user.name}</td>
                    <td>${user.gender}</td>
                    <td>${user.age}</td>
                    <td>${user.address}</td>
                    <td>
                        <button type="button" class="btn btn-default">修改</button>
                        <button type="button" class="btn btn-default">删除</button>
                    </td>
                </tr>
            </c:forEach>

        </table>
        <div>
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <li>
                        <a href="#" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    <li class="active"><a href="#">1</a></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                    <li><a href="#">5</a></li>
                    <li>
                        <a href="#" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                    <span class="span">
                        共16条记录，共5页
                    </span>
                </ul>
            </nav>
        </div>
    </div>
</body>
</html>
