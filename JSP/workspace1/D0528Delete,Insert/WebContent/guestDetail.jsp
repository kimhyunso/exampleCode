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
  //guestDetail.jsp단독실행하면 실행중에 에러발생
  int data=Integer.parseInt(request.getParameter("idx"));
  System.out.println("guestDetail.jsp문서 넘어온idx=" + data );
  msg="select * from guest where sabun = " + data ;
  ST=CN.createStatement();
  RS=ST.executeQuery(msg);
  if(RS.next()==true){
  	Gsabun=RS.getInt("sabun");
  	Gname=RS.getString("name");
  	Gtitle=RS.getString("title");
  	Gnalja=RS.getDate("nalja");
  	Gpay=RS.getInt("pay");
  }//end
 %>
  
  <table width=900  border=1 cellspacing=0  cellpadding=10>	
	  <tr>
	    <td rowspan=5 align=center> 
		   <img class="my"  src="images/crayonpop.png"  width=350 height=250>
		</td>
		<td width=350> 사번:<%=Gsabun%> </td>
	  </tr>

	  <tr> <td> 이름:<%=Gname%> </td> </tr>
	  <tr> <td> 제목:<%=Gtitle%> </td>  </tr>
	  <tr> <td> 날짜:<%=Gnalja%> </td>  </tr>
	  <tr> <td> 급여:<%=Gpay%> </td>  </tr>
	  
	  <tr align="center">
	  	<td colspan="2">
	  	   <a href="guestList.jsp">[전체출력]</a>  
 		    <a href="index.jsp">[index]</a>
  			<a href="#">[로그인]</a>
  			<a href="guestDelete.jsp?Gidx=<%=Gsabun%>&Guser=<%=Gname%>">[삭제]</a>
  			<a href="guestWrite.jsp">[입력화면]</a>
	  	</td>
	  </tr>
   </table> 
    
  <hr>

</body>
</html>




