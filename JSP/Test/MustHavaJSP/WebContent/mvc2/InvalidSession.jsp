<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
</style>
</head>
<body>
	<c:if test="${empty sessionScope.id and empty sessionScope.pass }">
		<script>
			alert("로그인을 해야합니다.");
			location.href="../mvc2/member.do";
		</script>
	</c:if>
</body>
</html>



