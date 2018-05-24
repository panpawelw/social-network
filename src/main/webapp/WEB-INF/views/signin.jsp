<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href='resources/style.css' rel='stylesheet' type='text/css'/>
<title>Sign In</title>
</head>
<body>
	<br>
	<h1 class='center'>Twater</h1>
	<br><br>
	<h3 class='center'>Sign In</h3>
	<br>
	<div class='center'>
		<form:form method='POST' modelAttribute='user'>
			<form:input path='username' placeholder='username'/><br>
			<form:errors path='username' cssClass='error'/>
			<p class='error'>${usernameError}</p>
			<form:input path='password' type='password' placeholder='password'/><br>
			<form:errors path='password' cssClass='error'/>
			<p class='error'>${passwordError}</p>
			<form:input type='hidden' path='email' value='whatever@whatever.com'/>
			<input type='submit' value='Sign In'/>
		</form:form>
		<br>
		<form action="${pageContext.servletContext.contextPath}/signup">
			<input type="submit" value="Sign Up" />
		</form>
	</div>
</body>
</html>