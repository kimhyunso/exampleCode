<%@ page language="java" contentType="text/html; charset=UTF-8"   %>
<%@ include file="./ssi.jsp" %>
<!DOCTYPE html>
<html> <head>
<title> [loginList.jsp]</title>
   <style type="text/css">
	  *{font-size:14pt; font-weight:bold;  font-family: Comic Sans MS ; margin-left: 10px; }
	  a{font-size:14pt; text-decoration:none; font-weight:bold; color:blue;  font-family: Comic Sans MS ; }
	  a:hover{font-size:16pt; text-decoration:underline; color:green;  font-family: Comic Sans MS ; }
   </style>
</head>
<body bgcolor="yellow">
<%!
	int total;
%>

<%
  //loginList.jsp
   String a = request.getParameter("userid");
   String b = request.getParameter("pwd");
   sql="select count(*) as cnt from login where userid = ? and pwd = ?";
   ps=con.prepareStatement(sql);
   	ps.setString(1, a);
   	ps.setString(2, b);
   rs=ps.executeQuery();

 if(rs.next()){ total=rs.getInt("cnt");}
 if( total>0){	 
	//session.setAttribute("naver",a);
	//response.sendRedirect("guestList2.jsp");
	Cookie co=new Cookie("gogle",a);
	response.addCookie(co);
	response.sendRedirect("main.jsp");
 }else{
%>	 
  <script type="text/javascript">
     alert("로그인문서로 이동합니다.");
     location.href="login.jsp";
  </script>	 
<%}%>	
</body>
</html>







