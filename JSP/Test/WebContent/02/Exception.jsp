<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	int status = response.getStatus();
	

	if(status == 404)
		out.print("<h2>404 에러가 발생하였습니다. <br> 파일 경로를 확인하여 주세요</h2");
	else if(status == 405)
		out.print("<h2>405 에러가 발생하였습니다. <br> 요청 방식(method)을 확인해주세요.</h2>");
	else if(status == 500)
		out.print("<h2>500 에러가 발생하였습니다. <br> 소스 코드에 오류가 없는지 확인해주세요.</h2>");

%>

</body>
</html>