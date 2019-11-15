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
<form action="edit_diary.do" method="post">
	<div style="margin-left: 20%;">
		<div style="margin-bottom: 30px;">
			时间:<input type="text" name="date" id="now_date" disabled value="${diary.date}">	
		</div>
		<div style="margin-bottom: 60%;">
			<div style="float: left;">日志:</div>
			<textarea rows="10" cols="20" style="float: left;" name="diary" wrap="hard">${diary.diary }</textarea>	
		</div>

		<h4 style="clear: left;">消费情况：</h4>
			<table id="consume">
				<tr>
					<td>消费原因</td>
					<td>消费金额</td>
					<td>付款方式</td>
					<td></td>
				</tr>
				<c:forEach items="${causes }" var="causes">
				<tr>
					<td>
						<input type="text" name="cause" value="${causes.cause }">
					</td>
					<td>
						<input type="text" name="money" value="${causes.money }">
					</td>
					<td>
						<select name="manner">
						<c:if test="${causes.manner eq '支付宝'}">
							<option value="支付宝">支付宝</option>
							<option value="微信">微信</option>
							<option value="现金">现金</option>
						</c:if>
						<c:if test="${causes.manner eq '微信'}">
							<option value="微信">微信</option>
							<option value="支付宝">支付宝</option>
							<option value="现金">现金</option>
						</c:if>
						<c:if test="${causes.manner eq '现金'}">
							<option value="现金">现金</option>
							<option value="支付宝">支付宝</option>
							<option value="微信">微信</option>
						</c:if>
						</select>
					</td>
					<td>
						<input type="button" onclick="del(this)" value=" - ">
					</td>
				</tr>
				</c:forEach>

		</table>
		<div>
			<input style="width: 30%;" type="button" name="" onclick="add()" value="＋">	
		</div>
		<div style="margin-top:30px;">
			<input style="width: 30%;" type="submit" onclick="bool()" name="" value="提交">	
		</div>
	</div>
</form>
</body>

<c:if test="${mess == 0}">
	<script type="text/javascript">
		alert("修改失败，重新修改");
	</script>	
</c:if>
</html>