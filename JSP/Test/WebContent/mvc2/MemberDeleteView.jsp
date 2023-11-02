<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function confirmDelete(message,form){
		if(form.id.value == ""){
			alert("아이디를 입력해주세요.");
			form.id.focus();
			return false;
		}
		if(form.pass.value == ""){
			alert("아이디를 입력해주세요.");
			form.pass.focus();
			return false;
		}
			
		var result = confirm(message);
		
		if(result == 1){
			return true;
		}else{
			return false;
		}
	}

</script>
</head>
<body>
<form method="post" action="../mvc2/memberDelete.do" name="frm" onsubmit="return confirmDelete('정말 탈퇴하기겠습니까?',this);">
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
				<input type="submit" value="회원탈퇴">
			</td>
		</tr>
	</table>
</form>
	
</body>
</html>