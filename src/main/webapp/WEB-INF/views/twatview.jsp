<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Twat view</title>
</head>
<body>
	<p align='right'>User:<a href='${pageContext.servletContext.contextPath}/user?id=${loggedInUser.id}'>${loggedInUser.username}</a>
	<a href='${pageContext.servletContext.contextPath}/signout'>Sign out</a>
	<br><br><br>
	<h1 align='center'>Twat view</h1>
	<div align='center'>
		<table>
			<tr>
				<td>${twat.created}</td>
				<td><a href='${pageContext.servletContext.contextPath}/user?id=${twat.user.id}'>${twat.user.username}</a></td>
				<td>${twat.text}</td>
			</tr>
		</table>
	</div>
	<h3 align='center'>Comments: x</h3>
	<div align='center'>
		<form method='POST' action='addcomment'>
			<textarea name='text' cols='31' rows='2' maxlength='60' placeholder='Enter comment...'></textarea><br>
			<input type='hidden' name='userId' value='${loggedInUser.id}'/>
			<input type='hidden' name='twatId' value='${twat.id}'/>
			<input type='submit' value='Post comment'/>
		</form>
		<br>
	</div>
</body>
</html>