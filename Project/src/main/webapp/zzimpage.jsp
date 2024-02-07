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
	<c:when test="${empty list}">
		아직 찜한게 없습니다.
	</c:when>
	<c:otherwise>
		<table border="1" id="table_100" class="table">
			<caption><h2>찜목록</h2></caption>
		    <thead>
		        <tr>
		            <th>메뉴</th> 
		        </tr>
		    </thead>
		    <tbody>
		        <c:forEach var="list" items="${list}">
		            <tr>
		                <td><a href="${list.ref}">${list.pagename}</a></td>
		                <td><a href="zzimdel.do?name=${list.pagename}&id=${info.id}&pw=${info.pw}&ref=${list.ref}">삭제</a></td>
		            </tr>
		        </c:forEach>
		    </tbody>
		</table> 
	</c:otherwise>  
</c:choose> 
</body>
</html>