function mysubmit() {
	var reply = document.getElementById("replycontent").value;
	if(reply==null || reply==""){
		alert("내용을 입력해주세요.");
		document.getElementById("replycontent").focus();
		return false;
	}
	return true;
}
