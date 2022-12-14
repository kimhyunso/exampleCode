<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="ssi.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	img{width:70px; height:70px;}
</style>
</head>
<body>
	<%
		int sa=Integer.parseInt(request.getParameter("idx"));
		sql="select *from bod where sabun = "+sa;
		st=con.createStatement();
		rs=st.executeQuery(sql);
		rs.next();
		
		String path=rs.getString("path");
		String name=rs.getString("name");
		String title=rs.getString("title");
	%>
	
	<%out.print("<img src='./storage/"+path+"'>");%>
	<%=name%>
	<%=title%>
	
	
	
	
	
</body>
</html>