<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>尚硅谷会员登陆成功页面</title>
<link type="text/css" rel="stylesheet" href="http://192.168.0.105:8080/bookcity3/static/css/style.css" >
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
				<img class="logo_img" alt="" src="http://192.168.0.105:8080/bookcity3/static/img/logo.gif" >
				<%@include file="/pages/common/menu.jsp"%>
		</div>
		
		<div id="main">
		
			<h1>欢迎回来 <a href="http://192.168.0.105:8080/bookcity3/pages/client/index.jsp">转到主页</a></h1>
	
		</div>

		<%@include file="/pages/common/foot.jsp"%>
</body>
</html>