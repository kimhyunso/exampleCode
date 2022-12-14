<%@ page language="java" contentType="text/html; charset=UTF-8"   %>
<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no"/>
   <meta name="description" content="html5">
   <meta name="author" content="author">
   <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title> [main.jsp]</title>
    <style type="text/css">
      .mas{ margin-top: 70px; }
    </style>
</head>
<body> 	
 <%
  	String msg="";
 	Cookie[] cookie=request.getCookies();
 	for(int i=0; i<cookie.length; i++){
 		String co=cookie[i].getName();
 		if(co.equals("gogle")){
 			msg=cookie[i].getValue();
 		}
 	}
 %>
 	<div align="center">
 	  <img src="images/gguri.png"> <p>
 	  <font size=7 color="blue"  face="comic Sans MS">
 	   <b> <%=msg %> 접속을 환영합니다 </b>
 	  </font>
 	</div>
</body>
</html>