<%@page import="java.util.ArrayList"%>
<%@page import="com.sun.xml.internal.ws.api.pipe.NextAction"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>[database]</title>
<style type="text/css">
.number{margin-left:200px; font-weight: bold;}
.number a{text-decoration:none; color:#000000;}
.number a:hover {text-decoration: underline; color:#060606;}
</style>
</head>
<body>
<%!
	Connection con=null;
	Statement st=null;
	ResultSet rs=null;
	int pagefrist=1;
	int pagelast=10;

	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String id="system";
	String pw="oracle";
	int sabun;
	String name;
	String title;
	Date nalja =new Date();
	int pay;
	int rownum;
%>

<%
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection(url,id,pw);
		st=con.createStatement();
	}catch(Exception e){
		e.getStackTrace();
	}
%>
<%!
ArrayList<Integer> list;
public ArrayList pagec(){
	String count="select count(*) as c from guest";
	try{
	rs=st.executeQuery(count);
	rs.next();
	int pag=rs.getInt("c");
	int a=pag/10;
	list=new ArrayList<Integer>();
	
	for(int i=1; i<=a; i++){
		list.add(i);
	}
	return list;
	}catch(Exception e){
	
	}
	return null;
}

%>

<table border="1" width=900 cellspaceing=0>
<tr background="yellow">
<td>번호</td><td>사번</td><td>이름</td><td>제목</td><td>날짜</td><td>급여</td>
</tr>
<tr>
<%
	try{
		String msg="select *from (select rownum rn,g.*from guest g) where rn between "+pagefrist+" and "+pagelast;
		rs=st.executeQuery(msg);
	}catch(Exception e){
	
	}
 while(rs.next()){
	 rownum=rs.getInt("rn");
	 sabun=rs.getInt("sabun");
	 name=rs.getString("name");
	 title=rs.getString("title");
	 nalja=rs.getDate("nalja");
	 pay=rs.getInt("pay");
%>
	<td><%=rownum%></td>
	<td><%=sabun%></td>
	<td><%=name%> </td>
	<td><%=title%> </td>
	<td><%=nalja%></td>
	<td><%=pay%></td>
</tr>
<%
 }
%>
</table>
<div class="number">
<%
 	for(int i=pagefrist; i<=pagelast; i++){
%>
	<a href="database.jsp?idx=<%=i%>"><%=i%></a>
<%
 	}
%>
</div>

</body>
</html>