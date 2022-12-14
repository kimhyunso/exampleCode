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

	<form action="../mvc2/replyUpdate.do" method="post" onsubmit="return invalidForm(this);">
		<input type="hidden" value="${param.idx }" name="idx">
		<input type="hidden" value="${param.ridx }" name="ridx">
		
		<textarea style="width:150px; height:200px;" name="content"></textarea>
		<br>
		<input type="submit" value="수정하기">
		<input type="reset" value="RESET">
		<input type="button" value="목록 바로가기" onclick="location.href='view.do?idx='+${param.idx}">
	</form>
	
</body>
</html>