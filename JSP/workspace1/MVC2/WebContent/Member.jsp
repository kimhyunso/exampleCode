<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/mycss/Member.css" type="text/css" rel="stylesheet">
<title>Insert title here</title>
<link href="css/bootstrap.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="js/myjs/Member.js">
</script>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<form name="form" id="form" method="post">
<div align="center" id="member">
	<table>
		<tr>
			<td>ID</td>
			<td align="center">
				<input type="text" id="id" name="id" maxlength="15" onkeyup="this.value=this.value.replace(/[^a-zA-Z-_0-9]/g,'')">
			</td>
		</tr>
		
		<tr>
		<td>PW</td>
			<td align="center">
				<input type="password" id="pw" name="pw" maxlength="15" onkeyup="this.value=this.value.replace(/[^a-zA-Z-_0-9]/g,'')">
			</td>
		</tr>
		
		<tr>
		<td>NickName</td>
			<td align="center">
			   <input type="text" id="nick" name="nick" maxlength="10">
			</td>
		</tr>
		
		<tr>
		<td>Email</td>
			<td align="center">
			  <input type="text" id="email" name="email" pattern="^[a-zA-Z0-9]+@[a-zA-Z0-9]+$" onkeyup="this.value=this.value.replace(/[^a-zA-Z-_0-9-_\@]/g,'')" title="ex)abc@co.kr">
			</td>
		</tr>	
		
		<tr>
		<td>Location</td>
			<td align="center">
			 <input type="button" onClick="goPopup();" value="검색"/>
			</td>
		</tr>
		
		<tr>
		<td>주소</td>
		<td align="center"> 
			 <input type="text"  id="roadAddrPart1"  name="roadAddrPart1" />
		</td>
		</tr>
		
		<tr>
		<td>상세주소 </td>
			<td align="center">
			<input type="text" id="addrDetail"  name="addrDetail"/>
			</td>
		</tr>
		
		<tr>
			<td>Job</td>
			<td align="center">
			<select name="job" id="job">
				<option id="Student">Student</option>
				<option id="Programer">Programer</option>
				<option id="Populer">Populer</option>
				<option id="CEO">CEO</option>
			</select>
			</td>
		</tr>
		
		<tr>
			<td></td>
			<td align="right">
			<input type="button" value="회원가입" onclick="regclick();" id="reg">
			</td>
		</tr>
	</table>
</div>
</form>
<p>
<div align="center" id="footer">
	<jsp:include page="Footer.jsp"></jsp:include>
</div>

</body>
</html>