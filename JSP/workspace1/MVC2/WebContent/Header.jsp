<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="IncludeCore.jsp"%>
<!DOCTYPE html>
<html>
<head>
<link href="css/mycss/Header.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="js/myjs/JBord.js"></script>
<script type="text/javascript">
</script>
<title>Insert title here</title>
</head>
<body>
<%
	HttpSession hs = request.getSession();
	String user_id = (String)hs.getAttribute("user_id");
	String user_pw = (String)hs.getAttribute("user_pw");
	String nickname = (String)hs.getAttribute("nickname");
%>


<div id="header" align="right">

<nav>
	<ul>
	<li>
		<a href="ControllBord.do">[홈]</a>
		<c:choose>
			<c:when test="<%=user_id!=null||user_pw!=null%>">
				<a href="#" onclick="myclick();">[로그아웃]</a>
			</c:when>
		
			<c:otherwise>
				<a href="Login.jsp">[로그인]</a>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="<%=user_id!=null||user_pw!=null%>"><a href="ControllList.do?linum=&skey=&sval=">[장바구니]</a></c:when>
			<c:otherwise><a href="#" onclick="clicklist();">[장바구니]</a></c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="<%=user_id!=null||user_pw!=null%>"><a href="ControllWishList.do?linum=&skey=&sval=">[위시리스트]</a></c:when>
			<c:otherwise><a href="#" onclick="clicklist();">[위시리스트]</a></c:otherwise>
		</c:choose>
	</li>
	</ul>
</nav>
</div>
</body>
</html>