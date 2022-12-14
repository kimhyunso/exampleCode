<%@ page language="java" contentType="text/html; charset=UTF-8"   %>
<%@ page import="java.util.Date" %>
<%@ page import="java.lang.*" %>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>

<head>
<title>[ssi.jsp]</title>
</head>

<body>
<%!
 	int count;
	int rownum;
	int sabun;
	String name;
	String title;
	Date nalja;
	int pay;
 	int Gtotal , Stotal=27;
	
	///////////////////////////
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String id="system";
	String pw="oracle";
	///////////////////////////
	
	Connection con=null;
	Statement st=null;
	ResultSet rs=null;
	PreparedStatement ps=null;
	String sql;
	
%>
<%
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection(url,id,pw);
		st=con.createStatement();
	}catch(Exception e){
		System.out.print("연결실패");
	}
%>	
</body>
</html>
