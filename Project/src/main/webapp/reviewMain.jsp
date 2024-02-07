<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
 ul{
        list-style-type: none;
    }
    li{
        float: left;
        margin: 10px;
    }
</style>
</head>
<body>
<%@ include file ="header.jsp" %>
리뷰 페이지
<c:if test="${not empty reviewList}">
<table border="1">
<c:forEach var="list" items="${reviewList}">
<tr>	
<th><a href="infoReview.do?id=${list.id}&title=${list.title}&count=${list.countNum}">"${list.title}"</th>
<td>${list.wTime}</td>
<td>${list.nickname}</td>
<c:if test="${list.id eq info.id}">
	<td><a href="reviewinfo.jsp?count=${list.countNum}">수정</a></td>
</c:if>
</tr>
</c:forEach>
</table>
<ul>
	<c:forEach var="num" items="${page}">
		<li><a href="review.do?inum=${num}">${num}</a></li>
	</c:forEach>
</ul>
</c:if>
<c:if test="${empty reviewList}">
	게시글이 없습니다.
</c:if>
<c:if test="${sure}">
<a href="insert.do?id=${info.id}">리뷰 작성</a>
</c:if>
<c:if test="{!sure}">
<a href="log.do">로그인후 이용하세요</a>
</c:if>
</body>
</html>