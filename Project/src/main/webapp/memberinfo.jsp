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
회원정보 수정
<form action="memberinfo.do" method="post">
아이디 : ${info.id}<br>
<input type="hidden" name="id" value="${info.id}">
비밀번호 : ${info.pw}<br>
<input type="hidden" name="pw" value="${info.pw}">
나이 : <input type="text" name="age" placeholder="${info.age}바꾸기"><br>
성별 : ${info.sex}<br>
폰번호 : <input type="text" name="phone" placeholder="${info.phone}바꾸기"><br>
이메일 : ${info.email}<br>
닉네임 : <input type="text" name="nickname" placeholder="${info.nickname}바꾸기"><br>
<input type="submit" value="입력">
</form>
</body>
</html>