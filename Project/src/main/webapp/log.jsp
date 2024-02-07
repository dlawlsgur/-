<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
  #sure {
    width: 0;
    height: 0;
    overflow: hidden;
    border: none; 
    padding: 0; 
    margin: 0; 
  }
   ul{
        list-style-type: none;
    }
    li{
        float: left;
        margin: 2px;
    }
</style>
<script>
function validateForm() {
  var username = document.getElementById('username').value;
  var password = document.getElementById('password').value;
  var usernameError = document.getElementById('usernameError');
  var passwordError = document.getElementById('passwordError');

  // 아이디 유효성 검사 (예: 5자 이상)
  if (username.length < 5) {
    usernameError.innerHTML = '아이디는 5자 이상이어야 합니다.';
    return false;
  } else {
    usernameError.innerHTML = '';
  }

  // 비밀번호 유효성 검사 (예: 8자 이상, 영문 대/소문자, 숫자, 특수문자 포함)
  var passwordRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;
  if (!passwordRegex.test(password)) {
    passwordError.innerHTML = '비밀번호는 8자 이상이어야 하며, 영문 대/소문자, 숫자, 특수문자를 모두 포함해야 합니다.';
    return false;
  } else {
    passwordError.innerHTML = '';
  }

  return true;
}
</script>
</head>
<body>
<%@ include file ="header.jsp" %>
<c:if test="${sure}">
  <input type="button" id="sure">
</c:if>

<form id="loginForm" onsubmit="return validateForm()" action="log.do" method="post">
  <label for="username">아이디:</label>
  <input type="text" id="username" name="id"  placeholder="${vo.id}" required>
  <span id="usernameError" class="error"></span><br>

  <label for="password">비밀번호:</label>
  <input type="password" id="password" name="pw" placeholder="${vo.pw}" required>
  <span id="passwordError" class="error"></span><br>

  <input type="submit" value="로그인">
</form>
<ul>
  <li><a href="find_id.jsp">아이디 찾기</a></li>
  <li>|</li>
  <li><a href="find_pw.jsp">비밀번호 찾기 찾기</a></li>
  <li>|</li>
  <li><a href="member.jsp">회원가입</a></li>
</ul>
</body>
</html>