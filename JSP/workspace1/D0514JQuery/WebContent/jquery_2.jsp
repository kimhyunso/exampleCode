<%@ page language="java" contentType="text/html; charset=UTF-8"   %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>jQuery_2.jsp</title>
  
  	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  	<link rel="stylesheet" href="/resources/demos/style.css">
  	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    
    <style type="text/css">
      div{ margin-top: 10px; }
      *{font-size:20pt; font-weight:bold;  font-family: Comic Sans MS ; margin-left: 10px; }
	  a{font-size:20pt; text-decoration:none; font-weight:bold; color:blue;  font-family: Comic Sans MS ; }
	  a:hover{font-size:24pt; text-decoration:underline; color:green;  font-family: Comic Sans MS ; }
    </style>
    
 <script>
 $(function(){
		$('.asp').click(function(){
			$(this).text("asp area jQuey test");
			$(this).css("color", "blue");
			$(this).css("background-color", "yellow");
			$(this).css("font-size", "34px");
			$(this).css("height", "120px");
		});

	  $('#jsp').click(function(){
		  $('#jsp').text("jsp area jQuery test");
		  $('#jsp').css({ 
			  "color" : "red" ,
			  "background-color" : "pink",
			  "font-size" : "34px" ,
			  "height" : "120px"
		  });
	  });	

	$('#php').on("click",function(){
		$('#php').text("php area jQuey test");
		$('#php').css("color", "green");
		$('#php').css("background-color", "orange");
		$('#php').css("font-size", "34px");
		$('#php').css("height", "120px");
	});	

	$('p').click(function(){ 
	  $('p').text('p tag lightblue');
	  $('p').css('background-color', 'lightblue');
	  $('p').css('color', 'blue');
	  $('p').css('font-size', '34px');
	  $('p').css('height', '120px');
   });	
	    
  });
 </script>
</head>
<body>
  <div class="asp"> asp  server page </div>
  <div id="jsp"> jsp  server page</div>
  <div id="php"> php  server page</div>
  
  <p> p tag test </p>

</body>
</html>






