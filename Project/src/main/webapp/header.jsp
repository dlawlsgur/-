<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <head>
    <link rel="stylesheet" type="text/css" href="header.css">
    <!-- 기타 헤더 내용 -->
</head>
   
<div id="header">
    <div id="header_center">
        <div id="header_main"></div>
        <div id="header_menu">
            <ul>
                <li><a href="main.do">메인</a></li>
                <li>/</li>
                <li><a href="review.do?id=${info.id}">리뷰</a></li>
                <c:choose>
                <c:when test="${sure}">
                	<li><a href="zzimpage.do?id=${info.id}">찜 목록</a></li>
                </c:when>
                </c:choose>
            </ul>
        </div>
        <c:choose>
        	<c:when test="${sure}">
        		<div id="header_log">${info.nickname} / <a href="logOut.do">로그아웃</a> / <a href="memberinfo.jsp">수정</a></div>
        	</c:when>
        	<c:otherwise>
	            <div id="header_log">
	                <a href="log.do">로그인</a>
	            </div>
        	</c:otherwise>
        </c:choose>
    </div>
</div>