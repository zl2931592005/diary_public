<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html style="height:100%;background-color: #A4D3EE;margin-top: -10px;">
<head>
	<link rel="Shortcut Icon" href="<%=basePath %>image/dogdog.ico" type="image/x-icon" />
	<meta charset="utf-8">
	<title>
		
	</title>
	<link rel="stylesheet" type="text/css" href="<%=basePath %>bootstrap/css/bootstrap.css">
	<script type="text/javascript" src="<%=basePath %>js/jquery-2.2.3.js"></script>
	<script type="text/javascript" src="<%=basePath %>bootstrap/js/bootstrap.js"></script>
</head>

<body style="height: 100%;">
	
	<div style="margin-left: 10px;height:100%;">
		<ul class="nav navbar-nav">
			<li class="dropdown">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown">
					日志管理
					<b class="caret"></b>
				</a>
				<ul class="dropdown-menu">
					<li><a href="diary_add.do" target="right">写日志</a></li>
				</ul>
				<ul class="dropdown-menu">
					<li><a href="list_diary.do" target="right">日志列表</a></li>
				</ul>
			</li>
			<li class="dropdown">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown">
					资金查看
					<b class="caret"></b>
				</a>
				<ul class="dropdown-menu">
					<li><a href="balance.do"  target="right">个人余额</a></li>
					<li><a href="consume.do"  target="right">消费情况</a></li>
				</ul>
			</li>
			<%--<li class="dropdown">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown">
					知&nbsp;&nbsp;识&nbsp;&nbsp;库
					<b class="caret"></b>
				</a>
				<ul class="dropdown-menu">
					<li><a href="./right/classified_add.html" target="right">添加知识</a></li>
					<li><a href="./right/classified_yes.html" target="right">已分类查看</a></li>
					<li><a href="./right/classified_no.html" target="right">未分类查看</a></li>
				</ul>
			</li>--%>
			<li class="dropdown">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown">
					系统设置
					<b class="caret"></b>
				</a>
				<ul class="dropdown-menu">
					<li><a href="go_update_user.do"  target="right">修改信息</a></li>
				</ul>
			</li>
		</ul>
	</div>
	
</body>
</html>