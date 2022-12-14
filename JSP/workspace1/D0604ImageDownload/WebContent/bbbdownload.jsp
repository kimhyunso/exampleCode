<%@page import="java.io.FileInputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"   %>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page import="java.io.File" %>
<%@ page import="java.io.InputStream" %>
<%@ page import="java.io.OutputStream" %>
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
bbb.jsp
	<img src="images/bbb.gif">
 	<img src="images/bbb.gif"><p>

<%
	String path=application.getRealPath("./storage");
	String data=request.getParameter("fname");
	File file=new File(path,data);
	//response.setHeader(name, value);
	response.setHeader("Content-Disposition", "attachment;filename="+data);
	try{
		InputStream in=new FileInputStream(file);
		OutputStream os=response.getOutputStream();
		byte[] bt=new byte[(int)file.length()];
		in.read(bt,0,bt.length);
		os.write(bt);
		
		in.close(); os.close();
	}catch(Exception ex){
		
	}
%>

</body>
</html>