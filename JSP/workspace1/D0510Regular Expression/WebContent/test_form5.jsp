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
         font-size: 16pt; 
         font-weight: bold; 
         font-family: Comic Sans MS ; 
         margin-left:10px;
        }
      
	  .input_group{
	     height: 50px;
	     border-bottom: 1px dotted #AACC;  
	   }
   </style>
   
   
 <script type="text/javascript">
 	function move(){
 	  var dname=myform.user_name.value;
 	   if(dname=="" || dname==null){
 		   alert("유저의 이름을 입력하세요\n이름데이터 입력은 필수사항입니다");
 		   myform.user_name.focus();
 		   return false;
 	   }
 	   
 	  var pwd=myform.user_pwd.value;
	   if(pwd=="" || pwd==null){
		   alert("유저의 이름을 입력하세요\n이름데이터 입력은 필수사항입니다");
		   myform.user_name.focus();
		   return false;
	   }
	   
	   /*if(pwd.langth!=4){
		   alert("비밀번호는 4자리");
		   myform.user_name="";
		   myform.user_pwd="";
		   myform.user_name.focus();
		   return false;
	   }*/
 	  
	   var gc=myform.gender[0].checked;
 	   if(!gc  && !myform.gender[1].checked){
 		  alert("성별을 선택해주세요"); 
 		  myform.gender[0].focus();
 		  return false ;
 	   }
 	   
 	   //직업선택 selectedIndex 1번째 시작
 	   if(myform.job.selectedIndex <1 ){
 		   alert("직업을 항목을 선택하세요");
 		   myform.job.focus();
 		   return false;
 	   }
 	   
 	   
 	   if(confirm("입력한 데이터 내용이 맞습니까")){
 		   myform.submit(); //입력한 데이터가 맞는지 다시 한번 확인 -> 자동 return 데이터 사라짐
 	   }
 	   
 	}//end
 	
 	function pwdNumber(){
		//첫번째 문자열 길이 ~~~.value.langth
		//두번째 특정위치 문자 한글 체크 charAt(위치);
		//세번째 문자열 추출 subString(시작위치,끝위치) or substr(시작,끝);
		//네번째 이벤트 적용 onKeyUp 키를 눌렀다 땟을때 , onKeypress 눌렀을때
		//다섯번쨰 isNaN(숫자나 문자판별)
		
		var jumin=myform.user_jumin.value;
		if(jumin.langth>6){
		   alert("비밀번호는 6자리");
		   myform.user_name.value="";
		   myform.user_jumin.value="";
		   myform.user_name.focus();
		   return false;
	   	}
		
		var s=jumin.match("[0-9]+");
		if(!s){
			alert("숫자만 입력");
			myform.user_jumin.value="";
			return false;
		}
		
		
 	}
 	
 	function info(){
 		
 		
 	}//end
 	
 </script>
 
</head>

<body>

<div style="width:800px">
  <form name="myform" method="get" action="">
    <fieldset>
    	<legend>Membmer Register</legend>
    	<div class="input_group">
    		<label>이름:</label>
    		<input type=text name="user_name"/>
    	</div>
    	
    	<!--  <div class="input_group">
    		<label>비번:</label>
    		<input type=password name="user_pwd"/>
    	</div> -->
    	
    	<div class="input_group">
    		<label>주민:</label>
    		<input type=text name="user_jumin"/>
    	</div>
    	<div class="input_group">
    		<label>성별:</label>
    		<label> <input type="radio" name="gender" value="M"> 남자</label>
    		<label> <input type="radio" name="gender" value="W"> 여자</label>
    	</div>
    	<div class="input_group">
        	<label>직업:</label>
        	<select name="job">
        	  <option>----선택하세요----</option>
        	  <option value="dev">프로그램개발자 </option>
        	  <option value="pub">퍼블리셔 </option>
        	  <option value="DBA">DB관리자 </option>
        	</select>
    	</div>
    	
    	<div class="input_group">
    		<label>취미:</label>
    		<label> <input type="checkbox" name="hobby" value="play"> 축구</label>
    		<label> <input type="checkbox" name="hobby" value="movie"> 영화보기</label>
    		<label> <input type="checkbox" name="hobby" value="study"> 공부하기</label>
    	</div>
    	
    	<div class="input_group">
    		<label> &nbsp;&nbsp;&nbsp; </label>
    		<input type="submit" onclick="pwdNumber();" value="버튼저장" >
    		<input type="reset" value="입력취소" >
    	</div>
    </fieldset>
  </form>
 </div>
  
</body>
</html>






