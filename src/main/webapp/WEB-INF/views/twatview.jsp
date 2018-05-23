<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href='resources/style.css' rel='stylesheet' type='text/css'>
<title>Twat view</title>
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
	<h3 align='center'>Twat view</h3>
	<br>
	<br>
	<div align='center'>
		<table>
			<tr>
				<th>Created</th>
				<th>User</th>
				<th>Text</th>
			</tr>
			<tr>
				<td>${twat.created}</td>
				<td><a href='${pageContext.servletContext.contextPath}/user?id=${twat.user.id}'>${twat.user.username}</a></td>
				<td>${twat.text}</td>
			</tr>
		</table>
	</div>
	<h3 align='center'>Comments: ${fn:length(allComments)}</h3>
	<div align='center'>
		<table>
			<tr>
				<th>Created</th>
				<th>User</th>
				<th>Text</th>
			</tr>
			<c:forEach items='${allComments}' var='comment'>
				<tr>
					<td>${comment.created}</td>
					<td><a href='${pageContext.servletContext.contextPath}/user?id=${comment.user.id}'>${comment.user.username}</a></td>
					<td>${comment.text}</td>
				</tr>
			</c:forEach>
		</table>
		<br>
		<form:form method='POST' modelAttribute='comment' action='addcomment'>
			<form:textarea path='text' cols='31' rows='2' maxlength='60' placeholder='Enter comment...'></form:textarea><br>
			<input type='hidden' name='twatId' value='${twat.id}'/><br>
			<form:errors path='*' cssClass='error'/><br><br>
			<input type='submit' value='Post comment'/>
		</form:form>
		<br>
	</div>
</body>
</html>