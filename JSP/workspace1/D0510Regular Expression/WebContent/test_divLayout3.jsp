<%@ page language="java" contentType="text/html; charset=UTF-8"   %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> [test_divLayout3.jsp]</title>
   <style type="text/css">
	  *{font-size:16pt; font-weight:bold;  font-family: Comic Sans MS ;}
	  a{font-size:16pt; text-decoration:none; font-weight:bold; color:blue;  font-family: Comic Sans MS ; }
	  a:hover{font-size:20pt; text-decoration:underline; color:yellow;  font-family: Comic Sans MS ; }
	  top{ width:100%;  }
   </style>
</head>
<body>
  
  <!-- test_divLayout3.jsp -->
  <div id="container" style="width:1000px"> 
  		<div id="top2" style="height:70px;  width:100%;" >
	  	   <img src="images/top.jpg"  style="height:70px;  width:100%;">
	  	</div>
	  	  
	  	<div id="header" style="height:50px;  background-color:hsl(147, 50%, 47%)" align="right">
	  	 	 <a href="#">Info &nbsp;</a>
	  	  	 <a href="#">main &nbsp;</a>
	  	  	 <a href="#">Login &nbsp;</a>
	  	  	 <a href="#">board &nbsp;</a>  &nbsp;  &nbsp; &nbsp; &nbsp;
	  	</div> 
	  
	  	<div id="center" style=" width:100%; height:350px;" align="center" >
	  	   <p>&nbsp;<p>&nbsp;<p>&nbsp;
	  	   Div Center  Example View Here
	  	</div>
	  	
	  	<div id="footer" style="font-size:12pt; height:50px;clear:both;text-align:center;background-color:hsl(147, 50%, 47%)">
	  	  <p style="text-align:center;" >
	  	    Copyright 2019 W3C ⓒ KG Bank 1303호 
	  	  </p>
	  	</div>
  </div>  
 	
</body>
</html>