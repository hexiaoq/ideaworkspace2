<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>尚硅谷会员注册页面</title>
<link type="text/css" rel="stylesheet" href="http://localhost:8080/bookcity3/static/css/style.css" >
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
	
	h1 a {
		color:red;
	}
</style>

</head>
<body>
		<div id="header">
				<img class="logo_img" alt="" src="http://localhost:8080/bookcity3/static/img/logo.gif" >
				<span class="wel_word"></span>
			<%@include file="/pages/common/menu.jsp"%>
		</div>
		
		<div id="main">
		
			<h1>注册成功! <a href="http://localhost:8080/bookcity3/pages/client/index.jsp">转到主页</a></h1>
	
		</div>

		<%@include file="/pages/common/foot.jsp"%>
</body>
</html>