<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[boardList.jsp]</title>
   <style type="text/css">
    *{font-size: 18pt; font-weight: bold; }
    a{text-decoration:none;font-size: 18pt; font-weight: bold;   color:blue ;}
    a:hover{font-size: 20pt; font-weight: bold;   text-decoration:underline; color:green ;  }
  </style>

</head>
<body>
   <font color=blue>[boardList.jsp]</font> <br>
    
  <table width=1000 border=1  cellspacing=0>
     <tr align="right">
       <td colspan="4"> 레코드갯수: ${count} &nbsp; </td>
     </tr>
     
     <tr bgcolor=yellow height="55"> 
         <td>행번호</td>  <td>이 름</td>  <td>제 목</td> <td>이미지</td>
     </tr>
      
  	<c:forEach var="dto" items="${list}">
  	  <tr>
  	    <td> ${dto.rn} </td>
  	    <td> ${dto.name} </td>
  	    <td> <a href="detail.do?idx=${dto.hobby_idx}"> ${dto.title}</a><c:if test="${dto.cnt>0}"> <font style="color:red;font-size:14pt"> [${dto.cnt}] </font> </c:if> </td>
  	    <td> <img src="${pageContext.request.contextPath}/resources/upload/${dto.img_file_name}"  width=100 height=50 border="0"> </td>
  	 </tr> 
  	</c:forEach>    
  </table>

 <p>
  <a href="index.jsp">[myBatis작업index.jsp]</a>
  <a href="write.do">[write.do]</a>
  <a href="list.do">[list.do]</a>
  <a href="login.do">[login.do]</a>
</body>
</html>




