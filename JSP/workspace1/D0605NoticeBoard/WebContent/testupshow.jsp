<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="ssi.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	sabun= Integer.parseInt(request.getParameter("idx"));
%>


<form action="testup.jsp" method="post" enctype="multipart/form-data">
	<input type="hidden" name="hide" value="<%=sabun%>">
	이름 : <input type="text" name="name"><br>
	제목 : <input type="text" name="title"><br>
	그림 : <input type="file" name="file"><br>
	<input type="submit" value="전송"><input type="reset" value="취소">
</form>
</body>
</html>