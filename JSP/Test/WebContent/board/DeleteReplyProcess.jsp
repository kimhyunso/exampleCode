<%@page import="utils.JSFunction"%>
<%@page import="model1.board.ReplyDTO"%>
<%@page import="model1.board.ReplyDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%

	int rno = Integer.parseInt(request.getParameter("rno"));
	ReplyDAO dao = new ReplyDAO(application);
	
	ReplyDTO dto = dao.selectOne(rno);
	String sessionId = session.getAttribute("User_Id").toString();
	
	int result = 0;

	if(sessionId.equals(dto.getWriter())){
		result = dao.delet(rno);
		dao.close();
		
		if(result == 1)
			JSFunction.alertLocation("삭제되었습니다.", "View.jsp?num="+dto.getBno(), out);
		else
			JSFunction.alertBack("삭제에 실패하였습니다.", out);			
	}else{
		JSFunction.alertBack("본인만 삭제할 수 있습니다.", out);
		return;
		
	}
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