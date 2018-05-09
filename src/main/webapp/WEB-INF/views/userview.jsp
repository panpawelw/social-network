<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User view</title>
</head>
<body>
	<h1 align='center'>User ${user.username}</h1>
	<div align='center'>
		<form method='POST' action='twat'>
			<textarea name='message' cols='31' rows='4' placeholder='Enter message...'></textarea><br>
			<input type='submit' value='Send message'/>
		</form>
		<br>
	</div>
	<div align='center'>
		<table>
			<c:forEach items='${usersTwats}' var='twat'>
				<tr>
					<td>${twat.created}</td>
					<td><a href='${pageContext.servletContext.contextPath}/twat?id=${twat.id}'>${twat.text}</a></td>
					<td>x Comments</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>