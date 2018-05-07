<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Twater</title>
</head>
<body>
	<p align='right'>User: ${loggedInUser.username}
	<a href='${pageContext.servletContext.contextPath}/signout'>Sign out</a>
	<br><br><br>
	<h1 align='center'>Twater</h1>
	<div align='center'>
		<form action='newtwat' method='GET'>
			<input type='submit' value='New twat'/>
		</form>
	</div>
	<h3 align='center'>Twat list</h3>
</body>
</html>