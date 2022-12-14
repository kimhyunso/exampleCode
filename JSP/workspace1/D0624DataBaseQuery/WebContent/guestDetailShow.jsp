<%@page import="java.util.ArrayList"%>
<%@page import="net.itbank.com.DTOGuest"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<title>[guestDetailShow]</title>
</head>
<body>
<%
	DTOGuest dto=(DTOGuest)request.getAttribute("dto");
%>

<div align="center">
<table>
	<tr>
		<td>사번 : <%=dto.getSabun()%></td>
	</tr>
	<tr>
		<td>이름 : <%=dto.getName()%></td>
	</tr>
	<tr>
		<td>제목 : <%=dto.getTitle()%></td>
	</tr>
	<tr>
		<td>날짜 : <%=dto.getNalja()%></td>
	</tr>
	<tr>
		<td>급여 : <%=dto.getPay()%></td>
	</tr>
</table>
</div>
<jsp:include page="guestReply.jsp">
	<jsp:param value="<%=dto.getSabun()%>" name="sabun"/>
</jsp:include>

</body>
</html>