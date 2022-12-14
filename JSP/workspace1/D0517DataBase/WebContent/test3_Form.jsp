<%@ page language="java" contentType="text/html; charset=UTF-8"   %>
<!DOCTYPE html>
<html>
<head>
  
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="html5">
  <meta name="author" content="kim young">
  
<title> [test3_Form.jsp]</title>
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
 	function  move(){
		
 	}
 	
 		
 </script>
</head>

<body>
<div style="width:800px">
  <form name="myform"  action="include.jsp" onsubmit="move(); return false;">
    <fieldset>
    	<legend>test3_Form.jsp</legend>
    	
    	<div class="input_group">
    		<label>동물:</label>
    		<label> <input type="checkbox" name="animal" value="cat"> 고양이</label>
    		<label> <input type="checkbox" name="animal" value="dog"> 강아지</label>
    		<label> <input type="checkbox" name="animal" value="lion"> 사자</label>
    		<label> <input type="checkbox" name="animal" value="tiger"> 호랑이</label>
    	</div>
    	
    	<div class="input_group"> </div>
    	
    	<div class="input_group">
    		<label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  </label>
    		<input type="submit"  value="서브밋전송" >
    		<input type="reset" value="입력취소" >
    	</div>
    </fieldset>
  </form>
 </div>
  
</body>
</html>







