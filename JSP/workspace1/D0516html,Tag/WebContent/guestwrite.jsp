<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ include file="ssi.jsp"
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
	<style type="text/css">
	  *{font-size:20pt; font-weight:bold;  font-family: Comic Sans MS ; margin-left: 10px; }
	  a{font-size:20pt; text-decoration:none; font-weight:bold; color:blue;  font-family: Comic Sans MS ; }
	  a:hover{font-size:24pt; text-decoration:underline; color:green;  font-family: Comic Sans MS ; }
	</style>
</head>
<script type="text/javascript">
	$(function () {
		$("#test").bind(function () {
			
		});
	});
</script>
<body>
	
	<div id="test">
		<img src="images/tul.png">	
	</div>
	
	<form method="post" action="guestsave.jsp">
	제목 : <input value="sunday" name="title" type="text"><br>
	제목 : <input value="27" name="title" type="text"> <br>
		<input type="submit" value="저장"> &nbsp; &nbsp; &nbsp;
		<input type="reset" value="취소">
	<p>
	<img src="images/bar.gif">
	
	<a href="#">전체출력</a>
	<a href="#">index</a>
	<a href="#">로그인</a>
	
	</form>
</html>