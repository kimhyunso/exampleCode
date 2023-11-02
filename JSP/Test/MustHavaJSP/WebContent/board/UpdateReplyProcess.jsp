<%@page import="utils.JSFunction"%>
<%@page import="model1.board.ReplyDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	int rno = Integer.parseInt(request.getParameter("rno"));
	String content = request.getParameter("reply_text");
	String bno = request.getParameter("bno");
	ReplyDAO dao = new ReplyDAO(application);
	int result = dao.update(rno, content);
	if(result == 1)
		response.sendRedirect("View.jsp?num="+bno);
	else
		JSFunction.alertLocation("수정이 안되었습니다.", "UpdateReply.jsp", out);


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