<%@ page language="java" contentType="text/html; charset=UTF-8"   %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> [test_divLayout.jsp]</title>
   <style type="text/css">
	  *{font-size:16pt; font-weight:bold;  font-family: Comic Sans MS;}
	  a{font-size:16pt; text-decoration:none; font-weight:bold; color:blue;  font-family: Comic Sans MS ; }
	  a:hover{font-size:20pt; text-decoration:underline; color:yellow;  font-family: Comic Sans MS ; }
	  
	  #map{width:1000px; height:150px; overflow:visible; }
   </style>
</head>
<body>
  
  <div id="container" style="width:1000px"> 
 	<div id="top" style="height:70px; float:absulate; width:100%;" >
  	   <img src="images/top.jpg"  style="height:70px;  width:100%;">
  	</div>
  	  
  	<div id="header" style="height:50px; background-color:hsl(147, 50%, 47%)" align="right">
  	 	 <a href="#">Info &nbsp;</a>
  	  	 <a href="#">main &nbsp;</a>
  	  	 <a href="#">Login &nbsp;</a>
  	  	 <a href="#">board &nbsp;</a>  &nbsp;  &nbsp; 
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
  	
  	<div id="map">
  	  <iframe src="https://www.google.com/maps/embed?pb=!1m14!1m12!1m3!1d12661.637197489812!2d127.02469297723827!3d37.49826358055874!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!5e0!3m2!1sko!2skr!4v1557380658382!5m2!1sko!2skr" width="100%" height="500" frameborder="0" style="border:0" allowfullscreen></iframe>
  	</div>
  </div>  
 	
</body>
</html>