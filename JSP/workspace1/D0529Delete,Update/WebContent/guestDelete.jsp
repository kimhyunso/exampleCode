<%@ page language="java" contentType="text/html; charset=UTF-8"   %>
<%@ include file="ssi.jsp" %>
<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no"/>
   <meta name="description" content="html5">
   <meta name="author" content="author">
   <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title> [index.jsp]</title>
  <script type="text/javascript">
    window.setTimeout("location.href='guestList.jsp'",3000);
  </script>
</head>
<body>
<%
	st=con.createStatement();
	sabun=Integer.parseInt(request.getParameter("idx")); 
	name=(String)request.getParameter("Guser");
	sql="delete from guest where sabun = " +sabun;
	st.executeUpdate(sql);
%>


  <div align="center" style="margin-top:50px;" >
 	<img src="images/sw03.png" height="450" width="700"><p>
 	<font size=7 color="blue"  face="comic Sans MS"><b> <%=name%> 삭제진행중 Waiting...Loading...</b></font>
  </div>
</body>
</html>