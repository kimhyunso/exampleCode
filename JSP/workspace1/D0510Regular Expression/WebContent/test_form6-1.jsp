<%@ page language="java" contentType="text/html; charset=UTF-8"   %>
<!DOCTYPE html>
<html>
<head>
  
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="html5">
  <meta name="author" content="kim young">
  
<title> [test_form5.jsp]</title>
   <style type="text/css">
      * {
         font-size: 14pt; 
         font-weight: bold; 
         font-family: Comic Sans MS ; 
        }
      #title_ch , #email_ch{
      	margin-left: 60px;
      }
	  .input_group{
	     height: 50px;
	     border-bottom: 1px dotted #AACC;  
	   }
   </style>
   
   
 <script type="text/javascript">
 	function check(){
 	  var a=myform.title.value;
 	  
 	  if(a==""){
 		  document.getElementById("title_ch").innerHTML="<font style='font-size:13px; color:red;'>제목데이터를 입력하세요</font>";
 		  myform.title.focus(); 
 	  }else{
 		  myform.title.focus(); 
 		  document.getElementById("title_ch").innerHTML="";
 		  return false;
 	  }
 	  
 	 emailcheck(); 	  
 	}//end
 	
 	function emailcheck() {
 		 var b=myform.email.value;
 		  if(b=="" || b==null){
 	 		  document.getElementById("email_ch").innerHTML="<font style='font-size:13px; color:red;'>제목데이터를 입력하세요</font>";
 			  myform.email.focus(); 
 			  return false;
 		  }else{
 			  var mail_rege=/^([a-zA-Z0-9_\.]{3,16})@([a-zA-Z0-9_\.]{3,16})\.([a-zA-Z]{2,6})$/;
 			  if(mail_rege.test(b)==false){
 				  document.getElementById("email_ch").innerHTML="<font style='font-size:13px; color:red;'>잘못입력하셧습니다./font>";
 				  myform.email.value="";
 				  myform.email.focus();
 				  
 			  }else{
 				  document.getElementById("email_ch").innerHTML="";
 				  return false;
 			  }
 			  //return false;
 		  }
	}
 	
 	function test() {
		
	}
 	
 </script>
 
</head>

<body>

<div style="width:800px">
  <form name="myform" method="get" action="">
    <fieldset>
    	<legend>Membmer Register</legend>
    	사번 : <input type="text" name="sabun" value="9700" size=10 >
    		<input type="button" value="ID중복"><p>
    	이름 : <input type="text" name="name" value="gildong"><br>
    		<span id="title_ch"></span><br>
    	제목 : <input type="text" name="title"><br>
    		<span id="email_ch"></span><br>
    	메일 : <input type="text" name="email" id="email" onblur="emailcheck();"><br>
    	
    	우편 : <input type="text" name="cord" id="code" size=9>
    		<input type="button" value="우편번호" onclick=""><br>
    	주소 : <input type="text" name="adress" id="adress"><br>
    	상세 : <input type="text" name="deteil" id="deteil"><br>
    	파일 : <input type="file" name="file"><p>
    	
    	<div class="input_group">
    		<label> &nbsp;&nbsp;&nbsp; </label>
    		<input type="button" onclick="check();" value="버튼저장" >
    		<input type="reset" value="입력취소" >
    	</div>
    </fieldset>
  </form>
 </div>
  
</body>
</html>






