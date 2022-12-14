<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="IncludeCore.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<link href="css/mycss/List.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
 	$(function () {
		$("#checkall").click(function () {
			$("input[type=checkbox]").prop("checked",true);
		});
		
		$("#check").click(function () {
			$("input[type=checkbox]").prop("checked",false);
		});
		
	});
</script>
</head>
<body>
<c:set value="${dto}" var="dto"></c:set>
<c:set value="${list}" var="list" ></c:set>
<c:set value="${num}" var="num"></c:set>
<jsp:include page="Header.jsp"></jsp:include>

<div align="center" id="listdiv">
<c:choose>
	<c:when test="${list=='[]'}">
	장바구니가 비어있습니다....
	</c:when>
	<c:otherwise>
		<div align="left" id="chois">
			<a href="#" id="checkall">전체선택</a> <a href="#" id="check">전체해제</a>
		</div>
		<c:forEach items="${list}" var="list">
		<div align="left" id="checkbox">
			<input type="checkbox" id="check${list.count}">
		</div>
		<table id="listtable">
			<tr>
				<td colspan="3" align="center"><img src="images/${list.getImg()}" id="listimg"></td>
				<td align="center" id="listcontent"><a href="ControllBordDetail.do?num=${list.getNum()}">${list.getTitle()}<br>${list.getContent()}<br>${list.getCount()} 개<br>${list.getOption()}</a></td>
				<td align="center"><a href="ControllList_Delete.do?kind=${list.getKind()}" id="delete">[X]</a></td>
			</tr>
		</table>
		<p>
		</c:forEach>
		<div align="center">
		<c:forEach begin="${dto.getPagestart()}" end="${dto.getPageend()}" var="i">
			<a href="ControllList.do?linum=${i}&skey=&sval="><img alt="" src="images/number/${i}.jpg" id="pagelistnum"></a>
		</c:forEach>
		</div>
	</c:otherwise>
</c:choose>
</div>
</body>
</html>