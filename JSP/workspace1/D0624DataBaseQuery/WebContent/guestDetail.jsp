<%@page import="net.itbank.com.DTOGuest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>[guestDetail]</title>
</head>
<body>
<%
	int sabun = Integer.parseInt(request.getParameter("sabun"));
	response.sendRedirect("DetailControll.do?sabun="+sabun);
%>

</body>
</html>