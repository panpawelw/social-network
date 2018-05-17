<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href='resources/style.css' rel='stylesheet' type='text/css'>
<title>Twater</title>
</head>
<body>
	<p align='right'>User:<a href='${pageContext.servletContext.contextPath}/user?id=${loggedInUser.id}'>${loggedInUser.username}</a>
	<a href='${pageContext.servletContext.contextPath}/signout'>Sign out</a>
	<h1 align='center'>Twater</h1>
	<br><br>
	<h3 align='center'>Twat list</h3>
	<br>
	<div align='center'>
		<form action='newtwat' method='GET'>
			<input type='submit' value='New twat'/>
		</form>
	</div>
	<br>
	<div align='center'>
		<table>
			<tr>
				<th>Created</th>
				<th>User</th>
				<th>Text</th>
			</tr>
			<c:forEach items='${allTwats}' var='twat'>
				<tr>
					<td>${twat.created}</td>
					<td><a href='${pageContext.servletContext.contextPath}/user?id=${twat.user.id}'>${twat.user.username}</a></td>
					<td><a href='${pageContext.servletContext.contextPath}/twat?id=${twat.id}'>${twat.text}</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>