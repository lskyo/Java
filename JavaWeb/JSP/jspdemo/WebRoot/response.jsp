<%@ page language="java" import="java.util.*,java.io.*"
	contentType="text/html; charset=UTF-8"%>
<%
	out.println("<h1>Response内置对象</h1><br>");
	//out.flush();
	
	PrintWriter outer = response.getWriter();
	outer.println("大家好！我是PrinterWriter！");
	
	//response.sendRedirect("reg.jsp");
	
	
	//请求重定向
	//response.sendRedirect("request.jsp");
	//请求转发
	request.getRequestDispatcher("request.jsp").forward(request, response);
%>
