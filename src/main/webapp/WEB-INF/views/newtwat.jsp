<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href='resources/style.css' rel='stylesheet' type='text/css'>
<title>Add new Twat</title>
</head>
<body>
	<p align='right'>User:<a href='${pageContext.servletContext.contextPath}/user?id=${loggedInUser.id}'>${loggedInUser.username}</a>
	<a href='${pageContext.servletContext.contextPath}/signout'>Sign out</a>
	<br><br><br>
	<h1 align='center'>Add new Twat</h1>
	<br><br><br>
	<div align='center'>
		<form:form method='POST' modelAttribute='twat'>
			<form:textarea path='text' cols='71' rows='2' maxlength='140' placeholder='Enter maximum of 140 characters...'/><br><br>
			<form:errors path='*' cssClass='error'/><br><br>
			<input type='submit' value='Add twat'/>
		</form:form>
		<br>
		<form action='twater'>
			<input type='submit' value='Cancel'/>
		</form>
	</div>
</body>
</html>