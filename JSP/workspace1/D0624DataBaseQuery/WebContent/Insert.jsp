<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>[Insert]</title>
</head>
<body onload="myload()">
<script type="text/javascript">
function mysubmit() {
	var sabun=document.getElementById("sabun").value;
	var name=document.getElementById("name").value;
	var title=document.getElementById("title").value;
	var pay=document.getElementById("pay").value;
	
	if(sabun=="" || sabun==null){
		document.getElementById("sp").innerHTML="<font size='2px' color='red'>*사번을 입력해주세요</font>";
		document.getElementById("sabun").focus();
		return false;
	}else
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
	var sabun=document.getElementById("sabun").value;
	var name=document.getElementById("name").value;
	var title=document.getElementById("title").value;
	var pay=document.getElementById("pay").value;
	
	if(sabun!="" || sabun!=null){
		document.getElementById("sp").innerHTML="";
	}
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
	document.getElementById("sabun").focus();
}
</script>

<div align="center">
	<form action="InsertControll.do" method="get" name="myform" onsubmit="return mysubmit()">
		사번 : <input type="text" name="sabun" id="sabun" onchange="mychanged()" onKeyup="this.value=this.value.replace(/[^0-9]/g,'')" maxlength="4"><br>
		이름 : <input type="text" name="name" id="name" onchange="mychanged()"><br>
		제목 : <input type="text" name="title" id="title" onchange="mychanged()"><br>
		급여 : <input type="text" name="pay" id="pay" onchange="mychanged()" onKeyup="this.value=this.value.replace(/[^0-9]/g,'')" maxlength="3"><p>
		<span id="sp"></span>
		<input type="submit" value="전송" id="btn">
	</form>
</div>
</body>
</html>