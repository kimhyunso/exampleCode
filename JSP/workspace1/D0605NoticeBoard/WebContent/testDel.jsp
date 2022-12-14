<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="ssi.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/close.js">

</script>
</head>
<body>
<%
	int sa= Integer.parseInt(request.getParameter("idx"));
	sql="delete from bod where sabun = "+sa;
	st=con.createStatement();
	st.executeUpdate(sql);
%>



</body>
</html>