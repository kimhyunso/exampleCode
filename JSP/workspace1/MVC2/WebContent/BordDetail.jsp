<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="IncludeCore.jsp" %>
<!DOCTYPE html>
<html>
<head>
<link href="css/mycss/Detail.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="js/myjs/JDetail.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
	function myclick(num,button) {
		location.href="ControllWho.do?num="+num+"&button="+button;
	}
</script>
</head>
<body>
<c:set value="${dto}" var="dto"></c:set>
<%
	HttpSession hs=request.getSession();
	String user_id = (String)hs.getAttribute("user_id");
	String user_pw = (String)hs.getAttribute("user_pw");
	String nickname = (String)hs.getAttribute("nickname");
%>
<c:set value="${num}" var="num"></c:set>
<c:set value="${list}" var="list"></c:set>
<c:set value="${redto}" var="redto"></c:set>

<jsp:include page="Header.jsp"></jsp:include>
<div align="center">
<form action="ControllWho.do" method="get">
<table id="detail">
	<tr align="left">
		<td rowspan="4" id="img"><img alt="" src="images/${dto.getImg()}" width="300px" height="200px"></td>
		<td>${dto.getTitle()}입니다.<br><font size="2px" color="#8C8C8C" >요약설명입니다.</font></td>
	</tr>
	<tr align="left">
		<td>판매가격  <font id="font">${dto.getContent()}원</font></td>
	</tr>
	<tr>
		<td id="su">수량 <input type="text" value="1" name="count" onkeyup="this.value=this.value.replace(/[^0-9-_]/g,'')"></td>
	</tr>
	<tr>
		<td>
		옵션  
		<font id="font">
			<select name="favorite">
				<option value="none">맛</option>
				<option value="sweet">달게</option>
				<option value="sour">시게</option>
				<option value="nomal">보통</option>
			</select>
		</font>
		</td>
	</tr>
	
	<tr align="right">
		<td id="td" colspan="3">
		<input type="hidden" value="${num}" name="num">
		<input type="submit" value="구매하기" style="color:#FFFFFF" name="button">
		<input type="submit" value="장바구니" style="color:#FFFFFF" name="button">
		<input type="submit" value="위시리스트" style="color:#FFFFFF" name="button">
		</td>
	</tr>
</table>
</form>

</div>
<div align="center">
	<img alt="" src="images/${dto.getImg()}" width="400px" height="500px"><p>
	상세내용....<p>
</div>

<div align="center">
	<jsp:include page="BordReply.jsp">
		<jsp:param value="<%=user_id%>" name="user_id"/>
		<jsp:param value="<%=user_pw%>" name="user_pw"/>
		<jsp:param value="<%=nickname%>" name="nickname"/>
	</jsp:include>
</div>
</body>
</html>