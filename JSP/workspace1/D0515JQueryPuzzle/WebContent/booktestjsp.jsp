<%@ page language="java" contentType="text/html; charset=UTF-8"   %>
<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no"/>
   <meta name="description" content="html5">
   <meta name="author" content="author">
   <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

<title> [bookC.jsp]</title>
	<link href="css/skitter.styles.css" type="text/css" media="all" rel="stylesheet" />
	<script src="js/jquery-1.7.2.min.js"></script>
	<script src="js/jquery.skitter.min.js"></script>
	<script src="js/jquery.easing.1.3.js"></script>
	<script src="js/jquery.animate-colors-min.js"></script>

   <style type="text/css">
	  *{font-size:16pt; font-weight:bold;  font-family: Comic Sans MS ; margin-left: 10px; }
	  a{font-size:16pt; text-decoration:none; font-weight:bold; color:blue;  font-family: Comic Sans MS ; }
	  a:hover{font-size:20pt; text-decoration:underline; color:green;  font-family: Comic Sans MS ; }
	  
	  .thumbnail img{
	  	width:170px; height:100px; 
	  }
	  
	  .thumbnail img:hover{
	  	width:180px; height:110px; 
	  }
	     
	  .view img{
	     width: 580px ;
	     height: 320px;
	  }
   </style>
   
<script type="text/javascript">
  $(function(){
	  var path="images/hydran.png";
   	$(".box_skitter_small").one("mouseover",function(){ 
   		$('.box_skitter_small').skitter({dots: true, preview: true});
   	});
   	
 	$(".box_skitter_small").mouseleave("mouseover",function(){ 
 		$(".box_skitter_small").attr({src:path,alt:'그림무'})
   	});
  });
</script>
</head>
<body>
	bookC.jsp <p>
 	 <div class="box_skitter box_skitter_small">
 	 	<ul>
        <li>
           <a href="#"><img src="images/sw06.png" class="random"  /></a>
            <div class="label_text">
            </div>
        </li>
        <li>
           <a href="#"><img src="images/hydran.png" class="random"   /></a>
            <div class="label_text">
            </div>
        </li>
        <li>
           <a href="#"><img src="images/jang05.png" class="random"   /></a>
            <div class="label_text">
            </div>
        </li>
        <li>
           <a href="#"><img src="images/tulips.png" class="random"  /></a>
            <div class="label_text">
            </div>
        </li>
        <li>
           <a href="#"><img src="images/sw04.png" class="random"  /></a>

            <div class="label_text">
            </div>
        <li>
           <a href="#"><img src="images/sw02.png" class="random"  /></a>

            <div class="label_text">
            </div>
        </li>
    </ul>
 	</div>
 	

 	<!--<div class="thumbnail">
 	  <a href="#" style="margin-left:15px;"> <img src="images/1.jpg"> </a>
 	  <a href="#" style="margin-left:0px;">  <img src="images/2.jpg"> </a>
 	  <a href="#" style="margin-left:0px;">  <img src="images/3.jpg"> </a>
 	</div>-->
 
</body>
</html>


