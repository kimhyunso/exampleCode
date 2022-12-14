<%@ page language="java" contentType="text/html; charset=UTF-8"   %>
<%@ include file="ssi.jsp" %>

<!DOCTYPE html>
<html>
<head>
<title> [guestWrite.jsp]</title>
 <script type="text/javascript">
   var flag=false; //전역변수 
 
   function move(){ 
	 document.myform.submit(); //<input type=submit>같은역할 
   }//end
 
  function info(){
	flag=true;
	var data=myform.sabun.value;
	if(data==null || data==""){
	   alert("아이디입력 데이터  공백입니다");
	   myform.sabun.focus();
	   return false;
	}
	open("openID.jsp?Gidx="+data, "bc", "width=500,height=150,left=700,top=300");  
  }//ends
</script>

</head>
<body>
<jsp:include page="guest_header.jsp" />

  guestWrite.jsp문서 <p>
  <form name="myform" method="post" action="guestWriteSave.jsp">
      신규사번: <input type="text" name="sabun" size=10>
            <input type="button"  onclick="info();"  value="아이디중복"> <br>
      신규이름: <input type="text" name="name" > <br>
      신규제목: <input type="text" name="title"  > <br>
      신규급여: <input type="text" name="pay" value="72"> <br>
         <input type="submit"  value="서브밋PST저장" > &nbsp;&nbsp;&nbsp;
         <input type="reset" value="저장취소"> 
  </form>  
   
  <p>
  <a href="guestList.jsp">[전체출력]</a>  
  <a href="index.jsp">[index]</a>
  <a href="#">[로그인]</a>
  <a href="guestWrite.jsp">[입력화면]</a>

<jsp:include page="guest_footer.jsp" />
</body>
</html>


