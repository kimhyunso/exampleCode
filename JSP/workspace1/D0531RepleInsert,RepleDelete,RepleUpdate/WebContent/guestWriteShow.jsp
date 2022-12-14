<%@page import="javax.jws.soap.SOAPBinding.Use"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="ssi.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title> [index.jsp]</title>
  <script type="text/javascript">
    window.setTimeout("location.href='guestList.jsp'",3000);
  </script>
</head>
<body>
<jsp:useBean id="gt" class="net.itback.com.DBGuest"/>
<%	
	int s=Integer.parseInt(request.getParameter("isabun"));
	String na=request.getParameter("iname");
	String ti=request.getParameter("ititle");
	int pa=Integer.parseInt(request.getParameter("ipay"));
	gt.dbinsert(s, na, ti, pa);
%>

  <div align="center" style="margin-top:50px;" >
 	<img src="images/sw03.png" height="450" width="700"><p>
 	<font size=7 color="blue"  face="comic Sans MS"><b>입력 진행중 Waiting...Loading...</b></font>
  </div>
</body>
</html>