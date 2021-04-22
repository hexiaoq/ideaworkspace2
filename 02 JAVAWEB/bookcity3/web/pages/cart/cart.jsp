<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
	<script type="text/javascript" src="http://192.168.0.105:8080/bookcity3/static/script/jquery-1.7.2.js"></script>
	<script type="text/javascript">
		$(function () {
			$("#delete").click(function () {
           return confirm("你确定要删除【" + $(this).parent().parent().find("td:first").text() +"】吗?")
			});

			$("#clear").click(function () {
				return confirm("你确定要清空购物车吗");

			});

         $(".update").change(function () {
             var count=this.value;
             //获得自定义属性的方法
             var id=$(this).attr("bookid");
         	if(confirm("你确定要执行此次修改吗"))
			{location.href="http://192.168.0.105:8080/bookcity3/cartservlet?action=updatecount&id="+id+"&count="+count;}
           else
			{this.value=this.default;}

		 })
		});
	</script>

	<%@include file="/pages/common/head.jsp"%>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="http://192.168.0.105:8080/bookcity3/static/img/logo.gif" >
			<span class="wel_word">购物车</span>
			<div>
				<%@include file="/pages/common/menu.jsp"%>
			</div>
	</div>
	
	<div id="main">
	
		<table>
			<c:if test="${empty sessionScope.cart.items}">
				<tr>
					<td colspan="8"><a href="http://192.168.0.105:8080/bookcity3" >您的购物车为空,去首页逛逛吧!!!!!!</a></td>

				</tr>

			</c:if>
			<c:if test="${not empty sessionScope.cart.items}">
			<c:forEach items="${sessionScope.cart.items}" var="item">
			<tr>
				<td>${item.value.name}</td>
				<td><input style="width: 80px" type="text" bookid="${item.value.id}" value="${item.value.count}" class="update"></td>
				<td>${item.value.pirce}</td>
				<td>${item.value.totalprice}</td>
<%--jsp写href要用到EL表达式时,应该直接放在""中,不能用+号连接--%>
				<td><a id="delete" href="http://192.168.0.105:8080/bookcity3/cartservlet?action=deleteitem&id=${item.value.id}">删除</a></td>
			</tr>
			</c:forEach>
			</c:if>
			
		</table>
		<c:if test="${not empty sessionScope.cart.items}">
		<div class="cart_info">
			<span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalcount}</span>件商品</span>
			<span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalprice}</span>元</span>
			<span class="cart_span"><a id="clear" href="http://192.168.0.105:8080/bookcity3/cartservlet?action=clear">清空购物车</a></span>
			<span class="cart_span"><a href="pages/cart/checkout.html">去结账</a></span>
		</div>
		</c:if>
	
	</div>
	
192.168.0.105
</body>
</html>