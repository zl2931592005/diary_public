<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html style="height: 90%;">
<head>
	<link rel="Shortcut Icon" href="<%=basePath %>image/dogdog.ico" type="image/x-icon" />
	<meta charset="utf-8">
	<title>
		日志中心
	</title>
	<link rel="stylesheet" type="text/css" href="<%=basePath %>css/home.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath %>bootstarp/css/bootstarp.css">
	<script type="text/javascript" src="<%=basePath %>js/jquery-2.2.3.js"></script>
	<script type="text/javascript" src="<%=basePath %>bootstarp/js/bootstarp.js"></script>
</head>
<body style="height:95%;" id="body">
	<div style="height: 80%;width: 80%;background-color:#ffffff;margin-top:5%;margin-left: 10%;">
		<!-- 需要增加内间距 -->
		<div style="width: 100%;height: 20%;text-align: center;line-height: 360%;">
			<a>
				时间：${date } &nbsp;欢迎${name}&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="<%=basePath %>exit.do" onclick="exit()">
					<img src="<%=basePath %>image/exit.jpg" width="20" height="20">
				</a>
			</a>
		</div>
		<div style="height: 80%;width: 100%">
			<div class="two" style="width: 15%;height: 100%;">
				<iframe frameborder="1" src="<%=basePath %>left" scrolling="no" width="100%" height="100%" frameborder="0"></iframe>
			</div>
			<div class="two" style="width:85%;height: 100%;">
			<c:if test="${bool==false }">
				<iframe frameborder="1" src="<%=basePath %>add_diary"  name="right" width="100%" height="100%" frameborder="0"></iframe>
			</c:if>
			<c:if test="${bool == true }">
				<iframe frameborder="1" src="<%=basePath %>find_diary.do"  name="right" width="100%" height="100%" frameborder="0"></iframe>
			</c:if>
			</div>
		</div>
	</div>
</body>
</html>