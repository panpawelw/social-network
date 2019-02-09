<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href='resources/style.css' rel='stylesheet' type='text/css'>
    <title>Message view</title>
</head>
<body>
<p class='right'>
    User:<a
        href='${pageContext.servletContext.contextPath}/user?id=${loggedInUser.id}'>${loggedInUser.username}</a>
    <a href='${pageContext.servletContext.contextPath}/signout'>Sign
        out</a>
<h1 class='center'>Social Network</h1>
<br>
<div class='center'>
    <form action='${pageContext.servletContext.contextPath}/home'>
        <input type='submit' value='Homepage' />
    </form>
</div>
<h3 class='center'>Message view</h3>
<br>
<br>
<div class='center'>
    <table class='center'>
        <tr>
            <th>Created</th>
            <th>Sender</th>
            <th>Receiver</th>
            <th>Text</th>
        </tr>
        <tr>
            <td>${message.created}</td>
            <td>${message.sender.username}</td>
            <td>${message.receiver.username}</td>
            <td>${message.text}</td>
        </tr>
    </table>
</div>
</body>
</html>