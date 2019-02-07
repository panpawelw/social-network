<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href='resources/style.css' rel='stylesheet' type='text/css'>
    <title>Social Network</title>
</head>
<body>
<p class='right'>User:<a href='${pageContext.servletContext.contextPath}/user?id=${loggedInUser.id}'>${loggedInUser.username}</a>
    <a href='${pageContext.servletContext.contextPath}/signout'>Sign out</a>
<h1 class='center'>Social Network</h1>
<br><br>
<h3 class='center'>Posts list</h3>
<br>
<div class='center'>
    <form action='newpost' method='GET'>
        <input type='submit' value='New post'/>
    </form>
</div>
<br>
<div class='center'>
    <table class='center'>
        <tr>
            <th>Created</th>
            <th>User</th>
            <th>Text</th>
        </tr>
        <c:forEach items='${allPosts}' var='post'>
            <tr>
                <td>${post.created}</td>
                <td><a href='${pageContext.servletContext.contextPath}/user?id=${post.user.id}'>${post.user.username}</a></td>
                <td><a href='${pageContext.servletContext.contextPath}/post?id=${post.id}'>${post.text}</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>