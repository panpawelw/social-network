<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add new Twat</title>
</head>
<body>
	<h3 align='center'>Add new Twat</h3>
	<br><br><br>
	<div align='center'>
		<form:form method='POST' modelAttribute='twat'>
			<form:textarea path='text' cols='71' rows='2' maxlength='140' placeholder='Enter maximum of 140 characters...'/><br>
			<input type='submit' value='Add twat'/>
		</form:form>
		<br>
		<form action='javascript:history.go(-1)'>
			<input type='submit' value='Cancel'/>
		</form>
	</div>
</body>
</html>