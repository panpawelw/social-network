<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sign Up</title>
</head>
<body>
	<br>
	<br>
	<br>
	<h3 align='center'>Sign Up</h3>
	<div align='center'>
		<form:form method='POST' modelAttribute='user'>
			<form:input path='username' placeholder='your username' /><br><br>
			<form:input path='email' placeholder='your email' /><br><br>
			<form:input type='password' path='password' placeholder='your password' /><br><br>
			<input type='password' name='confirm' placeholder='confirm password' /><br><br><br>
			<input type='submit' value='Sign Up' />
		</form:form>
		<br>
		<form action='${pageContext.servletContext.contextPath}'>
			<input type='submit' value='Cancel'/>
		</form>
	</div>
</body>
</html>