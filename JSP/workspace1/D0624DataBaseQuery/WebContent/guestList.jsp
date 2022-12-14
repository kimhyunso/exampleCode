<%@page import="net.itbank.com.DTOGuest"%>
<%@page import="java.util.ArrayList"%>
<%@page import="net.itbank.com.DTOPage"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<title>[guestList]</title>
<style type="text/css">
	table a{text-decoration: none; color:#889966;}
	table a:hover{text-decoration: underline; color:#779988;}
</style>
</head>
<body> 
<c:set value="${count}" var="count"></c:set>
<%
	DTOPage pdto = (DTOPage)request.getAttribute("pdto");
%>
<div align="center">
<table width="1000">
	<tr align="right">
		<td colspan="7">레코드 갯수 : ${count}</td>
	</tr>
	<tr bgcolor="#ff6688">
		<td>번호</td>
		<td>이름</td>
		<td>제목</td>
		<td>날짜</td>
		<td>급여</td>
		<td>조회수</td>
		<td>비고</td>
	</tr>
	
	<c:forEach  var="list" items="${list}" >
	<tr align="center">
		<td>${list.getRn()}</td>
		<td>${list.getName()}</td>
		<td><a href="guestDetail.jsp?sabun=${list.getSabun()}">${list.getTitle()} </a></td>
		<td>${list.getNalja()}</td>
		<td>${list.getPay()}</td>
		<td>${list.getPoint()}</td>
		<td><a href="Update.jsp?sabun=${list.getSabun()}">[수정]</a> <a href="DeleteControll.do?Gidx=${list.getSabun()}">[삭제]</a></td>
	</tr>
	</c:forEach>
	<tr align="center">
		<td><a href="Insert.jsp">[입력]</a></td>
	</tr>
	<tr align="center">
		<td colspan="7">
			<c:if test="<%=pdto.getPagestart()>10%>"><a href="ListControll.do?Gidx=<%=1%>&keyfield=<%=pdto.getSkey()%>&keyword=<%=pdto.getSval()%>">[<<]</a><a href="ListControll.do?Gidx=<%=pdto.getPagestart()-10%>&keyfield=<%=pdto.getSkey()%>&keyword=<%=pdto.getSval()%>">[이전]</a></c:if>
		
			<c:forEach begin="<%=pdto.getPagestart()%>" end="<%=pdto.getPageend()%>" var="i">
				<a href="ListControll.do?Gidx=${i}&keyfield=<%=pdto.getSkey()%>&keyword=<%=pdto.getSval()%>">[${i}]</a>
			</c:forEach>
			
			<c:if test="<%=pdto.getPageend()<pdto.getPagecount()%>"><a href="ListControll.do?Gidx=<%=pdto.getPagestart()+10%>&keyfield=<%=pdto.getSkey()%>&keyword=<%=pdto.getSval()%>">[다음]</a><a href="ListControll.do?Gidx=<%=pdto.getPagecount()%>&keyfield=<%=pdto.getSkey()%>&keyword=<%=pdto.getSval()%>">[>>]</a></c:if>
		</td>
	</tr>
	
	<tr align="center">
		<td colspan="7">
		<form action="ListControll.do" method="get">
			<select name="keyfield">
				<option value="title">제목검색</option>
				<option value="name">이름검색</option>
			</select>
			<input type="text" name="keyword"><input type="submit" value="전송">
		</form>
		</td>	
	</tr>
</table>
</div>
</body>
</html>