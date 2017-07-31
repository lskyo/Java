<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	自定义类型转换器, 例如：GG-gg@lskyo.com-0-105<br>
	<form action="testConversionServiceConverter" method="post">
		<!-- lastName-email-gender-department.id 例如：GG-gg@lskyo.com-0-105 -->
		Employee:<input type="text" name="employee"/>
		<input type="submit" value="submit">
	</form>	
	<br><br>
	
	
	
	
	
	
	<!-- 
		form标签可以更快速的开发出表单页面，而且可以更方便的进行表单值的回显 
	           注意:
		可以通过 modelAttribute 属性指定绑定的模型属性,
		若没有指定该属性，则默认从 request 域对象中读取 command 的表单 bean
		如果该属性值也不存在，则会发生错误。
	-->
	<form:form action="${pageContext.request.contextPath }/emp" method="POST" modelAttribute="employee">
		<!-- path属性对应html表单标签的name属性值
		
		
		<form:errors path="*"></form:errors><br>
		*代表显示所有错误
		 -->
		
		
		<c:if test="${employee.id == null }">
			LastName:<form:input path="lastName"/>
			<form:errors path="lastName"></form:errors>
			<br>
		</c:if>		
		<c:if test="${employee.id != null }">
			<form:hidden path="id"/>
			<input type="hidden" name="_method" value="PUT">
		</c:if>
		
		Email:<form:input path="email"/>
		<form:errors path="email"></form:errors>
		<br>
		<%
			Map<String, String> genders = new HashMap();
			genders.put("1", "Male");
			genders.put("0", "Female");
			request.setAttribute("genders", genders);
		%>
		Gender:<form:radiobuttons path="gender" items="${genders}"/><br>
		Department:<form:select path="department.id" items="${departments }" itemLabel="departmentName" itemValue="id"></form:select><br>
		<!-- 
			1. 数据类型转换；
			2. 数据类型格式化
			3. 数据校验
			1）如何进行校验？注解！
			① 使用 JSR 303 验证标准；
			② 加入 hibernate validator 验证框架的 jar 包；
			③ 在 SpringMVC 配置文件中添加<mvc:annotation-driven />
			④ 需要在 Bean 类型的前面添加 @Valid 注解；
			2）验证出错转向哪个页面？
			注意：需校验的 Bean 对象和其绑定结果对象或错误对象成对出现的，他们之间不允许声明其他入参。
			3）错误消息如何显示？如何把错误消息进行国际化？
		 -->
		 Birth:<form:input path="birth"/>
		 <form:errors path="birth"></form:errors>
		 <br>
		 Salary:<form:input path="salary"/><br>
		<input type="submit" value="Submit" />
	</form:form>

</body>
</html>