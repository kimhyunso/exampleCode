<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<div align="center">
	<form action="ControllLogin_Delete.do">
		ȸ��Ż�� ���� ���̵� �Է����ּ���!<p>
		<input type="text" placeholder="���̵�..." size="35px" maxlength="15" onkeyup="this.value=this.value.replace(/[^a-zA-Z-_0-9]/g,'')" name="id"><p>
		<input type="submit" value="ȸ��Ż��">
	</form>
</div>
</body>
</html>