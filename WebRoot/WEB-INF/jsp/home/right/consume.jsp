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
<style type="text/css">
.t1 {
	padding-right: 30px;
}

.t2 {
	padding-right: 80px;
}
</style>
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>bootstrap/css/bootstrap.css">
<script type="text/javascript"
	src="<%=basePath%>bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery-2.2.3.js"></script>
</head>
<body>
	<div style="margin-bottom: 30px;margin-top: 10px;">
		<input type="text" name="select" id="search"
			placeholder="输入要搜索的某一日的日期，格式为：1990-01-01" style="width: 400px;">
		<input type="button" onclick="search()" value="搜索">
	</div>
	<table class="table" id="table">
		<thead>
			<tr>
				<th class="t1">时间</th>
				<th class="t2">消费原因</th>
				<th class="t2">消费金额</th>
				<th class="t2">支付方式</th>
			</tr>
		</thead>
		<tbody id="tbody">
			<c:forEach items="${list }" var="list">
				<tr>
					<td class="t1">${list.date }</td>
					<td class="t2">${list.cause}</td>
					<td class="t2">￥${list.money }</td>
					<td class="t2">${list.manner}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
<script type="text/javascript">
	function search(){
		$.ajax({
			url:"<%=basePath%>search_consume.do",
			type:"post",
			data:{"search":$("#search").val()},
			dataType:"html",
			success:function(data){
				$("#table").html(data);
			},
			error:function(){
				alert("模块错误");
			}
		});
	}
</script>
</html>