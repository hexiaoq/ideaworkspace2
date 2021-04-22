<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/8/19
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script src="js/jquery.min.js"></script>
<script type="text/javascript">
    $(function () {
      $("#btn").click(function () {
          alert("hello jquery");
      })
    })
</script>
<body>
<a href="user/test">test</a>
<button id="btn">btn</button>
</body>
</html>
