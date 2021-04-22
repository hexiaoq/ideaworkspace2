<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--不分页的图书管理页面,凡是不分页显示图书都到这个路径--%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>图书管理</title>
	<link type="text/css" rel="stylesheet" href="http://192.168.0.105:8080/bookcity3/static/css/style.css" >
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="../../static/img/logo.gif" >
			<span class="wel_word">图书管理系统</span>
			<div>
				<a href="">图书管理</a>
				<a href="order_manager.jsp">订单管理</a>
				<a href="../../index.jsp">返回商城</a>
			</div>
	</div>
	
	<div id="main">
		<table>

			<c:forEach items="${requestScope.books}" var="book">
			<tr>
				<td>${book.name}</td>
				<td>${book.price}</td>
				<td>${book.author}</td>
				<td>${book.sales}</td>
				<td>${book.stock}</td>
				<td><a href="http://192.168.0.105:8080/bookcity3/manager/bookservlet?action=deletebookbyid&&id=${book.id}">删除</a></td>
				<td><a href="http://192.168.0.105:8080/bookcity3/manager/bookservlet?action=getbook&&id=${book.id}">修改</a></td>
			</tr>
			</c:forEach>

			
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="http://192.168.0.105:8080/bookcity3/pages/manager/book_edit.jsp">添加图书</a></td>
			</tr>	
		</table>
	</div>

	<%@include file="/pages/common/foot.jsp"%>
</body>
</html>