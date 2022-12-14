<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
 <style type="text/css">
      * {
         font-size: 16pt; 
         font-weight: bold; 
         font-family: Comic Sans MS ; 
         margin-left:10px;
        }
  </style>
  <script type="text/javascript">
  
  </script> 
</head>
<body>
<% 
	for(String s:request.getParameterValues("animal")){
		out.print("<img src='images/"+s+".png' alt="+s+"><br>");
	}
%>
</body>
</html>