<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<%@ include file="ssi.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/table.css" rel="stylesheet" type="text/css" media="all"/>
<style type="text/css">
	img{width:70px; height:70px;}

</style>
</head>
<body>
<%!	
	String path;


%>
	<table>
	<tr id="header" align="center" bgcolor=lightgray>
		<td>번호</td>
		<td>글쓴이</td>
		<td>제목</td>
		<td>그림</td>
		<td>비고</td>
	</tr>
<%	
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy:MM:dd");
	st=con.createStatement();
	sql="select *from (select rownum rn,b.*from bod b) where rn between 1 and 10";
	rs=st.executeQuery(sql);
	while(rs.next()){
		path=rs.getString("path");
%>
	<tr id="content" align="center">
		<td><%=rs.getString("rn")%></td>
		<td><a href="#"><%=rs.getString("name")%></a></td>
		<td><%=rs.getString("title")%></td>
		<td><%out.print("<img src='./storage/"+path+"'>");%></td>
		<td><%out.print("<a href='#'>[삭제]</a> <a href='#'>[수정]</a>");%></td>
	</tr>
<%
	}
%>	
	</table>
<%
	for(int i=1; i<=10; i++){
		out.print("<a href='#'> ["+i+"] </a>");
	}
%>
</body>
</html>