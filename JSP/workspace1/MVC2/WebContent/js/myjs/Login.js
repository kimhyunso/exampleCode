function mysubmit() {
	var id = document.getElementById("id").value;
	var pw = document.getElementById("pw").value;
	
	if(id==null || id==""){
		alert("아이디를 입력해주세요!");
		document.getElementById("id").focus();
		return false;
	}		
	if(pw==null || pw==""){
		alert("비밀번호를 입력해주세요!");
		document.getElementById("pw").focus();
		return false;
	}
	return true;
}

function myload() {
	document.getElementById("id").focus();
}



