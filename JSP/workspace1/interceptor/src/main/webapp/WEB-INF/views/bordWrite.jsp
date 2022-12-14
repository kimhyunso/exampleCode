<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[boardWrite.jsp]</title>
  <style type="text/css">
    *{font-size: 20pt; font-weight: bold; }
    a{font-size: 20pt; font-weight: bold;  text-decoration:none; color:blue ;}
    a:hover{font-size: 24pt; font-weight: bold;   text-decoration:underline; color:green ;  }
  </style>
  
</head>
<body>
   <!-- boardWrite.jsp -->
   <font color=blue>[boardWrite.jsp]</font> <br>

  <form method="post" enctype="multipart/form-data"  action="insert.do">
      이름: <input type="text" name="name" value="choi"> <br>
      제목: <input type="text" name="title" value="test"> <br>
      내용: <textarea rows="3" cols="20"  name="content"></textarea> <br>
      성별:
      <input type="radio" name="gender" value="man" checked>남자 
      <input type="radio" name="gender" value="woman">여자 <br>
      취미:
      <input type="checkbox" name="hobby" value="game">게임
      <input type="checkbox" name="hobby" value="study">공부
      <input type="checkbox" name="hobby" value="ski">스키
      <input type="checkbox" name="hobby" value="movie" checked>영화 <br>
      
      파일: <input type="file" name="upload_f"><p>
      <input type="submit" value="myBatis데이터저장">
      <input type="reset" value="입력취소">
  </form>  
  
  <p>
  <a href="index.jsp">[myBatis작업index.jsp]</a>
  <a href="write.do">[write.do]</a>
  <a href="list.do">[list.do]</a> 
  <a href="login.do">[login.do]</a>
</body>
</html>














