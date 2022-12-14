<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<script type="text/javascript">
	window.setTimeout("location.href='main.jsp'",2000);
</script>
</head>
<body>
<%
		session.setAttribute("ID", null);
		session.setAttribute("PW", null);
%>
wating....
</body>
</html>