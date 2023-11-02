<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function invalidForm(form){
		if(form.id.value == ""){
			alert("아이디를 입력하세요.");
			return false;
		}
		if(form.pass.value==""){
			alert("비밀번호를 입력하세요.");
			return false;
		}
		
	}
</script>

</head>
<body>
	<form action="../mvc2/member.do" method="post" onsubmit="return invalidForm(this);">
		<table width="90%" border="1">
			<tr>
				<td>
					아이디 : <input type="text" name="id">
				</td>
			</tr>
			<tr>
				<td>
					비밀번호 : <input type="password" name="pass">
				</td>
			</tr>
			<tr>
				<td>
					<input type="button" onclick="location.href='../mvc2/regist.do'" value="회원가입">
					<input type="submit" value="로그인">
					<input type="button" onclick="location.href='MemberDeleteView.jsp'" value="회원탈퇴">
				</td>
			</tr>
		</table>
	</form>
	

</body>
</html>