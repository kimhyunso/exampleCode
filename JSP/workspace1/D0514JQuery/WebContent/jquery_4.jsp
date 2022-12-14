<%@ page language="java" contentType="text/html; charset=UTF-8"   %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>jQuery_4.jsp</title>
  
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
	$('#asp').click(function(){
		$(this).text("asp area jQuey test");
		$(this).css("color", "blue");
		$(this).css("background-color", "lightblue");
		$(this).css("font-size", "34px");
		$(this).css("height", "120px");
	});

    $('tr:even').css('background-color', 'lightblue');	
	    
 });
</script>
</head>
<body>
   <div id="asp">asp</div>

  <table border="1" width=900  cellspacing=0>
   <tr bgcolor=yellow>
     <td>사 번</td> <td>이 름</td> <td>제 목</td> <td> 급 여</td>
   </tr>
   <tr>
     <td>1200</td> <td>홍길동</td> <td>화요일</td> <td>79</td>
   </tr>
  
  <tr>
     <td>3400</td> <td>김고은</td> <td>도깨비</td> <td>91</td>
   </tr> 
   
   <tr>
     <td>7800</td> <td>이하늬</td> <td>열혈사제</td> <td>81</td>
   </tr>
    <tr>
     <td>8900</td> <td>apple</td> <td>걸캅스</td> <td>71</td>
   </tr>
   
   <tr>
     <td>9100</td> <td>cherry</td> <td>배심원들</td> <td>61</td>
   </tr>
   <tr>
     <td>9300</td> <td>blue</td> <td>뽀로로</td> <td>51</td>
   </tr>
   
    <tr>
     <td>9500</td> <td>orange</td> <td>마블게임</td> <td>21</td>
   </tr>
   <tr>
     <td>9700</td> <td>yellow</td> <td>수요일</td> <td>31</td>
   </tr>
  </table> 
</body>
</html>






