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
<script type="text/javascript">

	function click() {
		flag=false;
		var data=myform.isabun.value;
		if(data==null){
			alert("아이디 입력란이 공백입니다.");
			myform.isabun.value.focus();
		}
		open("open.jsp");
		
	}

</script>
</head>
<body>

<div class="insert">
	<form action="guestWriteShow.jsp" method="get">
		신규사번 : <input type="text" maxlength="4" name="isabun"> <br>
		<input type="button" maxlength="4" value="아이디중복" onclick="click();"> <br>
		신규이름 : <input type="text" name="iname"> <br>
		신규제목 : <input type="text" name="ititle"> <br>
		신규급여 : <input type="text" maxlength="3" name="ipay"> <br>
		<input type="submit" value="저장"> <input type="reset" value="취소">
	</form>
</div>
</body>
</html>