<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User view</title>
</head>
<body>
	<p align='right'>User:<a href='${pageContext.servletContext.contextPath}/user?id=${loggedInUser.id}'>${loggedInUser.username}</a>
	<a href='${pageContext.servletContext.contextPath}/signout'>Sign out</a>
	<br><br><br>
	<h1 align='center'>User ${usersTwats[0].user.username}'s Twat list</h1>
		<div align='center'>
		<form action='${pageContext.servletContext.contextPath}/twater'>
			<input type='submit' value='Main Page'/>
		</form>
	</div>
	<br>
	<div align='center'>
		<form method='POST' action='twat'>
			<textarea name='message' cols='31' rows='4' placeholder='Enter message...'></textarea><br>
			<input type='submit' value='Send message to ${usersTwats[0].user.username}'/>
		</form>
		<br>
	</div>
	<div align='center'>
		<table>
			<c:forEach items='${usersTwats}' var='twat'>
				<tr>
					<td>${twat.created}</td>
					<td><a href='${pageContext.servletContext.contextPath}/twat?id=${twat.id}'>${twat.text}</a></td>
					<td>Comments: ${fn:length(twat.comments)}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>