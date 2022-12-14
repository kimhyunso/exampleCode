<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="ssi.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title>main</title>
<style type="text/css">
	#container{position:relative;}
	#content{position:absolute; margin-left:100px; margin-top:50px;}
	#header{margin-left: 1000px;}
	#header a{color:black; text-decoration:none;}
	#header a:hover{color:silver; text-decoration:underline;}
	#sidemenu{position:absolute; float:right; margin-left:800px; width:500px; margin-top:50px;}
	#sidemenu table{background-color:#D5D5D5; }
	#sidemenu table td:nth-child(1){width: 100%;}
	#sidemenu table a{text-decoration:none; color:#000000;}
	#sidemenu table a:hover{text-decoration:underline; color:#6799FF;}
	#content table{width:700px; background-color: #FFFFFF; height:500px;}
	#footer{margin-top: 650px;}
	#Pfooter{margin-left:200px;}
	#header td{font-weight: bold; text-decoration: none; padding:10px;}
	#Pcontent a{text-decoration: none; color:#000000;}
	#Pcontent a:hover{text-decoration: underline; color:#707070}
	#Pfooter a{text-decoration: none; color:#000000;}
	#Pfooter a:hover{text-decoration: underline; color:#707070}
	#Pwriter{margin-left:440px;}
	#Pserch{margin-left:150px;}
</style>
</head>
<body bgcolor="#E4E4E4">
<% 
	String id = (String)session.getAttribute("ID");
	String pw = (String)session.getAttribute("PW");

%>
<div id="header">
	<a href="main.jsp" id="home">Home</a> | <% if(id!=null||pw!=null){out.print("<a href='Logout_session.jsp' id='login'>Logout</a>");}else{out.print("<a href='Login.jsp' id='login'>Login</a>");}%></a>
</div>
<div id="container">

	<div id="content">
<%!
	int pagestart , pageend;
	int start , end;
	int total;
	int pagecount;
	String pagenum;
	int pageNUM;
	int temp;
	String cate;
	int catern;
	
	String skey , sval;
	
%>
<%
	sql="select count(*) as cnt from guest where "+skey+" like '%"+sval+"%'";
	st=con.createStatement();
	rs=st.executeQuery(sql);
	rs.next();
	total=rs.getInt("cnt");
	
%>

	<table>
<%	
	pagenum=request.getParameter("Gnum");
	if(pagenum==null)pagenum="1";
	pageNUM=Integer.parseInt(pagenum);
	
	start=(pageNUM-1)*10+1 ;
	end=(pageNUM*10);
	
	 if(total%10==0){ pagecount=total/10;}
	  else{pagecount=(total/10)+1; }
	
	temp=(pageNUM-1)%10;
	pagestart=pageNUM-temp;		
	pageend=pagestart+9;
	
	if(pageend>pagecount){
		pageend=pagecount;
	}
	
	
	cate=request.getParameter("ca");
	if(cate==null)cate="java";
	if(skey==null || sval==null){
		skey="title"; sval="";
	}
	
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy:MM:dd");
	Calendar c=Calendar.getInstance();
	
	String b[]=sdf.format(c.getTime()).split(":");
	int year=Integer.parseInt(b[0]);
	int month=Integer.parseInt(b[1]);
	int day=Integer.parseInt(b[2]);
	
	
	st=con.createStatement();
	sql="select *from (select rownum rn, b.*from (select *from board where "+skey+" like '%"+sval+"%') b where cate = '"+cate+"' ) where rn between "+start+" and "+end;
	rs=st.executeQuery(sql);
	
	while(rs.next()){
		rs.getInt("num");
		String a[]=sdf.format(rs.getDate("ul_time")).split(":");
		int dbyear=Integer.parseInt(a[0]);
		int dbmonth=Integer.parseInt(a[1]);
		int dbday=Integer.parseInt(a[2]);
		
		int t=year-dbyear;
		int z=month-dbmonth;
		int v=day-dbday;
		
		int tem=t+z+v;
%>
	<tr id="Pcontent">
		<td><%=rs.getString("title")%><br><a href="#"><%=rs.getString("content")%></a><br><%=tem+"일 전"%></td>
		<td align="left"><%=rs.getString("img")%></td>
	</tr>
<%
	}
%>	
	</table>
	
	
	
<div id="Pfooter">
<%
	for(int i=pagestart; i<=pageend; i++){
		out.print("<a href='main.jsp?Gnum="+i+"' id='number'> ["+i+"] </a>");
	}
%>


<div id="Pwriter">
	<form action="T_insert.jsp" method="get">
		<input type="submit" value="글쓰기">
	</form>
</div>
</div>
<p>

<div id="Pserch">
<form action="" method="get">
	<select>
		<optgroup label="">
			<option>제목검색</option>
			<option>작성자검색</option>
			<option>제목+작성자검색</option>
		</optgroup>
	</select>
	<input type="text" name="serch"> <input type="button" value="검색">
</form>
</div>
	</div>
	<div id="sidemenu">
		<nav>
			<table>
			<tr>
				<td>
				<a href="main.jsp">전체글</a><br>
				<a href="main.jsp?ga=<%="java"%>">→Java</a><br>
				<a href="main.jsp?ga=<%="html"%>">→Html </a><br>
				<a href="main.jsp?ga=<%="jsp"%>">→Jsp</a><br>
				<a href="main.jsp?ga=<%="css"%>">→Css </a><br>
				<a href="main.jsp?ga=<%="javascipt"%>">→JavaScipt</a><br>
				<a href="main.jsp?ga=<%="database"%>">→Database</a><br>
				</td>
			</tr>
			</table>
		</nav>
	</div>
</div>
<div id="footer">
	<address>copyright all right reseved.</address>
</div>
</body>
</html>