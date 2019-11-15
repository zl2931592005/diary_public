<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'index.jsp' starting page</title>
	<meta charset="utf-8">
  </head>
  
  <body>
    <form action="<%=basePath %>add_user.do" method="post"> 
    账号:<input type="text" name="username"> <br>
    密码:<input type="password" name="password"> <br>
    支付宝余额:<input type="text" name="money"> <br>
    微信余额:<input type="text" name="money"> <br>
    现金余额:<input type="text" name="money"> <br>
    <input type="submit" value="提交">
    </form>
  </body>
</html>
