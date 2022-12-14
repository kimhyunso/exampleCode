<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="IncludeCore.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title>[Login]</title>
<link href="css/mycss/Login.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="js/myjs/Login.js"></script>
</head>
<body onload="myload();">
<jsp:include page="Header.jsp"></jsp:include>

<div id="login" align="center">
	<form action="ControllLogin.do" onsubmit="return mysubmit();" method="post" >
		<fieldset>
		<legend>Login</legend>
			ID : &nbsp; &nbsp; <input type="text" name="id" id="id" size="16" onkeyup="this.value=this.value.replace(/[^a-zA-Z-_0-9]/g,'')"><p>
			PW : &nbsp; <input type="password" name="pw" id="pw" size="16" ><p>
			<input type="submit" value="로그인" id="btn"><p>
			
			<span id="id_sp"><a href="Member.jsp">아이디가 없으신가요?</a></span>
		</fieldset>
	</form>
</div>
</body>
</html>