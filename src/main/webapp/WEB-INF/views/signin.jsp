<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sign In</title>
</head>
<body>
	<h1 align='center'>Twater</h1>
	<br><br><br>
	<h3 align='center'>Sign In</h3>
	<div align='center'>
		<form:form method='POST' modelAttribute='user'>
			<form:input path='username' placeholder='username'/><br><br>
			<form:input path='password' placeholder='password'/><br><br><br>
			<input type='submit' value='Sign In'/>
		</form:form>
		<br>
		<form action="${pageContext.servletContext.contextPath}/signup">
			<input type="submit" value="Sign Up" />
		</form>
	</div>
</body>
</html>