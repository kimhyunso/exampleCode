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
  
  <script type="text/javascript">
  </script>
 </head>
<body>

<%
	int sabun= Integer.parseInt(request.getParameter("sabun"));
	String content=request.getParameter("content");
	String writer=request.getParameter("writer");
	
	sql="insert into guestreply values(guestreply_seq.nextval, ? ,? ,?)";
	
	ps=con.prepareStatement(sql);
	ps.setString(1, writer);	
	ps.setString(2, content);
	ps.setInt(3, sabun);
	
	ps.executeUpdate();
	response.sendRedirect("guestDetail.jsp?Gidx="+sabun);

%>

 </table>	
</body>
</html>












