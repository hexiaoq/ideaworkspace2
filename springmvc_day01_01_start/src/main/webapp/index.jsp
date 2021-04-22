<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/29
  Time: 0:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <h3>入门程序</h3>

<%--        <a href="hello">入门程序</a>--%>
<%--<form action="con/saveaccount" method="post">--%>
<%--   姓名: <input type="text" name="name">--%>
<%--   密码: <input type="text" name="password">--%>
<%--   金钱: <input type="text" name="money">--%>
<%--    用户姓名: <input type="text" name="user.uname">--%>
<%--    年龄: <input type="text" name="user.age">--%>
<%--    <input type="submit">--%>
<%--</form>--%>
    <form action="con/saveuser" method="post">
        姓名: <input type="text" name="uname">
        年龄: <input type="text" name="age">
        生日: <input type="text" name="date">

        <input type="submit">
    </form>
<a href="con/testsession">testsession</a>




</body>
</html>
