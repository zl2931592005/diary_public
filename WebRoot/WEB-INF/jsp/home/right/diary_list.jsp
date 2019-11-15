<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>
		
	</title>
	<link rel="stylesheet" type="text/css" href="<%=basePath %>bootstrap/css/bootstrap.css">
	<script type="text/javascript" src="<%=basePath %>bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript" src="<%=basePath %>js/jquery-2.2.3.js"></script>
	<script type="text/javascript" src="<%=basePath %>js/diary_list.js"></script>
	<style type="text/css">
		.oper{
			float: left;
			margin-right: 30px;
		}
	</style>
</head>
<body>
	<div style="margin-bottom: 30px;margin-top: 10px;">
		<input type="text" id="search" name="select" placeholder="输入要搜索的日志的日期，格式为：1990-01-01" style="width: 300px;">
		<input type="button" onclick="search()" value="搜索">
	</div>
	<table class="table table-striped" id="table">
		<thead>
			<tr>
				<th>
					<input type="checkbox" name="check"  onclick="check_all(this)">
				</th>
				<th>时间</th>
				<th>当日消费总额</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${list }" var="obj">
			<tr>
				<td>
					<input class="body" type="checkbox" name="check">
				</td>
				<td>${obj.date}</td>
				<td>￥${obj.sum_cause}</td>
				<td>
					<input type="button" onclick="edit(this)" value="修改"/>
					<input type="button" value="删除"/> 
				</td>
			</tr>
		</c:forEach>
			
		</tbody>
	</table>
</body>
<script type="text/javascript">
	function search(){
		$.ajax({
			url:"<%=basePath%>search_diary.do",
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
	
	function edit(a){
		var c = a.parentNode.parentNode.firstElementChild.nextElementSibling.innerHTML;
		location.href="find_diary.do?date="+c;
	}
</script>
</html>