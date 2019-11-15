<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>bootstrap/css/bootstrap.css">
<script type="text/javascript"
	src="<%=basePath%>bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery-2.2.3.js"></script>
</head>
<body>
	<table class="table">
		<thead>
			<tr>
				<th>类型</th>
				<th>余额</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="list">
				<c:if test="${list.type_id == 1}">
					<tr>
						<td>支付宝</td>
						<td>￥${list.money}</td>
					</tr>
				</c:if>
				<c:if test="${list.type_id == 2}">
					<tr>
						<td>微信</td>
						<td>￥${list.money}</td>
					</tr>

				</c:if>
				<c:if test="${list.type_id == 3}">
					<tr>
						<td>现金</td>
						<td>￥${list.money}</td>
					</tr>
				</c:if>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>