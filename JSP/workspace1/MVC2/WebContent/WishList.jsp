<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="IncludeCore.jsp" %>

<html>
<head>
<title>Insert title here</title>
<link href="css/mycss/List.css" rel="stylesheet" type="text/css">
</head>
<body>
<c:set value="${dto}" var="dto"></c:set>
<c:set value="${list}" var="list" ></c:set>
<c:set value="${num}" var="num"></c:set>
<jsp:include page="Header.jsp"></jsp:include>

<div align="center" id="listdiv">
<c:choose>
	<c:when test="${list=='[]'}">
	리스트에 아무것도 없습니다....
	</c:when>
	<c:otherwise>
		<c:forEach items="${list}" var="list">
		<table id="listtable">
			<tr>
				<td colspan="3" id="listimg" align="center"><img src="images/${list.getImg()}" id="listimg"></td>
				<td align="center" id="listcontent"><a href="ControllBordDetail.do?num=${list.getNum()}">${list.getTitle()}<br>${list.getContent()}<br>${list.getCount()} 개<br>${list.getOp()}</a></td>
				<td align="center"><a href="ControllWishList_Delete.do?kind=${list.getKind()}" id="delete">[X]</a></td>
			</tr>
		<tr></tr>
		</table>
		</c:forEach>
		
		<div align="center" id="wishlistnum">
		<c:forEach begin="${dto.getPagestart()}" end="${dto.getPageend()}" var="i">
			<a href="ControllWishList.do?linum=${i}&skey=&sval=">[${i}]</a>
		</c:forEach>
		</div>
		
	</c:otherwise>
</c:choose>
</div>
</body>
</html>