<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
	<div align="center">
		<form action="register_Action.action" method="post">
			用户名：<input type="text" name="username"/><br>
			密码：<input type="password" name="password1"/><br>
			重复密码：<input type="password" name="password2"/><br>
			<input type="submit" value="注册" />&nbsp;&nbsp;
			<input type="button" value="返回登陆" onclick="javascript:window.location.href='login.jsp'"/>
		</form>
	</div>
  </body>
</html>
