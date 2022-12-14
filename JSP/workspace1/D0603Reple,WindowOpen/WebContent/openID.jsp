<%@ page language="java" contentType="text/html; charset=UTF-8"   %>
<%@ include file="./ssi.jsp" %>
<!DOCTYPE html>
<html> <head>
<title> [openID.jsp]</title>
   <style type="text/css">
	  *{font-size:14pt; font-weight:bold;  font-family: Comic Sans MS ; margin-left: 10px; }
	  a{font-size:14pt; text-decoration:none; font-weight:bold; color:blue;  font-family: Comic Sans MS ; }
	  a:hover{font-size:16pt; text-decoration:underline; color:green;  font-family: Comic Sans MS ; }
   </style>
</head>
<body bgcolor="yellow">
<%
 String ret=request.getParameter("Gidx");
 System.out.println("넘어온Gidx=" +   ret );
%>	
<div>
  <img src="images/bar.gif" width=400><br>
	<form method="get">
	  userid:<input type="text" name="userid" value="<%=ret%>">
	         <input type="submit" value="중복처리">
	</form>
  <img src="images/bar.gif" width=400><br>
</div>
</body>
</html>



