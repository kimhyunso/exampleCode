<%@page import="java.io.OutputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="com.oreilly.servlet.MultipartRequest" %>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>



<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="ssi.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	location.href="test.jsp";
</script>
</head>
<body>
<%
	String path=application.getRealPath("storage");

	int size = 1024*1024*7;
	DefaultFileRenamePolicy dfr=new DefaultFileRenamePolicy();
	MultipartRequest mi=new MultipartRequest(request ,path ,size ,"UTF-8",dfr);
	
	int sa=Integer.parseInt(mi.getParameter("hide"));
	String file=mi.getFilesystemName("file");
	String name=mi.getParameter("name");
	String title=mi.getParameter("title");

	sql="update bod set name = ? , title = ? , path = ? where sabun = "+sa;
	ps=con.prepareStatement(sql);
	ps.setString(1,name);
	ps.setString(2, title);
	ps.setString(3, file);
	ps.executeUpdate();
%>

</body>
</html>