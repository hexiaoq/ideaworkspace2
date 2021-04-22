<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/6/21
  Time: 10:04
  To change this template use File | Settings | File Templates.
--%>
<%--很多页面都拥有的静态页面,使用静态包含技术,减少代码量
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title></title>
</head>
<body>
<div>
    <span>欢迎<span class="um_span">${sessionScope.username}</span>光临尚硅谷书城</span>
    <a href="http://192.168.0.105:8080/bookcity3/pages/order/order.jsp">我的订单</a>
    <a href="http://192.168.0.105:8080/bookcity3/userservlet?action=logout">注销</a>&nbsp;
    <a href="http://192.168.0.105:8080/bookcity3/index.jsp">首页</a>
</div>
</body>
</html>
