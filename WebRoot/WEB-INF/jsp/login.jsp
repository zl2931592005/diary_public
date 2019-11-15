<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>

<!-- 这个页面为使用该简历展示系统的用户登陆的页面。 -->
<!-- TODO 暂时未实现登陆功能 -->
<!-- TODO  需要做登陆的前端校验，使用外联JS来做 -->
<head>
	<link rel="Shortcut Icon" href="<%=basePath %>image/dogdog.ico" type="image/x-icon" />
	<meta charset="utf-8">
	<title>
		登录
	</title>
	
	<link rel="stylesheet" type="text/css" href="<%=basePath %>css/curriculum_vitae.css">
	<script type="text/javascript" src="<%=basePath %>js/jquery-2.2.3.js"></script>
</head>

<!-- 这里准备增加登录页面的背景图片,现已通过外联css的方式完成 -->
<body style="text-align:center；">
	
	<!-- 整个登录框的位置 -->	
	<div style="margin-top: 200px;margin-left: 35%; height: 270px;width: 400px;background-color: #abacb5;border-radius:10px;">
		<div style="margin-left: 115px;padding-top:15px;">
			<p style="margin-left: 20px;">欢迎来到日志中心</p>
			
			<input type="text" id="name"  placeholder="请输入账号">
			<br/>
			<input style="margin-top: 20px;" id="password" type="password" placeholder="请输入密码">
			<br/>
			<input type="button" name="登录" onclick="login()" style="margin-top: 20px;width: 100px;margin-left: 35px;" value="登录" >
			<br/>
			<input type="button" name="注册" onclick="adduser()" style="margin-top: 20px;width: 100px;margin-left: 35px;" value="注册" >
		</div>
	</div>
</body>
<c:if test="${mess == 0}">
	<script type="text/javascript">
		alert("账号密码不能为空。");
	</script>	
</c:if>
<c:if test="${mess == 2}">
	<script type="text/javascript">
		alert("账号已存在。");
	</script>	
</c:if>
<c:if test="${mess == 1}">
	<script type="text/javascript">
		alert("账号添加成功。");
	</script>	
</c:if>
<c:if test="${bal == 0}">
	<script type="text/javascript">
		alert("资金添加失败。");
	</script>	
</c:if>

<script type="text/javascript">
	function adduser(){
		window.location.href="adduser.do";
	}

	function login(){
		$.ajax({
			async:"false",
			url:"login.do",
			type:"POST",
			contentType:"application/json;charset=utf-8",
			data:JSON.stringify({"username":$("#name").val(),"password":$("#password").val()}),
			dataType:"json",
			success:function(data){
					alert("登录成功");
					window.location.href="index.do";
			},
			error:function(){
				alert("账号密码错误");
			}
		});
	}
</script>
</html>