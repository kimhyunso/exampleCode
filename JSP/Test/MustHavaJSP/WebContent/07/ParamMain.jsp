<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String pValue = "방랑시인";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="person" class="common.Person"  scope="request"/>
	<jsp:setProperty property="name" name="person" value="김삿갓"/>
	<jsp:setProperty property="age" name="person" value="13"/>
	
	<jsp:forward page="ParamForward.jsp?param1=김병연">
		<jsp:param value="경기도양주" name="param2"/>
		<jsp:param name="param3" value="<%=pValue %>"/>
	</jsp:forward>

		
	

</body>
</html>