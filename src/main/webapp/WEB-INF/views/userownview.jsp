<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href='resources/style.css' rel='stylesheet' type='text/css'/>
<title>Your account</title>
</head>
<body>
	<p class='right'>User:<a href='${pageContext.servletContext.contextPath}/user?id=${loggedInUser.id}'>${loggedInUser.username}</a>
		<a href='${pageContext.servletContext.contextPath}/signout'>Sign out</a></p>
	<div class='row'>
		<div class='column'>
			<h2 class='center'>Received messages</h2>
			<table class='center'>
				<tr>
					<th>Created</th>
					<th>User</th>
					<th>Text</th>
				</tr>
				<c:forEach items='${receivedMessages}' var='receivedMessage'>
				<c:set var='message' value='${receivedMessage.text}'/>
				<c:set var='unread' value='${receivedMessage.unread}'/>
					<tr>
						<td style="font-weight: ${unread ? 'bold' : 'normal' }">${receivedMessage.created}</td>
						<td style="font-weight: ${unread ? 'bold' : 'normal' }">${receivedMessage.sender.username}</td>
						<td style="font-weight: ${unread ? 'bold' : 'normal' }"><a href='${pageContext.servletContext.contextPath}/message?id=${receivedMessage.id}'>${fn:substring(message,0,26)}
						<c:if test="${fn:length(message) > 30}">...</c:if></a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div class='centralcolumn'>
			<div class='center'>
				<h1 class='center'>Your account</h1>
					<form action='${pageContext.servletContext.contextPath}/home'>
						<input type='submit' value='Homepage'/>
					</form>
				<br>
				<form:form method='POST' modelAttribute='user'>
					<form:input path='username' placeholder='your username' /><br><br>
					<form:input path='email' placeholder='your email' /><br><br>
					<form:input path='password' type='password' placeholder='your password' /><br>
					<input type='password' name='confirm' placeholder='confirm password' /><br><br>
					<form:errors path='*' cssClass='error'/>
					<p class='error'>${passwordsDontMatch}</p>
					<br>
					<input type='submit' value='Change details' />
				</form:form>
				<br>
				<h1 class='center'>Your posts</h1>
				<table class='center'>
				<tr>
					<th>Created</th>
					<th>Text</th>
					<th>&copy;</th>
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
		</div>
		<div class='column'>
			<h2 class='center'>Sent messages</h2>
			<table class='center'>
				<tr>
					<th>Created</th>
					<th>User</th>
					<th>Text</th>
				</tr>
				<c:forEach items='${sentMessages}' var='sentMessage'>
				<c:set var='message' value='${sentMessage.text}'/>
					<tr>
						<td>${sentMessage.created}</td>
						<td>${sentMessage.sender.username}</td>
						<td><a href='${pageContext.servletContext.contextPath}/message?id=${sentMessage.id}'>${fn:substring(message,0,26)}
						<c:if test='${fn:length(message) > 30}'>...</c:if></a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>