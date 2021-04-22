<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>尚硅谷会员登录页面</title>
<%@include file="/pages/common/head.jsp"%>
</head>
<body>

		<div id="login_header">
			<img class="logo_img" alt="" src="http://localhost:8080/bookcity3/static/img/logo.gif" >
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎登录</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>尚硅谷会员</h1>
								<a href="http://localhost:8080/bookcity3/pages/user/regist.jsp">立即注册</a>
							</div>
							<div class="msg_cont">
								<b></b>
								<span class="errorMsg">${requestScope.get("wrong")==null?"请输入账户和密码":requestScope.get("wrong")}</span>
							</div>
							<div class="form">
								<form action="http://localhost:8080/bookcity3/login" method="post">
									<input type="hidden" name="action" value="login">
									<label>用户名称：</label>
									<input class="itxt" type="text" value="${cookie.username.value}" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="name" />
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" />
									<br />
									<br />
									<label>验证码：</label>
									<input class="itxt" name="code" type="text" style="width: 80px;" id="code"/>
									<img alt="" src="http://localhost:8080/bookcity3/kaptcha.jpg" style="float: right; margin-right: 40px; height:26px;width: 100px">
									<br />
									<br />
									<input type="submit" value="登录" id="sub_btn" />
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		<%@include file="/pages/common/foot.jsp"%>
</body>
</html>