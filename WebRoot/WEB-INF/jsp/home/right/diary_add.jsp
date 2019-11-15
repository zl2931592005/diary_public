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
	<link rel="stylesheet" type="text/css" href="<%=basePath %>css/home_.css">
	<script type="text/javascript" src="<%=basePath %>js/diary_add.js"></script>
	<script type="text/javascript" src="<%=basePath %>js/jquery-2.2.3.js"></script>
</head>
<body style="height: 100%;">
<form action="add_diary.do" method="post">
	<div style="margin-left: 20%;">
		<div style="margin-bottom: 30px;">
			时间:<input type="text" name="date" id="now_date" disabled>	
		</div>
		<div style="margin-bottom: 60%;">
			<div style="float: left;">日志:</div>
			<textarea rows="10" cols="20" style="float: left;" name="diary" wrap="hard"></textarea>	
		</div>

		<h4 style="clear: left;">消费情况：</h4>
			<table id="consume">
				<tr>
					<td>消费原因</td>
					<td>消费金额</td>
					<td>付款方式</td>
					<td></td>
				</tr>
	
				<tr>
					<td>
						<input type="text" name="cause">
					</td>
					<td>
						<input type="text" name="money">
					</td>
					<td>
						<select name="manner">
							<!-- <option>支付宝</option>
							 -->
							<option value="支付宝">支付宝</option>
							<option value="微信">微信</option>
							<option value="现金">现金</option>
						</select>
					</td>
					<td>
						<input type="button" onclick="del(this)" value=" - ">
					</td>
				</tr>

		</table>
		<div>
			<input style="width: 30%;" type="button" name="" onclick="add()" value="＋">	
		</div>
		<div style="margin-top:30px;">
			<input style="width: 30%;" type="submit"  name="" value="提交">	
		</div>
	</div>
</form>
</body>

<c:if test="${mess == 0}">
	<script type="text/javascript">
		alert("添加失败，重新添加");
	</script>	
</c:if>

<script type="text/javascript">
	window.onload = function(){
		var now = new Date();
		var year = now.getFullYear();
		var month = now.getMonth()+1;
		var date = now.getDate();
		var now_date =year + "-" + month +"-"+ date;
		$("#now_date").val(now_date);
	}
</script>
</html>