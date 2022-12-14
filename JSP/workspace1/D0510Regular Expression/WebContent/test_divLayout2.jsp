<%@ page language="java" contentType="text/html; charset=UTF-8"   %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> [test_divLayout2.jsp]</title>
   <style type="text/css">
	  *{font-size:16pt; font-weight:bold;  font-family: Comic Sans MS ; }
	  a{font-size:16pt; text-decoration:underline; font-weight:bold; color:blue;  font-family: Comic Sans MS ; }
	  a:hover{font-size:24pt; text-decoration:none; color:green;  font-family: Comic Sans MS ; }
	  .my{width:170px; height:150px; border-radius:150px; overflow:hidden;  }
	 
   </style>
</head>
<body>
   <!-- test_divLayout2.jsp -->
  <div id="container" style="width:1000px">   
	  	<div id="header" style=" width:100%; height:70px; text-align:center; float:right; background-color:#FFA500;" >
	  	  <font color> Div Layout Web Server Page</font> 
	  	</div>
	  	
	  	<div id="menu"  style="width:200px; float:left;height:400px; ">
	       <p> <img alt="home" class="my" src="images/hydran.png"><p>
	  	   <font color=red>
	  	     <a href="#">Info</a> <br>
	  	  	 <a href="#">main</a> <br>
	  	  	 <a href="#">Login</a> <br>
	  	  	 <a href="#">board</a> <br>
	  	  	 <a href="#">Guest</a> <br>
	  	  	 <a href="#">Mypage</a> <br>
	  	  </font>
	  	</div>
	  	
	  	<div id="center" style="width:800px; float:left;height:300px; text-align:center; " >
	  	   <p>&nbsp;<p>&nbsp;<p>&nbsp;
	  	   Div Center  Example View Here
	  	</div>
	  	
	  	<div id="footer" style="font-size:12pt; height:70px;clear:both;text-align:center; background-color:#FFA500;">
	  	  <p style="text-align:center;" ><br>
	  	    Copyright 2019 W3C ⓒ KG Bank 1303호 
	  	  </p>
	  	</div>
  </div>  
 	
</body>
</html>