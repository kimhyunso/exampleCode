<%@ page language="java" contentType="text/html; charset=UTF-8"   %>
<%@ include file="ssi.jsp" %>

<!DOCTYPE html>
<html><head>
<title> [guestDeleteSave.jsp]</title>
   <script type="text/javascript">
     window.setTimeout("location.href='guestList.jsp'",5000);
   </script>
  
 <style>
	* { font-size:20pt; font-weight:bold; font-family:Comic Sans MS; }
	a { font-size:24pt; text-decoration:none; font-weight:bold; color:blue; }
	a:hover { font-size:30pt; text-decoration:underline; font-weight:bold; color:green; }
 </style>
</head>
<body>
 
<%
 //guestDeleteSave.jsp단독실행하면 실행중에 에러발생
 //사번데이터및 이름데이터 2개항목
 String a="1127" ;
 String b="smith" ;
 msg=" delete  where sabun " ;
%>
  
 <div align="center" >
 	<img src="images/tulips.png" height="350" width="500"><p>
 	 <font color="blue"  face="comic Sans MS">
 	   <b> Waiting...Loading...</b>
 	 </font>
  </div>
</body>
</html>




