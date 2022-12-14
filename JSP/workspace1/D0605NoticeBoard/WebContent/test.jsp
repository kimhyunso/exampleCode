<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="ssi.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/table.css" rel="stylesheet" type="text/css"/>
<style type="text/css">
	img{width:70px; height:70px;}
</style>
</head>
<body>
<%!	
	String path;
	int startpage , endpage;
	int start , end;
	int total;
	String pnum;
	int pageNUM;
	String skey,sval;
%>

<%
	if(skey==null || sval==null){
		skey="title"; sval="";
	}
	sql="select count(*) as cnt from bod where "+skey+" like '%"+sval+"%'";
	st=con.createStatement();
	rs=st.executeQuery(sql);
	rs.next();
	total=rs.getInt("cnt");
%>

	<table id="main">
	<tr id="header" align="center" bgcolor=lightgray>
		<td>번호</td>
		<td>글쓴이</td>
		<td>제목</td>
		<td>그림</td>
		<td>비고</td>
	</tr>
<%	

	pnum=request.getParameter("Gnum"); 
	if(pnum==null || pnum=="")pnum="1";   
	pageNUM=Integer.parseInt(pnum);
	start=(pageNUM-1)*10+1 ;
	end=(pageNUM*10);
	
	startpage=pageNUM;
	endpage=(total/10)+1;
	
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy:MM:dd");
	st=con.createStatement();
	sql="select *from (select rownum rn,b.*from bod b) where rn between "+start+" and "+end;
	rs=st.executeQuery(sql);
	while(rs.next()){
		path=rs.getString("path");
		sabun=rs.getInt("sabun");
%>
		<tr id="content" align="center">
			<td><%=rs.getString("rn")%></td>
			<td><%=rs.getString("name")%></td>
			<td><a href="testD.jsp?idx=<%=sabun%>"><%=rs.getString("title")%></a></td>
			<td><%out.print("<a href='#'><img src='./storage/"+path+"'></a>");%></td>
			<td><%out.print("<a href='testDel.jsp?idx="+sabun+"'>[삭제]</a> <a href='testupshow.jsp?idx="+sabun+"'>[수정]</a>");%></td>
		</tr>
<%
	}
%>	
	</table>
	
	
<div id="footer">
<%
	for(int i=startpage; i<=endpage; i++){
		out.print("<a href='test.jsp?Gnum="+i+"'> ["+i+"] </a>");
	}
%>
</div>


</body>
</html>