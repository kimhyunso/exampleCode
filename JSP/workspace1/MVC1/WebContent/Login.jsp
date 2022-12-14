<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="ssi.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title>[Login]</title>
<script type="text/javascript">
	function load() {
		document.getElementById("id").focus();
	}
	function keypress() {
		
		if(Event.keyCode==13){
			document.getElementById("pw").focus();
		}
		
	}
	function click() {
		
	}
</script>
</head>
<body onload="load();">

<%
	String id , pw;
	id = request.getParameter("id");
	pw = request.getParameter("pw");
	if(id==null||pw==null){
		id=""; pw="";
	}else{
		st=con.createStatement();

		sql="select *from login ";
		rs=st.executeQuery(sql);
		while(rs.next()){
			if(id.equals(rs.getString("user_id")) && pw.equals(rs.getString("user_pw"))){
				session.setAttribute("ID",id);
				session.setAttribute("PW", pw);
				response.sendRedirect("main.jsp");
			}else{
				break;
			}
			
		}
	}
%>



<span id="id_sp"></span> <br>
	ID : &nbsp; <input type="text" name="id" id="id" maxlength="15" placeholder="아이디" onkeydown="keypress();">
<span id="pw_sp"></span> <p>
	PW : <input type="password" name="pw" id="pw" maxlength="15" placeholder="비밀번호"><p>
<input type="submit" value="로그인" onclick="click();">
</body>
</html>