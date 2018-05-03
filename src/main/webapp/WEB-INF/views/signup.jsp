<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
		<p>${passError}
		<form action='signup' method='POST'>
			<input type='text' name='username' placeholder='your username' /><br>
			<br> <input type='text' name='email' placeholder='your email' /><br>
			<br> <input type='password' name='password'
				placeholder='your password' /><br>
			<br> <input type='password' name='confirm'
				placeholder='confirm password' /><br>
			<br>
			<br> <input type='submit' value='Sign Up' />
		</form>
		<br>
		<form action="${pageContext.servletContext.contextPath}">
			<input type="submit" value="Cancel" />
		</form>
	</div>
</body>
</html>