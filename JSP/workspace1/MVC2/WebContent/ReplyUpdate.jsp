<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/mycss/Reply.css" type="text/css" rel="stylesheet">
</head>
<body>

<%
	HttpSession se=request.getSession();
	String user_id=(String)se.getAttribute("user_id");
	String user_pw=(String)se.getAttribute("user_pw");
	String nickname=(String)se.getAttribute("nickname");
%>


<c:set value="${dtoreply}" var="dtoreply"></c:set>
<c:set value="${num}" var="num"></c:set>
<c:set value="${redto}" var="redto"></c:set>
<c:set value="<%=nickname%>" var="nickname"></c:set>
<c:set value="${cnt}" var="cnt"></c:set>

<div align="center" id="reply">
<table>
	<tr></tr>	
	
	<tr>
		<td align="right" colspan="8">리플갯수 (<c:out value="${cnt}"></c:out>) </td>
	</tr>
	
	<tr></tr>
	
	<c:forEach items="${list}" var="list">
		<tr id="replylist" align="center" onmouseOver="this.style.backgroundColor='lightgray'" onmouseOut="this.style.backgroundColor=''">
		<td><img alt="" src="images/${list.getImg()}" id="replylistimg"></td>
		<td>[Nick]<br> ${list.getNickname()}</td>
		<td>${list.getContent()}</td>
		<td>${list.getDate()}</td>
		</tr>
	</c:forEach>
	
	<tr></tr>
	
	<tr id="page">
	<td colspan="10" align="center">
		<c:forEach begin="${redto.getPagestart()}" end="${redto.getPageend()}" var="i">
			<a href="ControllReply.do?num=${num}&renum=${i}">[${i}]</a>
		</c:forEach>
	</td>
	</tr>
<c:choose>
	<c:when test="<%=user_id==null||user_pw==null%>">
		<form action="Login.jsp">
			<input type="submit" value="로그인하러가기" id="gologin" style="color:#FFFFFF">
		</form>
	</c:when>
	<c:otherwise>
<form action="ControllReply_Update.do" method="get">
	<input type="hidden" value="${dtoreply.getNum()}" name="num">
	<input type="hidden" value="${dtoreply.getKind()}" name="kind">
	<table id="replytable">
		<tr>
			<td align="center"><textarea rows="5" cols="100" name="content" id="replycontent">${dtoreply.getContent()}</textarea></td>
		</tr>
		
		<tr>
			<td colspan="2" align="right"><input type="submit" value="댓글수정" style="color:#FFFFFF" id="replysave"></td>
		</tr>
	</table>
</form>
</c:otherwise>
</c:choose>	
</table>
</div>
</body>
</html>