<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ include file="ssi.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> [guest_reply_insert.jsp]</title>
  <style type="text/css">
    *{font-size:20pt; font-weight:bold;  font-family:  Segoe UI Symbol , comic Sans MS ;  }
    a{font-size:20pt; font-weight:bold; color:blue; text-decoration:none; }
    a:hover{font-size:26pt; font-weight:bold; color:green; text-decoration:underline; }
    #rsave{
      font-size:26pt; font-weight:bold; 
      background: #00FF00; height:150px;
    }                
  </style>
 </head>
<body>

<%
	int sa= Integer.parseInt(request.getParameter("Gidx"));
	int nu= Integer.parseInt(request.getParameter("Gnum"));
	sql="delete from guestreply where num = "+nu;
	st=con.createStatement();
	st.executeUpdate(sql);
	response.sendRedirect("guestDetail.jsp?Gidx="+sa);
%>

</body>
</html>












