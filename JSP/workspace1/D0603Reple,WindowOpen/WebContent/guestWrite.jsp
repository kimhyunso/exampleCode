<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="ssi.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[guestWrite]</title>
<style type="text/css">
.insert{font-weight:bold; margin-left:100px; margin-top:100px;}
</style>
</head>
<body>

<div class="insert">
	<form action="guestWriteShow.jsp" method="get">
		사번 : <input type="text" maxlength="4" name="isabun"> <br>
		이름 : <input type="text" name="iname"> <br>
		제목 : <input type="text" name="ititle"> <br>
		급여 : <input type="text" maxlength="3" name="ipay"> <br>
		<input type="submit" value="저장"> <input type="reset" value="취소">
	</form>
</div>
</body>
</html>