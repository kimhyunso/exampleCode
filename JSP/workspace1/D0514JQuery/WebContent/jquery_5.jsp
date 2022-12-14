<%@ page language="java" contentType="text/html; charset=UTF-8"   %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>jQuery_5.jsp</title>
  
  	<!-- <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  	<link rel="stylesheet" href="/resources/demos/style.css">  
  	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>-->
    
  	<script src="https://code.jquery.com/jquery-1.12.4.js"></script> 
    <style type="text/css">
      
      *{font-size:20pt; font-weight:bold;  font-family: Comic Sans MS ; margin-left: 10px; }
	  a{font-size:20pt; text-decoration:none; font-weight:bold; color:blue;  font-family: Comic Sans MS ; }
	  a:hover{font-size:24pt; text-decoration:underline; color:green;  font-family: Comic Sans MS ; }
    </style>
    
 <script>
 $(function(){
	$('#asp').click(function(){
		$(this).text("asp area jQuey test");
		$(this).css("color", "blue");
		$(this).css("background-color", "lightblue");
		$(this).css("font-size", "34px");
		$(this).css("height", "120px");
		$(this).css("border", "5px solid yellow");
	});
 
   //$('#myList').children().css('border', '3px solid  orange');
   //$('#myList > li').css('border', '3px solid  red');
   //$('#myList li').css('border', '3px solid  red');  
   //$('.first').prevAll().css('border', '5px solid magenta');
   //$('.first').nextAll().css('border', '5px solid  blue');
   //$('.first').prev().css('border', '5px solid magenta');
   //$('.first').next().css('border', '5px solid  blue');
 
   //$('.second').parents().css('border', '3px solid  green');
   $('.second').parents().prev().css('border', '3px solid  green');
   //$('.first').parents().next().css('border', '3px solid  green');
   //$('.second').parents().next().css('border', '3px solid  green');
   
 });
</script>
</head>
<body>
  <div id="asp"></div>
  <p> 상관없는 p 태그 </p>
  
  <div>
  <ul id='myList'>
   	<li id='content1'>내용내용111
   		<ul type="disc">
   			<li>내용3</li>
   			<li>내용4</li>
   			<li class='first'>내용5 one기준점</li>
   			<li>내용6</li>
   			<li>내용7</li>
   		</ul>
   	</li>
   	<li id='content2'>내용내용222
   		<ol>
   			<li>내용8</li>
   			<li>내용9</li>
   			<li class='second'>내용10  two기준점</li>
   			<li>내용11</li>
   			<li>내용12</li>
   		</ol>
   	</li>
   </ul>
  </div>
</body>
</html>






