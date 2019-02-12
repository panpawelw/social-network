<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href='resources/style.css' rel='stylesheet' type='text/css'>
    <title>User view</title>
</head>
<body>
<p class='right'>User:<a href='${pageContext.servletContext.contextPath}/user?id=${loggedInUser.id}'>${loggedInUser.username}</a>
    <a href='${pageContext.servletContext.contextPath}/signout'>Sign out</a>
<h1 class='center'>Social Network</h1>
<br>
<div class='center'>
    <form action='${pageContext.servletContext.contextPath}/home'>
        <input type='submit' value='Homepage'/>
    </form>
</div>
<br>
<div class='center'>
    <form:form method='POST' modelAttribute='message' action='sendmessage'>
        <input type='hidden' name='senderId' value='${loggedInUser.id}'/>
        <form:textarea path='text' cols='31' rows='4' placeholder='Enter message...'> </form:textarea><br>
        <input type='hidden' name='receiverId' value='${usersTwats[0].user.id}'/><br>
        <form:errors path='*' cssClass='error'/><br><br>
        <input type='submit' value='Send message to ${usersTwats[0].user.username}'/>
    </form:form>
    <br>
</div>
<div class='center'>
    <h3 class='center'>User ${usersTwats[0].user.username}'s posts</h3>
    <br>
    <table class='center'>
        <tr>
            <th>Created</th>
            <th>Text</th>
            <th>Comments</th>
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
</body>
</html>