<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
	<style type="text/css">
	  *{font-size:20pt; font-weight:bold;  font-family: Comic Sans MS ; margin-left: 10px; }
	  a{font-size:20pt; text-decoration:none; font-weight:bold; color:blue;  font-family: Comic Sans MS ; }
	  a:hover{font-size:24pt; text-decoration:underline; color:green;  font-family: Comic Sans MS ; }
	</style>
</head>
<body>
	<%
		int gs=0;
		String name="";
		String title;
		int gy;
		String s[]={"aaa","bbb"};
		for(String a:s){
			out.print(a);
		}
		SimpleDateFormat sdf=new SimpleDateFormat("hh:mm:ss");
		sdf.format(new Date());
		session.setAttribute("naver", name);
		Cookie ca=new Cookie("dame",name);
	%>
	<img alt="" src="images/bar.gif">
</body>
</html>