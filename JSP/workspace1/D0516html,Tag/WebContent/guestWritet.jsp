<%@ page language="java" contentType="text/html; charset=UTF-8"   %>
<%@ include file="ssi.jsp" %>

<!DOCTYPE html>
<html>
<head>
<title> [guestWrite.jsp]</title>
</head>
<script type="text/javascript">
	function pop() {
		open("openidjsp.jsp?index=sky","aa","width=600,height=150,left=200,top=300");
	};

</script>
<body>
  guestWrite.jsp문서 <p>
  <form  action="openidjsp.jsp" method="post">
     아이디:<input type="text" name="name" ><input type="button" value="id중복체크" onclick="pop();"><br>
      제목:<input type="text" name="title" value="book"> <br>
      급여:<input type="text" name="pay" value="23"> <br>
      <input type="submit" value="데이터저장" > &nbsp;&nbsp;&nbsp;
      <input type="reset" value="입력취소"> 
  </form>  
   
  <p>
  <a href="guestList.jsp">[전체출력]</a>  
  <a href="index.jsp">[index]</a>
  <a href="openidjsp.jsp">[로그인]</a>
  <a href="guestWrite.jsp">[입력화면]</a>
</body>
</html>


