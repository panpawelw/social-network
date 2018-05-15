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
<style>
* {
    box-sizing: border-box;
}

/* Create three equal columns that floats next to each other */
.column {
    float: left;
    width: 33.33%;
    padding: 10px;
    border: 1px solid black;
}

/* Clear floats after the columns */
.row:after {
    content: "";
    display: table;
    clear: both;
}
</style>
</head>
<body>
	<p align='right'>User:<a href='${pageContext.servletContext.contextPath}/user?id=${loggedInUser.id}'>${loggedInUser.username}</a>
	<a href='${pageContext.servletContext.contextPath}/signout'>Sign out</a>
	<div class='row'>
		<div class='column'>
			<h2 align='center'>Received messages</h2>
		</div>
		<div class='column'>
			<div align='center'>
				<h1 align='center'>Your account</h1>
				<form action='${pageContext.servletContext.contextPath}/twater'>
					<input type='submit' value='Main Page'/>
				</form>
				<br>
				<form:form method='POST' modelAttribute='user'>
					<form:input path='username' placeholder='your username' /><br><br>
					<form:input path='email' placeholder='your email' /><br><br>
					<input type='password' name='password' placeholder='your password' /><br>
					<input type='password' name='confirm' placeholder='confirm password' /><br><br>
					<input type='submit' value='Change details' />
				</form:form>
				<br>
				<h1 align='center'>Your Twat list</h1>
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
		</div>
		<div class='column'>
			<h2 align='center'>Sent messages</h2>
		</div>
	</div>
</body>
</html>