<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function validateForm() {
  var id = document.forms["memberForm"]["id"].value;
  var pw = document.forms["memberForm"]["pw"].value;
  var age = document.forms["memberForm"]["age"].value;
  var sex = document.forms["memberForm"]["sex"].value;
  var phone = document.forms["memberForm"]["phone"].value;
  var email = document.forms["memberForm"]["email"].value;
  var nickname = document.forms["memberForm"]["nickname"].value;

  // 아이디 유효성 검사 (예: 5자 이상)
  if (id.length < 5) {
    alert('아이디는 5자 이상이어야 합니다.');
    return false;
  }

  // 비밀번호 유효성 검사 (예: 8자 이상, 영문 대/소문자, 숫자, 특수문자 포함)
  var passwordRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;
  if (!passwordRegex.test(pw)) {
    alert('비밀번호는 8자 이상이어야 하며, 영문 대/소문자, 숫자, 특수문자를 모두 포함해야 합니다.');
    return false;
  }

  // 나이 유효성 검사 (숫자만 입력)
  if (isNaN(age) || age === "") {
    alert('나이는 숫자만 입력해야 합니다.');
    return false;
  }

  // 폰번호 유효성 검사 (숫자만 입력)
  if (isNaN(phone.replace(/-/g, '')) || phone === "") {
    alert('폰번호는 숫자만 입력해야 합니다.');
    return false;
  }

  // 이메일 유효성 검사 (중간에 @ 확인)
  if (email.indexOf('@') === -1) {
    alert('이메일은 유효한 형식이어야 합니다.');
    return false;
  }

  // 나머지 필드 유효성 검사 (예: 닉네임은 필수)
  if (nickname === "") {
    alert('닉네임은 필수 입력 항목입니다.');
    return false;
  }

  return true;
}
</script>
</head>
<body>
<%@ include file ="header.jsp" %>
회원가입
<form name="memberForm" onsubmit="return validateForm()" action="member.do" method="post">
<input type="text" name="id" placeholder="아이디 입력"><br>
<input type="password" name="pw" placeholder="비밀번호 입력"><br>
<input type="text" name="age" placeholder="나이 입력"><br>
<select name="sex"><option value="남성">남성</option><option value="여성">여성</option></select><br>
<input type="text" name="phone" placeholder="폰번호(- 없이) 입력"><br>
<input type="text" name="email" placeholder="이메일 입력"><br>
<input type="text" name="nickname" placeholder="닉네임 입력"><br>
<input type="submit" value="입력">
</form>
</body>
</html>