<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>[Update]</title>
<script type="text/javascript">
function mysubmit() {
	var name=document.getElementById("name").value;
	var title=document.getElementById("title").value;
	var pay=document.getElementById("pay").value;
	
	if(name=="" || name==null){
		document.getElementById("sp").innerHTML="<font size='2px' color='red'>*이름을 입력해주세요</font>";
		document.getElementById("name").focus();
		return false;
	}else
	if(title=="" || title==null){
		document.getElementById("sp").innerHTML="<font size='2px' color='red'>*제목을 입력해주세요</font>";
		document.getElementById("title").focus();
		return false;
	}else
	if(pay=="" || pay==null){
		document.getElementById("sp").innerHTML="<font size='2px' color='red'>*급여를 입력해주세요</font>";
		document.getElementById("pay").focus();
		return false;
	}
	
    return true;
}
function mychanged() {
	var name=document.getElementById("name").value;
	var title=document.getElementById("title").value;
	var pay=document.getElementById("pay").value;
	
	if(name!="" || name!=null){
		document.getElementById("sp").innerHTML="";
	}
	if(title!="" || title!=null){
		document.getElementById("sp").innerHTML="";
	}
	if(pay!="" || pay!=null){
		document.getElementById("sp").innerHTML="";
	}
}

function myload() {
	document.getElementById("name").focus();
}

</script>
</head>
<body onload="myload()">
<%
	int sabun=Integer.parseInt(request.getParameter("sabun"));
%>
<div align="center">
	<form action="UpdateControll.do" name="myform" method="get" onsubmit="return mysubmit()">
		<input type="hidden" name="sabun" value="<%=sabun%>" onchange="mychanged()"><br>
		이름 : <input type="text" name="name" id="name" onchange="mychanged()"><br>
		제목 : <input type="text" name="title" id="title" onchange="mychanged()"><br>
		급여 : <input type="text" name="pay" id="pay" onchange="mychanged()" onKeyup="this.value=this.value.replace(/[^0-9]/g,'')" maxlength="3"><br>
	<span id="sp"></span><br>
		<input type="submit" value="저장">
	</form>
</div>	
</body>
</html>