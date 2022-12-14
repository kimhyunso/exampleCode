<%@ page language="java" contentType="text/html; charset=UTF-8"   %>
<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no"/>
   <meta name="description" content="html5">
   <meta name="author" content="author">
   <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

<title> [test_image.jsp]</title>
   <style type="text/css">
	  *{font-size:20pt; font-weight:bold;  font-family: Comic Sans MS ; margin-left: 10px; }
	  a{font-size:20pt; text-decoration:none; font-weight:bold; color:blue;  font-family: Comic Sans MS ; }
	  a:hover{font-size:24pt; text-decoration:underline; color:green;  font-family: Comic Sans MS ; }
   </style>
   
   <script type="text/javascript">
     var sunsu = new Array(); //자바스크립트 
     var bc=new Array("images/a2.png", "images/a3.png", "images/a4.png" ); //전역배열
     
     function start(){
       for( i=0; i<3;i++){
         sunsu[i]=Math.floor(Math.random()*3);
         for(j=0; j<i; j++){ 
        	if(sunsu[i]==sunsu[j]) i--;
       	 }
       }//i end  
       for(i=0; i<3;i++){ 
   	      document.images[i].src=bc[sunsu[i]];
   	      //document.write("<img src="+bc[sunsu[i]] +">");
    	  //document.images[i].src=bc[sunsu[i]];
        }
     }//start end
     
    
   </script>
</head>
<body>
	<input type=button onClick="start()" value=" 그림보기 " /> <p>
	<script type="text/javascript">
   	   var imgsource=new Array("images/a2.png", "images/a3.png", "images/a4.png" );
   	   for(var i=0; i<3;i++){
   		 document.write("<img src="+ imgsource[i]+">");
   	   }
 	</script>
    <p><hr>

</body>
</html>


