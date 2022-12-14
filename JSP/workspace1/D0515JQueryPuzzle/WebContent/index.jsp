<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript">
	//setTimeout("location.href='index.jsp'",3000);
	$(function () {
		$(".test>a").bind("mouseover",function() {
			$(".test>a>img").css('opacity','0.5').stop().animate({opacity:1},5000);
		});
	});
</script>
</head>
<body>
<div class="test" align="center">
	<a href="#"><img src="images/tulips.png"></a>
</div>
<div align="center">
	<font><b>Wating...</b></font>
</div>
</body>
</html>