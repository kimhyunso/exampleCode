<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String outerPath1 = "OuterPage1";
	String outerPath2 = "OuterPage2.jsp";
	
	pageContext.setAttribute("pAttr", "동명왕");
	request.setAttribute("rAttr", "온조왕");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>지시어와 약션 태그 동작 방식 비교</h2>
	<%@ include file="OuterPage1.jsp" %>
	<p>외부 파일에 선언한 변수 : <%=newVar1 %></p>
	
	<h3>액션 태그로 페이지 포함하기</h3>
	<jsp:include page="OuterPage2.jsp"/>
	<jsp:include page="<%=outerPath2 %>"/>
	<p>외부 파일에 선언한 변수  <%-- <%=newVar2 %> --%></p>
</body>
</html>