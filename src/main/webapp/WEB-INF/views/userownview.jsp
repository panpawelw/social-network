<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Your account</title>
</head>
<body>
	<p align='right'>User:<a href='${pageContext.servletContext.contextPath}/user?id=${loggedInUser.id}'>${loggedInUser.username}</a>
	<a href='${pageContext.servletContext.contextPath}/signout'>Sign out</a>
	<br><br><br>
	<h1 align='center'>Your account</h1>
	<p>${sessionScope.loggedInUser}
	<div align='center'>
		<form:form method='POST' modelAttribute='user'>
			<form:input path='username' placeholder='your username' /><br><br>
			<form:input path='email' placeholder='your email' /><br><br>
			<form:input type='password' path='password' placeholder='your password' /><br><br>
			<input type='password' name='confirm' placeholder='confirm password' /><br><br><br>
			<input type='submit' value='Sign Up' />
		</form:form>
		<br>
		<form action='${pageContext.servletContext.contextPath}'>
			<input type='submit' value='Cancel'/>
		</form>
	</div>
	<h1 align='center'>Your Twat list</h1>
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