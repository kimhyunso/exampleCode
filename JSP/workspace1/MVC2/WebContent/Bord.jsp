<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="IncludeCore.jsp" %>  
<!DOCTYPE html>
<html>
<head>
<title>[Bord]</title>
<link href="css/mycss/Bord.css" rel="stylesheet" type="text/css">
<link href="css/bootstrap.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="js/myjs/JBord.js"></script>
</head>
<body>

<jsp:include page="Header.jsp"></jsp:include>
<c:set value="${user_id}" var="user_id"></c:set>
<c:set value="${user_pw}" var="user_pw"></c:set>
<c:set value="${dto}" var="dto"></c:set>
<div id="content" align="center">

<table>
	<c:forEach items="${list}" var="list" varStatus="i">
		<td align="center" id="bordcontenta" ><a href="ControllBordDetail.do?num=${list.getNum()}&renum=">
		<img alt="img" src="images/${list.getImg()}"><br>${list.getTitle()}<br>${list.getContent()}원</a><p></td>
		<c:if test="${i.count%4==0}"><tr></tr></c:if>
	</c:forEach>
	
	<tr></tr><tr></tr>
	
	<tr>
	<td colspan="4" align="center" id="borda">
		<c:if test="${dto.getpNum()>1}"><a href="ControllBord.do?gnum=${dto.getpNum()-1}&sval=${dto.getSval()}">Prev</a></c:if>
		
		<c:forEach begin="${dto.getPagestart()}" end="${dto.getPageend()}" var="i">
			<a href="ControllBord.do?gnum=${i}&sval=${dto.getSval()}">[${i}]</a>
		</c:forEach>
		
		<c:if test="${dto.getPageend()!=dto.getpNum()}"><a href="ControllBord.do?gnum=${dto.getpNum()+1}&sval=${dto.getSval()}">Next</a></c:if>
	</td>
	</tr>
</table>
<p>

<form action="ControllBord.do" method="get">
	<div class="input-group mb-3">
	  		<input type="text" class="form-control" placeholder="Search..." name="sval" aria-label="Recipient's username" aria-describedby="basic-addon2">
	  	<div class="input-group-append">
	   		<button class="btn btn-outline-secondary" type="submit">Search</button>
	  	</div>
	</div>
</form>

</div>
</body>
</html>