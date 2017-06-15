<%@ page language="java" import="java.util.*,java.text.*"
	contentType="text/html; charset=UTF-8"%>
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

<title>My JSP 'session_page2.jsp' starting page</title>

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
	<h1>session内置对象</h1>
	<hr>
	<%
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		Date d = new Date(session.getCreationTime());
		//session.setAttribute("username", "admin");
	%>
	Session创建的时间：<%=sdf.format(d)%><br> Session的ID编号：<%=session.getId()%><br>
	从Session中获取的用户名：<%=session.getAttribute("username")%><br>
	从Session中获取的属性：
	<br>
	<%
		String[] name = session.getValueNames();
		for(int i = 0; i < name.length; i++){
			out.println(name[i] + " : " + session.getValue(name[i]).toString() + "<br>");
		}	
	%>
</body>
</html>
