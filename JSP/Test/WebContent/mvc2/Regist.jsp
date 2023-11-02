<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/InvalidForm.js"></script>
</head>
<body>

	<form action="../mvc2/regist.do" method="post" onsubmit="return invalidForm(this);">
		<table border="1" width="90%">
			<tr>
				<td colspan="2">아이디 : <input type="text" name="id"></td>
			</tr>
			<tr>
				<td colspan="2">비밀번호 : <input type="password" name="pass"></td>
			</tr>
			<tr>
				<td colspan="2">닉네임 : <input type="text" name="nick"></td>
			</tr>
			<tr>
				<td><button type="submit">회원가입</button></td>
				<td><button type="reset">취소</button></td>
			</tr>
		</table>
	</form>

</body>
</html>