<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href='resources/style.css' rel='stylesheet' type='text/css'>
<title>User view</title>
</head>
<body>
	<p align='right'>User:<a href='${pageContext.servletContext.contextPath}/user?id=${loggedInUser.id}'>${loggedInUser.username}</a>
	<a href='${pageContext.servletContext.contextPath}/signout'>Sign out</a>
	<h1 align='center'>Twater</h1>
	<br>
	<div align='center'>
		<form action='${pageContext.servletContext.contextPath}/twater'>
			<input type='submit' value='Homepage'/>
		</form>
	</div>
	<br>
	<div align='center'>
		<form method='POST' action='sendmessage'>
			<input type='hidden' name='sender' value='${loggedInUser.id}'/>
			<textarea name='text' cols='31' rows='4' placeholder='Enter message...'></textarea><br>
			<input type='hidden' name='receiver' value='${usersTwats[0].user.id}'/>
			<input type='submit' value='Send message to ${usersTwats[0].user.username}'/>
		</form>
		<br>
	</div>
	<div align='center'>
		<h3 align='center'>User ${usersTwats[0].user.username}'s Twat list</h3>
		<br>
		<table>
			<tr>
				<th>Created</th>
				<th>Text</th>
				<th>Comments</th>
			</tr>
			<c:forEach items='${usersTwats}' var='twat'>
				<tr>
					<td>${twat.created}</td>
					<td><a href='${pageContext.servletContext.contextPath}/twat?id=${twat.id}'>${twat.text}</a></td>
					<td>${fn:length(twat.comments)}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>