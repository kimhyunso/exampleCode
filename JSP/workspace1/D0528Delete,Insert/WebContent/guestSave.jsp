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
 guestDetail.jsp단독실행금지<p>
 <%
  String data="7719";
  msg="select * from guest ";
 %>
  
  <table width=900  border=1 cellspacing=0  cellpadding=10>	
	  <tr>
	    <td rowspan=5 align=center> 
		   <img class="my"  src="images/crayonpop.png"  width=350 height=250>
		</td>
		<td width=350> 사번:1123 </td>
	  </tr>

	  <tr> <td> 이름:aaa </td> </tr>
	  <tr> <td> 제목:화요일 </td>  </tr>
	  <tr> <td> 급여:92 </td>  </tr>
	  <tr> <td> 날짜:05-28 </td>  </tr>
	  
	  <tr align="center">
	  	<td colspan="2">
	  	   <a href="guestList.jsp">[전체출력]</a>  
 		    <a href="index.jsp">[index]</a>
  			<a href="#">[로그인]</a>
  			<a href="guestWrite.jsp">[입력화면]</a>
	  	</td>
	  </tr>
   </table> 
  <hr>
  
</body>
</html>




