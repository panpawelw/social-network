<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Twat view</title>
</head>
<body>
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
		<form method='POST' action='twat'>
			<textarea name='comment' cols='31' rows='2' placeholder='Enter comment...'></textarea><br>
			<input type='submit' value='Post comment'/>
		</form>
		<br>
	</div>
</body>
</html>