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
<h1>싸닭</h1>

<c:choose>
	<c:when test="${id}">
		아이디는 "${find_id}" 입니다.
		<a href="log.jsp">로그인하러 가기</a>
		<a href="find_pw.jsp">비밀번호 찾기</a>
	</c:when>
	<c:otherwise>
		<form action="find_id.do" method="post">
		<input type="text" name="phone" placeholder="phone(- 없이 입력)"></input>
		<br>
		<input type="text" name="email" placeholder="emai입력"></input>
		<br>
		<input type="submit" value="확인">
		</form>
	</c:otherwise>
</c:choose>
</body>
</html>