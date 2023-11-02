<%@page import="java.net.URLEncoder"%>
<%@page import="java.util.ArrayList"%>
<%@page import="fileupload.MyFileDTO"%>
<%@page import="java.util.List"%>
<%@page import="fileupload.MyFileDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/WEB-INF/FormatUtil.tld" prefix="en" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>DB에 등록된 파일 목록 보기</h2>
	<a href="FileUploadMain.jsp">파일 등록하기</a>
	<%
	MyFileDAO dao = new MyFileDAO();
	List<MyFileDTO> list = dao.myFileList();
	dao.close();
	%>
	<table border="1">
	<c:forEach items="<%=list %>" var="f">
		<tr>
			<td>${f.idx }</td>
			<td>${f.name }</td>
			<td>${f.title }</td>
			<td>${f.cate }</td>
			<td>${f.ofile }</td>
			<td>${f.sfile }</td>
			<td>${f.postdate }</td>
			<td><a href="Download.jsp?oName=${en:isEncoding(f.ofile)}&sName=${en:isEncoding(f.sfile)}">
			[다운로드]</a></td>
		</tr>
	</c:forEach>
	</table>
	
	
</body>
</html>