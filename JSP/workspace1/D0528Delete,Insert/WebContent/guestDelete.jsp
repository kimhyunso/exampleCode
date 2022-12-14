<%@ page language="java" contentType="text/html; charset=UTF-8"   %>
<%@ include file="ssi.jsp" %>

<!DOCTYPE html>
<html><head>
<title> [guestDetail.jsp]</title>
 <style>
	* { font-size:20pt; font-weight:bold; font-family:Comic Sans MS; }
	a { font-size:24pt; text-decoration:none; font-weight:bold; color:blue; }
	a:hover { font-size:30pt; text-decoration:underline; font-weight:bold; color:green; }
 </style>
 <script type="text/javascript">
    window.setTimeout("location.href='guestList.jsp'",3000);
  </script>
</head>
<body>
 <%
 	String name=request.getParameter("Guser");
 	String sabun=request.getParameter("Gidx");
 	msg="delete from guest where='"+name+"'";
 	ST=CN.createStatement();
 	RS=ST.executeQuery(msg);
 	//ST.executeUpdate(msg);
 %>
   <div align="center" style="margin-top:50px;" >
 	<img src="images/sw03.png" height="450" width="700"><p>
 	<font size=7 color="blue"  face="comic Sans MS"><b> <%=Gname%> 삭제진행중 Waiting...Loading...</b></font>
  </div>
</body>
</html>




