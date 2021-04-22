<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>尚硅谷会员注册页面</title>
<link type="text/css" rel="stylesheet" href="http://localhost:8080/bookcity3/static/css/style.css" >
	<script type="text/javascript" src="http://localhost:8080/bookcity3/static/script/jquery-1.7.2.js"></script>
	<script type="text/javascript">
		//不跳转页面的前提下实现用户名存在提示
	$(function () {
		$("#name").blur(function () {
			var username=this.value;
			$.getJSON("http://localhost:8080/bookcity3/userservlet","action=ajaxexistname&username="+username,function (data) {
				if(data.exsistusername)
				{
					$("span.errorMsg").text("用户名已存在");

				}
				else
				{$("span.errorMsg").text("用户名可用")}

			})

		})

		//给验证绑定单击事件,点击时,重新请求服务器,得到新的图片
		$("#code_img").click(function () {
			this.src="http://localhost:8080/bookcity3/kaptcha.jpg?d="+new Date();
		});



	$("#sub_btn").click(function () {
       	var name = $("#name").val();
        var testname= /^\w{5,12}$/;
        if(!testname.test(name))
		{
			$("span.errorMsg").text("输入用户名不合法");
			return false;

		}
		   $("span.errorMsg").text("");

        var pwdtext=$("#password").val();
        var pwdpatt=/^\w{5,12}$/;
		   if(!pwdpatt.test(pwdtext))
		   {
			   $("span.errorMsg").text("输入密码不合法");
			   return false;
		   }
		   $("span.errorMsg").text("");

		   var repwdtext=$("#repwd").val();
		   if(repwdtext!=pwdtext)
		   {
			   $("span.errorMsg").text("所输入密码不一致");
			   return false;

		   }
		   $("span.errorMsg").text("");

		   var emailtext=$("#email").val();
		   var emailpatt=/^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
		   if(!emailpatt.test(emailtext))
		   {
			   $("span.errorMsg").text("输入邮箱不合法");
			   return false;
		   }
		   $("span.errorMsg").text("");

		   var codetext=$("#code").val();

		   if(codetext==""||codetext==null)
		   {
			   $("span.errorMsg").text("输入验证码不合法");
			   return false;
		   }
		   $("span.errorMsg").text("");

	   })

	})
	</script>
<style type="text/css">
	.login_form{
		height:420px;
		margin-top: 25px;
	}
	
</style>


</head>
<body>

		<div id="login_header">
			<img class="logo_img" alt="" src="http://localhost:8080/bookcity3/static/img/logo.gif" >
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎注册</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册尚硅谷会员</h1>
								<span class="errorMsg">${requestScope.get("wrong")==null?"请输入您的信息":requestScope.get("wrong")}</span>
							</div>
							<div class="form">
								<form action="http://localhost:8080/bookcity3/userservlet" method="post">
									<input type="hidden" name="action" value="regist">
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名"
										   value="${requestScope.get("name")==null?"":requestScope.get("name")}"
										   autocomplete="off" tabindex="1" name="name" id="name" />
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码"
										   autocomplete="off" tabindex="1" name="password" id="password" />
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码"
										   autocomplete="off" tabindex="1" name="repwd" id="repwd" />
									<br />
									<br />
									<label>电子邮件：</label>
									<input class="itxt" type="text" placeholder="请输入邮箱地址"
										   value="${requestScope.get("email")==null?"":requestScope.get("email")}"
										   autocomplete="off" tabindex="1" name="email" id="email" />
									<br />
									<br />
									<label>验证码：</label>
									<input class="itxt" name="code" type="text" style="width: 80px;" id="code"/>
									<img  id="code_img" alt="" src="http://localhost:8080/bookcity3/kaptcha.jpg" style="float: right; margin-right: 40px; height:26px;width: 100px">
									<br />
									<br />
									<input type="submit" value="注册" id="sub_btn" />

								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		 <%@include file="/pages/common/foot.jsp"%>
</body>
</html>