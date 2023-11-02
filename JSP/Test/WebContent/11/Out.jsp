<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="iTag">
		i 테그는 <i>기울임</i>을 표현합니다.
	</c:set>
	
	<h4>기본 사용</h4>
	<c:out value="${iTag }"></c:out>
	
	<h4>escapeXml 속성</h4>
	<c:out value="${iTag }" escapeXml="false"></c:out>
	
	<h4>default 속성</h4>
	<c:out value="${param.name}" default="이름 없음"></c:out>
	<c:out value="" default="빈 문자열도 값입니다."></c:out>
	
	
</body>
</html>