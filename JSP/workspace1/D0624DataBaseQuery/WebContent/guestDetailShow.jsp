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
		<td>��� : <%=dto.getSabun()%></td>
	</tr>
	<tr>
		<td>�̸� : <%=dto.getName()%></td>
	</tr>
	<tr>
		<td>���� : <%=dto.getTitle()%></td>
	</tr>
	<tr>
		<td>��¥ : <%=dto.getNalja()%></td>
	</tr>
	<tr>
		<td>�޿� : <%=dto.getPay()%></td>
	</tr>
</table>
</div>
<jsp:include page="guestReply.jsp">
	<jsp:param value="<%=dto.getSabun()%>" name="sabun"/>
</jsp:include>

</body>
</html>