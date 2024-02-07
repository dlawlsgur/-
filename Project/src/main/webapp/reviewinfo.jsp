<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file ="header.jsp" %>
<form action="reviewinfo.do" method="post">
    id : ${info.id}<br>
    nickname : ${info.nickname}<input type="hidden" name="nickname" value="${info.nickname}"><br>
    title : <input type="text" name="title" placeholder="제목"><br>
    내용 : <textarea rows="30" cols="30" name="writing"></textarea><br>
    <c:choose>
    	<c:when test="${empty list}">
    		<input type="hidden" name="list" value="null">
    	</c:when>
    	<c:otherwise> 	
		    <select name="list">
		        <c:forEach var="item" items="${list}">
		            <option value="${item.pagename}">${item.pagename}</option>
		        </c:forEach>
		    </select><br>
		</c:otherwise>
     </c:choose>
	<input type="hidden"  name="count" value="${param.count}">
    <input type="submit" value="입력">
</form>
<a href="review.do">목록보기</a>
</body>
</html>