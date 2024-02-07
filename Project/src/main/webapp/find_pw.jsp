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
<c:choose>
	<c:when test="${pw}">
		비밀번호는 "${find_pw}"
		<a href="log.jsp">로그인하러 가기</a>
	</c:when>
	<c:otherwise>
		아이디로 찾기 : 
		<form action="find_pw.do" method="post">
			<input type="text" name="id">
			<input type="submit" value="입력">
		</form>
	</c:otherwise>
</c:choose>
</body>
</html>