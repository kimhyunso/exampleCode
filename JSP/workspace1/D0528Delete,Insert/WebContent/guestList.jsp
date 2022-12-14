<%@ page language="java" contentType="text/html; charset=UTF-8"   %>
<%@ include file="ssi.jsp" %>

<!DOCTYPE html>
<html> <head>
<title> [guestList.jsp]</title>
   <style type="text/css">
	  *{font-size:20pt; font-weight:bold;  font-family: Comic Sans MS ; margin-left: 10px; }
	  a{font-size:20pt; text-decoration:none; font-weight:bold; color:blue;  font-family: Comic Sans MS ; }
	  a:hover{font-size:24pt; text-decoration:underline; color:green;  font-family: Comic Sans MS ; }
   </style>

 <script type="text/javascript">
    function notice(){
      open("popup.jsp", "ab", "width=650,height=500,left=300,top=300");
    }
 </script>
</head>
<body>
 <font color=blue>[guestList.jsp]</font><p>  
<%
  ST=CN.createStatement();
  msg="select count(*) as cnt from guest ";
  ST=CN.createStatement();
  RS=ST.executeQuery(msg);
  if( RS.next()==true ){ //한건일때는 RS.next(); 기술가능
   Gtotal=RS.getInt("cnt");
  }
%> 
 <table border="1" width="900"  cellspacing="0">
  <tr align="right">
    <td colspan="6"> 레코드갯수: <%= Gtotal %> &nbsp; </td>
  </tr>
 
  <tr bgcolor=yellow>
    <td>행번호</td>  <td>사 번</td> <td>이 름</td> 
    <td>제 목</td>   <td>날 짜</td> <td>급 여</td> 
  </tr>
  
<%
 ST=CN.createStatement();
 //msg=" select rownum,sabun,name,title,nalja from guest  " ;
 msg="select rownum, g.* from guest  g " ;
 RS=ST.executeQuery(msg); //조회한결과를 RS가 통째전체기억
 while(RS.next()==true){
	 Gsabun=RS.getInt("sabun");
	 Gtitle=RS.getString("title");
%>
  <tr>
    <td> <%= RS.getInt("rownum") %> </td> 
    <td> <%= RS.getInt("sabun") %> </td> 
    <td> <%= RS.getString("name") %> </td> 
    <td> <a href="guestDetail.jsp?idx=<%=Gsabun%>"> <%=Gtitle%> </a> </td> 
    <td> <%= RS.getDate("nalja") %> </td>
    <td> <%= RS.getInt("pay") %>
 </tr>
 <% } %>
 </table> 	
  
  <p>
  <a href="guestList.jsp">[전체출력]</a>  
  <a href="index.jsp">[index]</a>
  <a href="#">[로그인]</a>
  <a href="guestWrite.jsp">[입력화면]</a>
</body>
</html>



