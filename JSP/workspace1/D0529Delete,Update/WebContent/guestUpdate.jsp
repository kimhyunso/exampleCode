<%@ page language="java" contentType="text/html; charset=UTF-8"   %>
<%@ include file="ssi.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title> [update.jsp]</title>
<style type="text/css">
.update{font-weight:bold; margin-left:100px; margin-top:100px;}
</style>
</head>
<body>
<%	
	sabun=Integer.parseInt(request.getParameter("uidx"));
%>
<div class="update">
<form action="guestUpdateShow.jsp" method="get">
	사번 : <input type="text" name="usabun" value=<%=sabun%> maxlength="4"><br>
	이름 : <input type="text" name="uname" ><br>	
	제목 : <input type="text" name="utitle"><br>	
	급여 : <input type="text" name="upay" maxlength="3"><br>
	<input type="submit" value="전송"><input type="reset" value="취소">	
</form>	
</div>

</body>
</html>