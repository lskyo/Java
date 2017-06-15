<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
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
	<script type="text/javascript">
		window.onload = function(){
			document.getElementsByTagName("a")[0].onclick = function(){
				var request = new XMLHttpRequest();
				var url = this.href + "?time=" + new Date();
				//var method = "GET";
				var method = "POST"; 
				request.open(method, url);
				
				request.setRequestHeader("ContentType", "application/x-www-form-urlencoded");
				request.send("name='lskyo'");
				request.onreadystatechange = function(){
					if(request.readyState == 4){
						if(request.status == 200 || request.status == 304){
							alert(request.responseText);
						}
					}
				}
				return false;
			}
		}
	</script>
  </head>
  
  <body>
    This is my Ajax demo. <hr>
    <a href="helloajax.txt">HelloAjax</a><br>
    <a href="Person.jsp">Response HTML Data</a><br>
    <a href="Person2.jsp">Response XML Data</a><br>
    <a href="Person3.jsp">Response Json Data</a><br>
  </body>
</html>
