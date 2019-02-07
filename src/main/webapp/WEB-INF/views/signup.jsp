<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE "html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href='resources/style.css' rel='stylesheet' type='text/css'>
<title>Sign Up</title>
</head>
<body>
	<br>
	<h1 class='center'>Social Network</h1>
	<br><br>
	<h3 class='center'>Sign Up</h3>
	<br>
	<div class='center'>
		<form:form method='POST' modelAttribute='user'>
			<form:input path='username' placeholder='your username' /><br><br>
			<form:input path='email' placeholder='your email' /><br><br>
			<form:input type='password' path='password' placeholder='your password' /><br><br>
			<input type='password' name='confirm' placeholder='confirm password' /><br><br>
			<form:errors path='*' cssClass='error'/><br>
			<p class='error'>${passwordsDontMatch}</p>
			<br>
			<input type='submit' value='Sign Up' />
		</form:form>
		<br>
		<form action='${pageContext.servletContext.contextPath}'>
			<input type='submit' value='Cancel'/>
		</form>
	</div>
</body>
</html>