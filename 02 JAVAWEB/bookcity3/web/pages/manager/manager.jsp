<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>后台管理</title>
	<link type="text/css" rel="stylesheet" href="http://192.168.0.105:8080/bookcity3/static/css/style.css" >
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
</style>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="../../static/img/logo.gif" >
			<span class="wel_word">后台管理系统</span>
			<div>
				<a href="http://192.168.0.105:8080/bookcity3/manager/bookservlet?action=page">图书管理</a>
				<a href="order_manager.jsp">订单管理</a>
				<a href="http://192.168.0.105:8080/bookcity3/index.jsp">返回商城</a>
			</div>
	</div>
	
	<div id="main">
		<h1>欢迎管理员进入后台管理系统</h1>
	</div>

	<%@include file="/pages/common/foot.jsp"%>
</body>
</html>