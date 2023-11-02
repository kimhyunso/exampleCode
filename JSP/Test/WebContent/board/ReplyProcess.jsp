<%@page import="utils.JSFunction"%>
<%@page import="model1.board.ReplyDTO"%>
<%@page import="model1.board.ReplyDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ReplyDAO dao = new ReplyDAO(application);
	ReplyDTO dto = new ReplyDTO();

	request.setCharacterEncoding("UTF-8");
	dto.setBno(request.getParameter("bno"));
	dto.setWriter(session.getAttribute("User_Id").toString());
	dto.setContent(request.getParameter("reply_text"));
	dto.setGrp(0);
	
	int result = dao.insert(dto);
	dao.close();
	
	if(result == 1)
		response.sendRedirect("View.jsp?num="+dto.getBno());
	else
		JSFunction.alertBack("댓글 달기 실패하였습니다.", out);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>