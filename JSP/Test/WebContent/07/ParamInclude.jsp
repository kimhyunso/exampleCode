<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>인클루드된 페이제에서 매개변수 확인</h2>
	<%=request.getParameter("loc1") %>
	<%=request.getParameter("loc2") %>
</body>
</html>