<%@ page language="java" import="java.util.*"
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

<title>application内置对象</title>

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
	<h1>application内置对象</h1>
	<br>
	<%
		application.setAttribute("city", "Beijing");
		application.setAttribute("postcode", "10000");
		application.setAttribute("email", "lisi@126.com");
	 %>
	 Location:<%=application.getAttribute("city") %><br>
	 Attribute in application:<%
	 	Enumeration attributes = application.getAttributeNames();
	 	while(attributes.hasMoreElements()){
	 		out.println(attributes.nextElement() + "<br>");
	 	}	 	
	  %>
	  Jsp(SERVLET)引擎名以及版本号：<%=application.getServerInfo() %><br>
</body>
</html>
