<%@page import="java.util.Collection"%>
<%@page import="java.util.stream.Stream"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	long add_date = sdf.parse(request.getParameter("add_date")).getTime();
	int add_int = Integer.parseInt(request.getParameter("add_int"));
	String add_str = request.getParameter("add_str");
	
	response.addDateHeader("myBirthday",add_date);
	response.addIntHeader("myNumber",add_int);
	response.addIntHeader("myNumber",1004);
	response.addHeader("myName", add_str);
	response.setHeader("myName","안중근");
	
	
	
	
	
%>


<h2>응답 헤더 출력하기</h2>
<%
	
	//response.getHeaderNames().stream().forEach(hName -> out.print(response.getHeader(hName)));
	Collection<String> headerNames = response.getHeaderNames();
	for(String hName : headerNames){
		String hValue = response.getHeader(hName);
			
%>
	<li><%=hName %> : <%=hValue %></li>
<%
	}

%>

<h2>myNumber만 출력하기</h2>
<%
	Collection<String> myNumber = response.getHeaders("myNumber");
	for(String myNum : myNumber){
%>

	<li><%=myNum%></li>
<%
	}
%>



</body>
</html>