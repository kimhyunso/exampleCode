<%@ page language="java" contentType="text/html; charset=UTF-8"   %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> [guest_header.jsp]</title>
   <style type="text/css">
	  *{font-size:16pt; font-weight:bold;  font-family: Comic Sans MS ;}
	  a{font-size:16pt; text-decoration:none; font-weight:bold; color:blue;  font-family: Comic Sans MS ; }
	  a:hover{font-size:20pt; text-decoration:underline; color:yellow;  font-family: Comic Sans MS ; }
	  top{ width:100%;  }
   </style>
   
    <script type="text/javascript">
      function idCheck( ){
       var a=document.myform.userid.value;
       var b=document.myform.pwd.value;
  
       if(a=="sky" && b=="1234"){
    	 var msg = "<font color=red>"+a+"님의 접속 환영"+"</font>";
    	     msg += "&nbsp; <input type='button' onclick='myload();' value='로그아웃'>";
    	 document.getElementById("result").innerHTML=msg; 
       }else{
    	   kgform.userid.value="";  
    	   kgform.pwd.value="";
       }
     }//end
      
      function myload(){
    	 location.reload( );
   	     kgform.userid.focus(); //입력란속성에 autofocus  
      }//end
   </script>
</head>
<body>
  
 <!-- guest_header.jsp -->
 <div id="container" style="width:80%"> 
 		<div id="top2" style="height:70px;  width:100%;" >
  	   <img src="images/top.jpg"  style="height:70px;  width:100%;">
  	</div>
  	  
  	<div id="header" style="height:50px; background-color:hsl(147, 50%, 47%)"; align="right">
  	 	 <a href="#"> &nbsp;</a>
  	  	 <a href="guestWrite.jsp">등록화면 &nbsp;</a>
  	  	 <a href="index.jsp">index &nbsp;</a>
  	  	 <a href="guestList.jsp">게시판 &nbsp;</a>  &nbsp;  &nbsp; &nbsp; &nbsp;
  	</div> 
 
  	<div  style="font-size:8pt; height:30px; background-color:hsl(147, 60%, 55%)" align="right">
  	   <div id="result">
	  	 	<form name="kgform">
	  	 	  아이디:<input type="text" name="userid" size=6  value="blue">
	  	 	  비번:<input type="password" name="pwd"  size=6  value="1234">
	  	 	      <input type="button"  onClick="idCheck( );" value="로그인">
	  	 	 </form> 
  	 	 </div>	
  	</div> 
 	 </div> 
</body>
</html>