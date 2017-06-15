<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'dologin.jsp' starting page</title>

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
	<jsp:useBean id="myUsers" class="com.lskyo.Users" scope="request" />
	<h1>setProperty/getProperty动作元素</h1>
	<hr>

	<h3>根据表单自动匹配所有属性</h3>
	<jsp:setProperty property="*" name="myUsers" />
	用户名：<%=myUsers.getUsername()%><br> 密码：<%=myUsers.getPassword()%><br>
	<br>


	<h3>根据表单匹配部分属性</h3>
	<jsp:setProperty property="username" name="myUsers" />
	<jsp:setProperty property="password" name="myUsers" />
	用户名：<%=myUsers.getUsername()%><br> 密码：<%=myUsers.getPassword()%><br>
	<br>

	<h3>手工配置属性</h3>
	<jsp:setProperty property="username" name="myUsers" value="admin" />
	<jsp:setProperty property="password" name="myUsers" value="abc" />
	用户名：<%=myUsers.getUsername()%><br> 密码：<%=myUsers.getPassword()%><br>
	<br>

	<h3>通过URL传参数的方式给属性赋值</h3>
	<jsp:setProperty property="username" name="myUsers" value="myuser" />
	<jsp:setProperty property="password" name="myUsers" param="mypass" />
	用户名：<%=myUsers.getUsername()%><br> 密码：<%=myUsers.getPassword()%><br>
	<br>

	<h3>通过getProperty来获得属性</h3>
	用户名：<jsp:getProperty property="username" name="myUsers" /><br> 
	密码：<jsp:getProperty property="password" name="myUsers" /><br>
	<br>
	
	<a href="testScope.jsp">测试Scope</a>
	<% request.getRequestDispatcher("testScope.jsp").forward(request, response); %>
</body>
</html>
