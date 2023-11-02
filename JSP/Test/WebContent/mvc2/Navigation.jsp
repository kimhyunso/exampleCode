<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	li{
		display: inline;
		padding-left:20%;
		padding-right:20%;
	}
</style>
</head>
<body>
	<ul>
		<li><a href="../mvc2/list.do">게시판</a></li>
		<c:choose>
			<c:when test="${not empty sessionScope.id and not empty sessionScope.pass}">
				<li style="padding-left:5%;">${sessionScope.nick}님 안녕하세요 &nbsp;&nbsp; <a href="../mvc2/logout.do">로그아웃</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="../mvc2/member.do">로그인</a></li>
			</c:otherwise>
		</c:choose>
	</ul>

</body>
</html>