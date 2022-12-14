function myclick() {
	if(confirm("정말 로그아웃하시겠습니까?")){
		location.href="ControllLogin.do";
	}else{
		return false;
	}
}
function clicklist() {
	alert('로그인을 해주세요!');
	setTimeout(function(){location.href="Login.jsp"},1000);
}
