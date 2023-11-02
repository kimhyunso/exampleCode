<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	int age = Integer.parseInt(request.getParameter("age"));
	age = age + 1;
%>    

<!DOCTYPE html>
<html>
<head>
 <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>정보 확인</title>

    <!-- Bootstrap -->
    <link href="./css/bootstrap.min.css" rel="stylesheet">
    <link href="./css/custom2.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>

<div class="container">
	<header>
		<h2>사용자 입력값 확인</h2>
	</header>
	
	<p>
		이름 : <%=request.getParameter("name")%><br>
		비번 : <%=request.getParameter("pass")%><br>
		나이 : <%=age %><br>
		정보 : <%=request.getParameter("type") %><br>
		내용 : <%=request.getParameter("memo") %><br>
	</p>
		
</div>


<script src="./js/bootstrap.min.js"></script>
	
</body>
</html>