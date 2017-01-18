<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8"/>
	<title>/users/private/updateform.jsp</title>
</head>
<body>
	<h3>회원정보 수정 페이지 입니다.</h3>
	<form action="update.do" method="post"> 
		<input type="hidden" name="id" value="${dto.id }"/>
		<label for="id">아이디</label>
		<input type="text" id="id" value="${dto.id }" disabled="disabled"/><br />
		<label for="pwd">비밀번호</label>
		<input type="password" name="pwd" id="pwd" /><br />
		<label for="pwd2">비밀번호 확인</label>
		<input type="password" id="pwd2" /><br />
		<label for="email">이메일</label>
		<input type="text" name="email" id="email" value="${dto.email }" /><br />
		<button type="submit">수정확인</button>
	</form>
	<script>
		document.querySelectot("#updateForm")
		.addEventListener("submit", function(event) {
			var inputPwd = document.querySelector("#pwd").vlalue;
			var inputPwd2 = document.querySelector("#pwd2").vlalue;
			if(inputPwd != inputPwd2) {
				alert("비밀번호를 확인하세요");
				event.preventDefault(); // 폼 전송 막기
			}
		})
	</script>
</body>
</html>