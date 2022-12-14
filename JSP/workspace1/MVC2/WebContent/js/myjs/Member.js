function goPopup(){
	// 주소검색을 수행할 팝업 페이지를 호출합니다.
	// 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(http://www.juso.go.kr/addrlink/addrLinkUrl.do)를 호출하게 됩니다.
	var pop = window.open("jusoPopup.jsp","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
	
	// 모바일 웹인 경우, 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(http://www.juso.go.kr/addrlink/addrMobileLinkUrl.do)를 호출하게 됩니다.
    //var pop = window.open("/popup/jusoPopup.jsp","pop","scrollbars=yes, resizable=yes"); 
}


function jusoCallBack(roadAddrPart1){
		// 팝업페이지에서 주소입력한 정보를 받아서, 현 페이지에 정보를 등록합니다.
		document.form.roadAddrPart1.value = roadAddrPart1;
}

function regclick() {
	var id = document.getElementById("id").value;
	var pw = document.getElementById("pw").value;
	var nick = document.getElementById("nick").value;
	var email = document.getElementById("email").value;
	var roadAddrPart1=document.getElementById("roadAddrPart1").value;
	var job=document.getElementById("job").value;
	var addrDetail=document.getElementById("addrDetail").value;
	
	if(id=="" || id==null){
		document.getElementById("id").focus();
		alert("아이디를 입력해주세요");
		return false;
	}else
	if(pw=="" || pw==null){
		document.getElementById("pw").focus();
		alert("비밀번호를 입력해주세요");
		return false;
	}else
	if(nick=="" || nick==null){
		document.getElementById("nick").focus();
		alert("닉네임을 입력해주세요");
		return false;
	}else
	if(email=="" || email==null){
		document.getElementById("email").focus();
		alert("이메일을 입력해주세요");
		return false;
	}else
	if(addrDetail=="" || addrDetail==null){
		document.getElementById("addrDetail").focus();
		alert("상세주소를 입력해주세요");
		return false;
	}
	location.href="ControllMember.do?id="+id+"&pw="+pw+"&nick="+nick+"&email="+email+"&job="+job+"&roadAddrPart1="+roadAddrPart1+"&addrDetail="+addrDetail;
}