<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>로그인 폼</h2>
	<%
		String loginErr = request.getParameter("loginError");
		if(loginErr != null) out.print("<h2>로그인 실패</h2>");
		
	%>
	
	<form action="./ResponseLogin.jsp" method="post">
		아이디 : <input type="text" name="user_id"><br>
		패스워드 : <input type="text" name="user_pwd"><br>
		<input type="submit" value="로그인">
	</form>
	
	<form action="./ResponseHeader.jsp" method="get">
		날짜 형식 : <input type="text" name="add_date" value="2021-10-25"><br>
		숫자 형식 : <input type="text" name="add_int" value="8282"><br>
		문자 형식 : <input type="text" name="add_str" value="홍길동"><br>
		<input type="submit" value="응답 헤더 설정 & 출력">
	</form>
</body>
</html>