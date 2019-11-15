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
	<title></title>
</head>
<body>
	<center>
		<div style="margin-top: 30px;">
		<form action="update.do" method="post">
			原&nbsp;&nbsp;密&nbsp;&nbsp;码：<input style="margin-left:15px;margin-top: 30px;"type="text" name="old_pass"><br/>
			新&nbsp;&nbsp;密&nbsp;&nbsp;码：<input type="text" name="new_pass" style="margin-left:15px;margin-top: 30px;"><br/>
			确认新密码：<input type="text" name="yes_padd" style="margin-top: 30px;"><br/>
			<input type="submit" name="" value="提交" style="margin-left: 60px;margin-top: 30px;">
		</form>
		</div>		
	</center>
</body>
<c:if test="${mess == true}">
	<script type="text/javascript">
		alert("输入错误");
	</script>
</c:if>
<c:if test="${mess == false}">
	<script type="text/javascript">
		alert("修改成功");
	</script>
</c:if>
</html>