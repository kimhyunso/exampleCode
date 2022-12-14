<%@ page language="java" contentType="text/html; charset=UTF-8"   %>
<%@ include file="./ssi.jsp" %>
<!DOCTYPE html>
<html> <head>
<title> [openIDSave.jsp]</title>
   <style type="text/css">
	  *{font-size:14pt; font-weight:bold;  font-family: Comic Sans MS ; margin-left: 10px; }
	  a{font-size:14pt; text-decoration:none; font-weight:bold; color:blue;  font-family: Comic Sans MS ; }
	  a:hover{font-size:16pt; text-decoration:underline; color:green;  font-family: Comic Sans MS ; }
   </style>
   <script type="text/javascript">
   </script>
</head>
<body bgcolor="yellow">
<%
 //openIDSave.jsp
 //사번=아이디있으면 안내창  이미 사용중입니다. 다시 입력하세요 노랑팝업창에서 재입력
 //사번=아이디없으면 사용가능안내문 , 노랑팝업창 종료
 	int ret=Integer.parseInt(request.getParameter("userid"));
	sql="select *from guest where sabun = "+ret;
 	st=con.createStatement();
 	rs=st.executeQuery(sql);
 	if(rs.next()){
 		sabun=rs.getInt("sabun");	
 	}
%>

<%
if(sabun==ret){
		ret=0;
%>
	<script type="text/javascript">
		alert("이미 사용중입니다. 다시 입력해주세요.");
		location.href="openID.jsp?Gidx="+<%=ret%>;
	</script>
<%
	}else{
 		
%>
	<script type="text/javascript">
		alert("사용가능");
		opener.myform.sabun.value=<%=ret%>;
		opener.myform.name.focus();
		window.close();
	</script>
<%
	}
%>

</body>
</html>