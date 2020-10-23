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
    <title>Post view</title>
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
<h3 class='center'>Post view</h3>
<br>
<br>
<div class='center'>
    <table class='center'>
        <tr>
            <th>Created</th>
            <th>User</th>
            <th>Text</th>
        </tr>
        <tr>
            <td>${post.created}</td>
            <td><a href='${pageContext.servletContext.contextPath}/user?id=${post.user.id}'>${post.user.username}</a></td>
            <td>${post.text}</td>
        </tr>
    </table>
</div>
<h3 class='center'>Comments: ${fn:length(allComments)}</h3>
<div class='center'>
    <table class='center'>
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
    <form:form method='POST' modelAttribute='comment' action='comment'>
        <form:textarea path='text' cols='31' rows='2' maxlength='60' placeholder='Enter comment...'></form:textarea><br>
        <input type='hidden' name='postId' value='${post.id}'/><br>
        <form:errors path='*' cssClass='error'/><br><br>
        <input type='submit' value='Post comment'/>
    </form:form>
    <br>
</div>
</body>
</html>