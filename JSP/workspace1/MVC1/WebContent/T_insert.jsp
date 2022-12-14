<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Writer</title>
<link href="css/insert.css" type="style/css" rel="stylesheet"> 
<script type="text/javascript">
	function click() {
	}
</script>
</head>
<body>
<%
	
%>
<div align="center" id="body">
<form action="" method="post" enctype="multipart/form-data">
	제목 : <input type="text" name="title"><p>
	<textarea rows="5" cols="100" name="content"></textarea><br>
	<input type="submit" value="저장"><input type="reset" value="취소">
</form>
</div>
</body>
</html>