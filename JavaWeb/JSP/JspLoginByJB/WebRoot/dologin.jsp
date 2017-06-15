<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<jsp:useBean id="loginUser" class="com.po.Users" scope="page"/>
<jsp:useBean id="userdao" class="com.dao.UsersDao" scope="page"/>
<jsp:setProperty property="*" name="loginUser"/>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
  request.setCharacterEncoding("utf-8");//防止中文乱码
  
  //如果用户和密码都等于admin,则登录成功
  if(userdao.usersLogin(loginUser))
  {
     session.setAttribute("loginUser", loginUser.getUsername());
     request.getRequestDispatcher("login_success.jsp").forward(request, response);
     
  }
  else
  {
     response.sendRedirect("login_failure.jsp");
  }
%>
