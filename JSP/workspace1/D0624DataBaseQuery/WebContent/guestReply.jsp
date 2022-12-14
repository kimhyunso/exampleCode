<%@page import="net.itbank.com.DTOReplyGuest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>[guestReply]</title>
<script type="text/javascript">
function mysubmit(data) {
	var writer = document.getElementById("writer").value;			
	var content = document.getElementById("content").value;
	var button;
	
	if(data==null){
		if(writer=="" || writer==null){
			document.getElementById("sp").innerHTML="<font size='2px' color='red'>이름을 입력하세요</font>";
			return false;
		}else if(content=="" || content==null){
			document.getElementById("sp").innerHTML="<font size='2px' color='red'>내용을 입력하세요</font>";
			return false;
		}
	}else{
		button = document.getElementById("btn").value = "수정";
		
		return false;
	}
	
	if(button=="수정"){
		location.href="ReplyControll_Update.do";
		return true;
	}
	
	
	return true;
}
function mychanged() {
	var writer = document.getElementById("writer").value;
	var content = document.getElementById("content").value;
	if(writer!="" || writer!=null){
		document.getElementById("sp").innerHTML="";
	}
	if(content!="" || content!=null){
		document.getElementById("sp").innerHTML="";
	}
}
</script>
</head>
<body>
<%
	int sabun = Integer.parseInt(request.getParameter("sabun"));
%>
<div align="center">
<form action="ReplyControll_Insert.do" method="get" onsubmit="return mysubmit(null)">
	<table border="1">
		<tr>
			<td>이름 : </td>
			<td><input type="text" name="writer" id="writer" onchange="mychanged()"></td>
			<td rowspan="3"><input type="submit" value="전송" id="btn"><td>
		</tr>
		<tr>
			<td>내용 : </td>
			<td><textarea rows="3" cols="27" name="content" id="content" onchange="mychanged()"></textarea></td>
		</tr>
		<tr>
			<td><input type="hidden" name="sabun" value="<%=sabun%>"></td>
		</tr>
	</table>
</form>
<span id="sp"></span>
<c:forEach items="${list}" var="list">
	<table>
		<tr>
			<td>사번</td>
			<td>이름</td>
			<td>내용</td>
		</tr>
		<tr>
			<td>${list.getSabun()}</td>
			<td>${list.getWriter()}</td>
			<td>${list.getContent()}</td>
		</tr>
		<tr>
			<td><a href="#" onclick="mysubmit('flag')">수정</a> <a href="ReplyControll_Delete.do?sabun=<%=sabun%>">삭제</a></td>
		</tr>
	</table>
</c:forEach>
</div>
</body>
</html>