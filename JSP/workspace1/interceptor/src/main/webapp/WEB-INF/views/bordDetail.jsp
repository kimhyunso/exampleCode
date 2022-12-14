<%@page import="org.springframework.context.annotation.Import"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="ssi.jsp" %>

<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<head>
<title> [guestDetail.jsp]</title>
 <style>
	* { font-size:20pt; font-weight:bold; font-family:Comic Sans MS; }
	a { font-size:24pt; text-decoration:none; font-weight:bold; color:blue; }
	a:hover { font-size:30pt; text-decoration:underline; font-weight:bold; color:green; }
 </style>
</head>
<body>
 <c:set value="${dto}" var="dto"></c:set>
 
  <table width=1000  border=1 cellspacing=0>	
	  <tr>
	    <td rowspan=7 align=center> 
	    	<a href="download.do"><img alt="" src="${pageContext.request.contextPath}/resources/upload/${dto.getImg_file_name()}" width="100" height="70"></a>
		</td>
		<td width=350> idx : ${dto.getHobby_idx()}  </td>
	  </tr>
	  
	  <tr> <td> ${dto.getName()}</td>  </tr>
	  <tr> <td> ${dto.getTitle()}</td>  </tr>
	  <tr> <td>${dto.getContent()}</td>  </tr>
	  <tr> <td>${dto.getGender()}</td>  </tr>
	  <tr> <td>${dto.getHobby()}</td>  </tr>
	
	  <tr>
		<td colspan="2" align="center"><a href="delete.do?idx=${dto.getHobby_idx()}">[삭제]</a> <a href="update.do">[수정]</a></td>
	  </tr>
   </table> 
<br>


</body>
</html>