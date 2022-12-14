<%@page import="java.sql.Date"%>
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
</head>
<body>
<%
  st=con.createStatement();
  int data=Integer.parseInt(request.getParameter("Gidx"));
  
  sql="select * from guest where sabun = " + data ;
  rs=st.executeQuery(sql);
  if(rs.next()){
  	sabun=rs.getInt("sabun");
  	name=rs.getString("name");
  	title=rs.getString("title");
  	nalja=rs.getDate("nalja");
  	pay=rs.getInt("pay");
  }
  st=con.createStatement();
  sql="update guest set position=position+1 where sabun= "+sabun;
  st.executeUpdate(sql);
%>
  
  <table width=900  border=1 cellspacing=0  cellpadding=10>	
	  <tr>
	    <td rowspan=5 align=center> 
		   <img class="my"  src="images/crayonpop.png"  width=350 height=250>
		</td>
		<td width=350> 사번:<%=sabun%> </td>
	  </tr>

	  <tr> <td> 이름:<%=name%> </td> </tr>
	  <tr> <td> 제목:<%=title%> </td>  </tr>
	  <tr> <td> 날짜:<%=nalja%> </td>  </tr>
	  <tr> <td> 급여:<%=pay%> </td>  </tr>
	  
	  <tr align="center">
	  	<td colspan="2">
	  	   <a href="guestList2.jsp">[전체출력]</a>  
  			<a href="#">[로그인]</a>
  			<a href="guestUpdate.jsp?uidx=<%=sabun%>">[수정]</a>
  			<a href="guestDelete.jsp?idx=<%=sabun%>&Guser=<%=name%>">[삭제]</a>
	  	</td>
	  </tr>
   </table> 
   <p>
  
  
</body>
</html>