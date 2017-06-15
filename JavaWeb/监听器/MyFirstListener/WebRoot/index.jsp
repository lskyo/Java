<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="entity.User"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
  
  	<%
  		//String currentUserNumber = (String)request.getSession().getServletContext().getAttribute("currentUserNumber");
  		Object obj = request.getSession().getAttribute("currentUser");
		if(obj instanceof User){
			User user = (User)obj;
	%>
		Hello!<%=user %><hr>
	<%
		}
	%>
    This is index page. <br />
	currentUserNumber : ${currentUserNumber }
	<br />
	<%
		ArrayList<User> userList = (ArrayList<User>)request.getServletContext().getAttribute("userList");
		if(userList != null){
			for(User user : userList){
				%>
				------<%=user.getIpAddr() %>------<br>
				FirstTime : <%=user.getFirstTime() %><br>
				SessionId : <%=user.getSessionId() %><br>
								
				<%
			}
		}
	%>
	
	
	
    <button onclick="location.href='<%=request.getContextPath()%>/init.jsp'">Init</button><br>
    <button onclick="location.href='<%=request.getContextPath()%>/destroy.jsp'">Destroynit</button><br>
  </body>
</html>
