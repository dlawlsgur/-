<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Review Detail</title>
</head>
<body>
<%@ include file ="header.jsp" %>
    <h2>Review Detail</h2>

    
    <table>
        <tr>
            <td>Title:</td>
            <td>${main.title}</td>
        </tr>
        <tr>
            <td>Nickname:</td>
            <td>${main.nickname}</td>
        </tr>
        <tr>
            <td>Writing:</td>
            <td>${main.writing}</td>
        </tr>
        <tr>
        	<td><a href="${main.ref}">${main.pagename}</a></td>
        </tr>
        <!-- Add more fields as needed -->
    </table>

    
    <h3>Replies</h3>
    <c:forEach var="post" items="${post}">
        <table>
            <tr>
                <td>Nickname:</td>
                <td>${post.nickname}</td>
            </tr>
            <tr>
                <td>Writing:</td>
                <td>${post.post}</td>
        </table>
        <hr/>
    </c:forEach>
    <h3>Reply to Review</h3>
    <c:if test="${sure}">
    <form action="reinsertReview.do" method="post">
        <input type="hidden" name="myid" value="${info.id}" />
        <input type="hidden" name="mynickname" value="${info.nickname}" />
        <input type="hidden" name="count" value="${main.countNum}" />
        <label for="post">Your Reply:</label>
        <textarea name="post" rows="4" cols="50"></textarea><br/>
        
        <input type="submit" value="Submit Reply" />
    </form>
    </c:if>
    <c:if test="{!sure}">
    <a href=log.do">로그인후 이용하세요.</a>
    </c:if>

    <!-- Add any additional content as needed -->
</body>
</html>