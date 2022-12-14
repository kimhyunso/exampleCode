<%@ page language="java" contentType="text/html; charset=UTF-8"   %>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ include file="ssi.jsp" %>
<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no"/>
   <meta name="description" content="html5">
   <meta name="author" content="author">
   <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

<title> [aaa.jsp]</title>
   <style type="text/css">
	  *{font-size:20pt; font-weight:bold;  font-family: Comic Sans MS ; margin-left: 10px; }
	  a{font-size:20pt; text-decoration:none; font-weight:bold; color:blue;  font-family: Comic Sans MS ; }
	  a:hover{font-size:24pt; text-decoration:underline; color:green;  font-family: Comic Sans MS ; }
   </style>
</head>
<body>

<%
	String path=application.getRealPath("storage");
	
	System.out.print("경로 : "+path);
	int size = 1024*1024*7;
	//MultipartRequest mi=new MultipartRequest(1 request ,2 path ,3 size ,4 UTF-8);	
	DefaultFileRenamePolicy dfr=new DefaultFileRenamePolicy();
	MultipartRequest mi=new MultipartRequest(request ,path ,size ,"UTF-8",dfr);
	
	String name="kim";
	String title="title";
	int sabun=5050;
	
	String a=mi.getParameter("hide");
	String b=mi.getParameter("title");
	String c=mi.getFilesystemName("file");
	
	out.print("히든 : "+a+" 제목 : "+b+" 파일 : "+c);
	
	sql="insert into bod values ( ? ,bod_seq.nextval, ? , ? , ? )";
	ps=con.prepareStatement(sql);
	
	ps.setString(1, c);
	ps.setString(2, name);
	ps.setString(3, title);
	ps.setInt(4,sabun);
	ps.executeUpdate();
	
%>

	<a href="aaa.jsp">찾아보기</a>

	<hr>
	<a href="bbbdownload.jsp?fname=<%=c%>"><img alt="" src="<%=request.getContextPath()%>/storage/<%=c%>" width="250" height="200"></a>
	<a href="bbbdownload.jsp?fname=<%=c%>"><img alt="" src="./storage/<%=c%>" width="250" height="200"></a>
	<a href="bbbdownload.jsp?fname=<%=c%>"><img alt="" src="./storage/<%=c%>" width="250" height="200"></a>
</body>
</html>