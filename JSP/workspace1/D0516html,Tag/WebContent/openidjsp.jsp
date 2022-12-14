<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--<%@include file="./ssi.jsp" %>-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
	  *{font-size:14pt; font-weight:bold;  font-family: Comic Sans MS ; margin-left: 10px; }
	  a{font-size:14pt; text-decoration:none; font-weight:bold; color:blue;  font-family: Comic Sans MS ; }
	  a:hover{font-size:16pt; text-decoration:underline; color:green;  font-family: Comic Sans MS ; }
</style>
<script type="text/javascript">
	
</script>
</head>
<body bgcolor="yellow">
	<jsp:useBean id="uesr" class="com.itbank.net.userID"/>
	<!--<jsp:getProperty property="pw" name="test"/>-->
	<%
		String id=request.getParameter("index");
	%>
	<img alt="" src="images/bar.gif" width=400><br>
	<form >
		userid : <input type="text" value=<%=id%>>
		<input type="submit" value="중복처리">
	</form>
	<img alt="" src="images/bar.gif" width=400><br>
	
	
</body>
</html>