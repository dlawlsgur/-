<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Main Page</title>
    <style>
    body{

            margin: 0;
            padding: 0;
    }
    ul{
        list-style-type: none;
    }
    li{
        float: left;
        margin: 10px;
    }
    #header{
        margin: 0;
        width: 100%;
        height: 300px;
        border: 2px solid;
        border-bottom-color: black;
        border-top:none;
        border-right:none ;
        border-left:none ;
        
      
    }
    #header_center{

        height: 100%;
        width: 1000px;
        margin: 0 auto;
        
        position: relative;
    }
    #header_main{
        position: absolute;
        bottom: 0;
        background-image: url("resources/img/메인로고.png");
        width: 180px;
        height: 180px;
        
    }
    #header_menu{
        position: absolute;
        bottom: 20px;
        margin-left: 328px;
        font-size: 2em;
        
    }
    #header_log{
        position: absolute;
        right: 0;
        font-size: 1.5em;
    }
     #section{
        margin: 0;
        width: 100%;
        height: 1500px;
        
        
        
    }
    #section_main{
       
        height: 100%;
        width: 1000px;
        margin: 0 auto;
        position: relative;
        
        display: flex;
        justify-content: center;
        align-items: center;
    }
    #table_100{
        position: absolute;
        top:0;
   
        

    }
    #table_150{
        position: absolute;
        top: 500px;
    }
    #table_냉동{
        position: absolute;
        top: 900px;
    }
    a{
    	text-decoration: none;
    	color: black;
    }
     table{
        
        border-color: black;
        font-size: 1.2em;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);

    } 
    th,td{
       
    }   
    td{
        padding: 0 15px;
        padding-top: 10px;
        padding-bottom: 8px;
    }


</style>
</head>

<body>
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
<div id="section">
	<div id="section_main">
		<table border="1" id="table_100" class="table">
			<caption><h2>닭가슴살 100g Best5!!!</h2></caption>
		    <thead>
		        <tr>
		            <th>메뉴</th>
		            <th>가격</th>
		            <c:choose>
		           	<c:when test="${sure}">
		           		
		            	<th>찜</th>
		            	
		            </c:when>
		            </c:choose>
		        </tr>
		    </thead>
		    <tbody>
		        <c:forEach var="ch" items="${chickenList0}">
		            <tr>
		                <td><a href="${ch.ref}">${ch.menu}</a></td>
		                <td>${ch.price}</td>
		                <c:choose>
		                <c:when test="${sure}">
		                
		               	 <td><a href="zzim.do?id=${info.id}&pagename=${ch.menu}&ref=${ch.ref}">찜</a></td>
		               	   
		            	</c:when>
		            	</c:choose>
		            </tr>
		        </c:forEach>
		    </tbody>
		</table>    
		<table border="1" id="table_150" class="table">
			<caption><h2>닭가슴살 150g Best5!!!</h2></caption>
		    <thead>
		        <tr>
		            <th>메뉴</th>
		            <th>가격</th>
		            <c:choose>
		            <c:when test="${sure}">
		            	
		            	<th>찜</th>
		            	
		            </c:when>
		            </c:choose>
		        </tr>
		    </thead>
		    <tbody>
		        <c:forEach var="ch" items="${chickenList1}">
		            <tr>
		                <td><a href="${ch.ref}">${ch.menu}</a></td>
		                <td>${ch.price}</td> 
		                <c:choose>   
		                <c:when test="${sure}">
		                	 
		               	 		<td><a href="zzim.do?id=${info.id}&pagename=${ch.menu}&ref=${ch.ref}">찜</a></td>
		               	 	
		            	</c:when>
		            	</c:choose>
		            </tr>
		        </c:forEach>
		    </tbody>
		</table>
		
		
		<table border="1" id="table_냉동" class="table">
			<caption><h2>닭가슴살 냉동 Best5!!!</h2></caption>
		    <thead>
		        <tr>
		            <th>메뉴</th>
		            <th>가격</th>
		            <c:choose>
		          <c:when test="${sure}">
		            	
		            	<th>찜</th>
		            	
		            </c:when>
		            </c:choose>
		        </tr>
		    </thead>
		    <tbody>
		        <c:forEach var="ch" items="${chickenList2}">
		            <tr>
		                <td><a href="${ch.ref}">${ch.menu}</a></td>
		                <td>${ch.price}</td>
		                <c:choose>
		                <c:when test="${sure}">
		                	 
		               	 			<td><a href="zzim.do?id=${info.id}&pagename=${ch.menu}&ref=${ch.ref}">찜</a></td>
		               	 	 
		            	</c:when>
		            	</c:choose>
		            </tr>
		        </c:forEach>
		    </tbody>
		</table>
	</div>
</div>
<c:if test="${zzim}">
이미 찜한 페이지입니다.
</c:if>
</body>
</html>