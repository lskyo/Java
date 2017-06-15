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

<title>request内置对象</title>

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
	<h1>request内置对象</h1>
	<br>
	<%
		request.setCharacterEncoding("utf-8");
		request.setAttribute("password", "123456");
	%>
	用户名：<%=request.getParameter("username")%><br> 
	爱好：<%
		String[] favorites = request.getParameterValues("favorite");
		if (favorites != null) {
			for (int i = 0; i < favorites.length; i++) {
				out.println(favorites[i] + "&nbsp;&nbsp;");
			}
		}
	%><br>
	密码：<%=request.getAttribute("password") %><br>
	请求体的MIME类型：<%=request.getContentType() %><br>
	协议类型及版本号：<%=request.getProtocol() %><br>
	服务器主机名：<%=request.getServerName() %><br>
	服务器端口号：<%=request.getServerPort() %><br>
	请求文件的长度：<%=request.getContentLength() %><br>
	请求客户端的IP地址：<%=request.getRemoteAddr() %><br>
	请求的真实路径：<%=request.getRealPath("request.jsp") %><br>
	请求的上下文路径：<%=request.getContextPath() %><br>
		
</body>
</html>
