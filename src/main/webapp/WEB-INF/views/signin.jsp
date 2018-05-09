<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="style.css">
<title>Sign In</title>
</head>
<body>
	<h1 align='center'>Twater</h1>
	<br><br><br>
	<h3 align='center'>Sign In</h3>
	<div align='center'>
		<form method='POST' action=''>
			<input type='text' name='username' placeholder='username'/>
			<p class='error'>${usernameError}</p>
			<input type='password' name='password' placeholder='password'/>
			<p class='error'>${passwordError}</p>
			<input type='submit' value='Sign In'/>
		</form>
		<br>
		<form action="${pageContext.servletContext.contextPath}/signup">
			<input type="submit" value="Sign Up" />
		</form>
	</div>
</body>
</html>