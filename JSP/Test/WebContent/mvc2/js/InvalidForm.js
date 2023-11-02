/**
 * 
 */

function invalidForm(form){
	if(form.id.value == ""){
		alert("아이디를 입력하세요.");
		return false;
	}
	if(form.pass.value==""){
		alert("비밀번호를 입력하세요.");
		return false;
	}
	
	if(form.content.value == ""){
		alert("내용을 입력하세요");
		form.content.focus();
		return false;
	}
		
}