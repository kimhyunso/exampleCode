<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="IncludeCore.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title>[BordReply]</title>
<link href="css/mycss/Reply.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="js/myjs/Reply.js">
</script>
</head>
<body>
<%
	HttpSession se=request.getSession();
	String user_id=(String)se.getAttribute("user_id");
	String user_pw=(String)se.getAttribute("user_pw");
	String nickname=(String)se.getAttribute("nickname");
%>
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
		<c:choose>
			<c:when test="${list.getNickname()==nickname}">
			<td><a href="ControllReply_Delete.do?num=${num}&kind=${list.getKind()}">[X]</a></td>
			<td><a href="ControllReply.do?num=${num}&kind=${list.getKind()}">[수정]</a></td>
			</c:when>
			<c:otherwise><td></td></c:otherwise>
		</c:choose>
		</tr>
	</c:forEach>
	
	<tr></tr>
	
	<tr id="page">
	<td colspan="10" align="center">
		<c:forEach begin="${redto.getPagestart()}" end="${redto.getPageend()}" var="i">
			<a href="ControllBordDetail.do?num=${num}&renum=${i}">[${i}]</a>
		</c:forEach>
	</td>
	</tr>
	
<c:choose>
	<c:when test="<%=user_id==null||user_pw==null%>">
		<tr>
		<td colspan="5">
			<form action="Login.jsp">
			<input type="submit" value="로그인하러가기" id="gologin" style="color:#FFFFFF">
			</form>	
		</td>
		</tr>
	</c:when>
	<c:otherwise>
		<form action="ControllReply_Insert.do" method="get">
			<input type="hidden" value="${num}" name="num">
			<table id="replytable">
				<tr>
					<td align="center"><textarea rows="5" cols="100" name="content" id="replycontent"></textarea></td>
				</tr>
				
				<tr>
					<td colspan="2" align="right"><input type="submit" value="댓글 저장" style="color:#FFFFFF" id="replysave"></td>
				</tr>
			</table>
		</form>
	</c:otherwise>
</c:choose>	



</table>
</div>

</body>
</html>