<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int rno =Integer.parseInt(request.getParameter("rno"));
	String bno = request.getParameter("bno");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function validateForm(form){
		if(form.reply_text.value == "" || form.reply_text.value == null){
			alert("내용을 입력하세요.");
			form.reply_text.focus();
			return false;
		}
	}
</script>
</head>
<body>
	<jsp:include page="../common/Link.jsp"/>
	<h2>댓글 - 댓글 수정</h2>
	<form action="UpdateReplyProcess.jsp" method="post" name="form" onsubmit="return validateForm(this);">
		<input type="hidden" value="<%=rno%>" name="rno">
		<input type="hidden" value="<%=bno%>" name="bno">
		<table border="1" width="90%">
			<tr>
				<td>내용</td>
				<td><textarea style="width:90%; height:100px;" name="reply_text"></textarea></td>
			</tr>
			<tr>
				<td align="right"><button type="submit">수정하기</button></td>
			</tr>
		</table>
	
	</form>

</body>
</html>