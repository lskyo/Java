<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Person.jsp' starting page</title>
    
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
		var aNodes = document.getElementsByTagName("a");
		for(var i = 0; i < aNodes.length; i++){
			aNodes[i].onclick = function(){
				var request = new XMLHttpRequest();
				var url = this.href;
				var method = "GET";
				request.open(method, url);
				request.send(null);
				request.onreadystatechange = function(){
					if(request.readyState == 4){
						if(request.status == 200 || request.status == 304){
							var result = request.responseXML;
							var name = result.getElementsByTagName("name")[0].firstChild.nodeValue;
							var email = result.getElementsByTagName("email")[0].firstChild.nodeValue;
							
							var h2Node = document.createElement("h2");
							h2Node.appendChild(document.createTextNode(name));
							
							var aNode = document.createElement("a");
							aNode.href = "mailto:" + email;
							aNode.appendChild(document.createTextNode(email));
							
							var messageNode = document.getElementById("message");
							messageNode.innerHTML = "";
							messageNode.appendChild(h2Node);
							messageNode.appendChild(aNode);
						}
					}
				}
				return false;
			}
		}
	}
</script>

  </head>
  
  <body>
    Person<hr>
    <a href="file/xml/Jack.xml">Jack</a><br>
    <a href="file/xml/Lskyo.xml">Lskyo</a><br>
    <div id="message"></div>
  </body>
</html>
