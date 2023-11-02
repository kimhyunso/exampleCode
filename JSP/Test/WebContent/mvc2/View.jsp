<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function deleteAlter(message, idx, ridx){
		var result = confirm(message);
		
		if(result == 1){
			location.href="../mvc2/passReply.do?idx="+idx+"&ridx="+ridx+"&mode=1";
		}else{
			return;
		}
		
	}
	function validateForm(form){
		if(form.content.value == ""){
			alert("내용을 입력하세요");
			form.content.focus();
			return false;
		}
	}
	
</script>
</head>
<body>
	<table border="1" width="90%">
		<colgroup>
			<col width="15%"/><col width="35%"/>
			<col width="15%"/><col width="*"/>
		</colgroup>
		
		<tr>
			<td>번호</td><td>${dto.idx }</td>
			<td>작성자</td><td>${dto.nick }</td>
		</tr>
		<tr>
			<td>작성일</td><td>${dto.postdate }</td>
			<td>조회수</td><td>${dto.visitcount }</td>
		</tr>
		<tr>
			<td>제목</td><td colspan="3">${dto.title }</td>
		</tr>
		<tr>
			<td>내용</td><td colspan="3" height="100">${dto.content }</td>
		</tr>
		
		<tr>
			<td>
				<c:if test="${not empty dto.ofile }">
					${dto.ofile }
					<a href="../mvc2/download.do?ofile=${dto.ofile }&sfile=${dto.sfile}&idx=${dto.idx}">[다운로드]</a>
				</c:if>
			</td>
			<td>다운로드 수</td>
			<td colspan="2">${dto.downcount }</td>
		</tr>
		
		<tr>
			<td colspan="4" align="center">
				<button type="button" onclick="location.href='../mvc2/pass.do?mode=edit&idx=${param.idx}';">
					수정하기
				</button>
				<button type="button" onclick="location.href='../mvc2/pass.do?mode=delete&idx=${param.idx}';">
					삭제하기
				</button>
				<button type="button" onclick="location.href='../mvc2/list.do';">
					목록 바로가기
				</button>
			</td>
		</tr>
	</table>
	
	
	
	<form action="../mvc2/replyWrite.do" method="get" onsubmit="return validateForm(this);">
		<input type="hidden" value="${dto.idx }" name="idx">
		<table>
			<tr>
				<td>댓글 : <textarea name="content" style="width:100%;height:100px;"></textarea><br>
					<button type="submit">등록하기</button>
				</td>
			</tr>
			<tr>
			</tr>
		</table>
	</form>
	
	<c:if test="${not empty replyLists}">
		<c:forEach items="${ replyLists}" var="list" varStatus="loop">
			${list.nick}
			${list.content}
			<c:if test="${list.id eq sessionScope.id}">
				<button type="button" onclick="location.href='../mvc2/passReply.do?idx=${dto.idx }&mode=0&ridx=${list.ridx }'">수정하기</button>
				<button type="button" onclick="deleteAlter('삭제하시겠습니까?',${dto.idx},${list.ridx });">삭제하기</button>
			</c:if>
			<br>
		</c:forEach>
	</c:if>	
	

</body>
</html>