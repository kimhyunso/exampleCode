<%@page import="java.util.List"%>
<%@page import="model1.board.ReplyDAO"%>
<%@page import="model1.board.ReplyDTO"%>
<%@page import="model1.board.BoardDTO"%>
<%@page import="model1.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String num = request.getParameter("num");

	BoardDAO dao = new BoardDAO(application);
	dao.updateVisitCount(num);
	BoardDTO dto = dao.selectView(num);
	dao.close();
	
	ReplyDAO rdao = new ReplyDAO(application);
	List<ReplyDTO> list = rdao.selectAll(num);
	rdao.close();
	

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function deletePost(){
		var confirmed = confirm("정말로 삭제하시겠습니까?");
		if(confirmed){
			var form = document.writeFrm;
			form.method = "post";
			form.action = "DeleteProcess.jsp";
			form.submit();
			
		}
	}
	
	function validateForm(form){
		if(form.reply_text.value == "" || form.reply_text.value == null){
			alert("내용을 입력하세요.");
			form.reply_text.focus();
			return false;
		}
	}
	
	function myClick(button, rno){
		
		var bno = <%=num%>;
		
		if(button.name == "rup_Button"){
			location.href="UpdateReply.jsp?rno="+rno+"&bno="+bno;
		}
			
		if(button.name == "rdel_Button"){
			location.href="DeleteReplyProcess.jsp?rno="+rno;
		}
		
	}

	
</script>
</head>
<body>
	<jsp:include page="../common/Link.jsp"/>
	<h2>회원제 게시판 - 상세 보기</h2>
	<form name="writeFrm">
		<input type="hidden" name="num" value="<%=num%>">
		<table border="1" width="90%">
			<tr>
				<td>번호</td>
				<td><%=dto.getNum() %></td>
				<td>작성자</td>
				<td><%=dto.getName() %></td>
			</tr>
			<tr>
				<td>작성일</td>
				<td><%=dto.getPostdate() %></td>
				<td>조회수</td>
				<td><%=dto.getVisitcount() %></td>
			</tr>
			<tr>
				<td>제목</td>
				<td colspan="3"><%=dto.getTitle() %></td>
			</tr>
			<tr>
				<td colspan="4" align="center">
					<%
					if(session.getAttribute("User_Id") != null && session.getAttribute("User_Id").toString().equals(dto.getId())){
					%>
					<button type="button" onclick="location.href='Edit.jsp?num=<%=dto.getNum()%>';">수정하기</button>	
					<button type="button" onclick="deletePost();">삭제하기</button>	
					<%	
					}
					%>
					<button type="button" onclick="location.href='List.jsp?sort=desc';">목록보기</button>
				</td>
			</tr>
		</table>
	</form>
	
	<form action="ReplyProcess.jsp" name="form" action="post" onsubmit="return validateForm(this);">
		<input type="hidden" name="bno" value="<%=num%>">
		<table border="1" width="90%">
			<tr>
				<th colspan="4">댓글</th>
			</tr>
			<%
			if(session.getAttribute("User_Id") != null){
			%>
			<tr>
				<td width="20%">내용</td>
				<td colspan="3"><textarea name="reply_text" style="width:90%; height:50px;"></textarea></td>
			</tr>
			<tr>
				<td colspan="4" align="right"><button type="submit">댓글달기</button></td>
			<%
			}
			%>
			</tr>
			<tr>
				<th width="10%">작성자</th>
				<th width="50%">내용</th>
				<th width="10%">날짜</th>
				<th width="20%">버튼</th>
			</tr>
				<%
				if(list.isEmpty()){
	
				%>
				<tr>
					<td colspan="4">댓글이 없습니다.</td>
				</tr>
				<%
				}else{
				%>
				<%
					for(ReplyDTO rdto : list){
				%>
					<tr>
				<%
						if(rdto.getGrp() != 0){
				%>
							<td width="10%">L<%=rdto.getWriter() %></td>
							<td width="50%"><%=rdto.getContent()%></td>
							<td width="10%"><%=rdto.getWdate()%></td>
							<%
							if(session.getAttribute("User_Id") != null && session.getAttribute("User_Id").equals(rdto.getWriter())){
							%>
							<td width="20%" align="right">
								<button type="button" name="rup_Button" onclick="myClick(this, <%=rdto.getRno()%>);">수정하기</button>
								<button type="button" name="rdel_Button" onclick="myClick(this, <%=rdto.getRno()%>);">삭제하기</button>
							</td>		
							<%
							}
							%>
				<%
						}else{
				%>
							<td width="10%"><%=rdto.getWriter() %></td>
							<td width="50%"><%=rdto.getContent()%></td>
							<td width="10%"><%=rdto.getWdate()%></td>
							<%
							if(session.getAttribute("User_Id") != null && session.getAttribute("User_Id").equals(rdto.getWriter())){
							%>
							<td width="20%" align="right">
								<button type="button" name="rup_Button" onclick="myClick(this, <%=rdto.getRno()%>);">수정하기</button>
								<button type="button" name="rdel_Button" onclick="myClick(this, <%=rdto.getRno()%>);">삭제하기</button>
							</td>
							<%
							}
							%>
				<%
						}
				%>
					</tr>
				<%
					}
				}
				%>
		</table>
	</form>
	
	
	

</body>
</html>