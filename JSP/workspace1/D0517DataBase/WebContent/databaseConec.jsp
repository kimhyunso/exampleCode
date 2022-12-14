<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	String url="jdbc:mysql://localhost:3306/mydb";
	String id="root";
	String pass="1017";
	Connection con=null;
	try{
		con= DriverManager.getConnection(url+"?serverTimezone=UTC&verifyServerCertificate=false"
				+ "&useSSL=false&allowPublicKeyRetrieval=true",id,pass);
		out.print("연결 성공");
	}catch(Exception e){
		e.getStackTrace();		
	}finally{
		try{
			con.close();
		}catch(Exception e){
			
		}
	}
%>
<%

%>

</body>
</html>