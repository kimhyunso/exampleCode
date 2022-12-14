<%@ page language="java" contentType="text/html; charset=UTF-8"   %>
<%@ include file="ssi.jsp" %>

<!DOCTYPE html>
<html> <head>
<title> [guestList.jsp]</title>
   <style type="text/css">
	  *{font-size:20pt; font-weight:bold;  font-family: Comic Sans MS ; }
	  a{font-size:20pt; text-decoration:none; font-weight:bold; color:blue;  font-family: Comic Sans MS ; }
	  a:hover{font-size:22pt; text-decoration:underline; color:green;  font-family: Comic Sans MS ; }
   </style>
   <script type="text/javascript">
   	function Changclear() {
		
	}
   
   </script>
</head>

<body>
 <font color=blue>[guestList.jsp]</font><p> 
<%!
  String pnum;
  int pageNUM, pagecount; 
  int start, end;
  int startpage, endpage; // [11startpage] ~~ [20endpage]
  int temp;  //임시변수 시작페이지구하기 1, 11, 21, 31 
  int Rnum;  //행번호 거꾸로 표시 나중에 
  
  //검색할때
  String sqry; 
  String skey, sval ;  // 검색필드, 검색어
  String returnpage ;  // 검색해서 페이지번호클릭할때사용 
%> 

  
<%
  st=con.createStatement();
  sql="select count(*) as cnt from guest ";
  st=con.createStatement();
  rs=st.executeQuery(sql);
  if( rs.next() ){ //한건일때는 RS.next(); 기술가능
   Gtotal=rs.getInt("cnt");
  }
%> 
 <table border="1" width="1200"  cellspacing="0">
  <tr align="right">
    <td colspan="6"> 레코드갯수: <%= Gtotal %> &nbsp; </td>
  </tr>
 
  <tr bgcolor=yellow>
    <td>행번호</td>  <td>사 번</td> <td>이 름</td> 
    <td>제 목</td>   <td>날 짜</td> <td>급 여</td> 
  </tr>
  
<%
	skey=request.getParameter("keyfield");
	sval=request.getParameter("keyword");
	System.out.println("skey="+skey +"\tsval="+sval);

  pnum=request.getParameter("Gnum"); //문자7
  if(pnum==null || pnum=="")pnum="1";  //필수항목 
  pageNUM=Integer.parseInt(pnum); //숫자7변환
  start=(pageNUM-1)*10+1 ;
  end=(pageNUM*10) ; 
  System.out.println("start="+start +"\tend="+end);
  
  //데이터갯수=316 페이징갯수=32
  if(Gtotal%10==0){ pagecount=Gtotal/10;}
  else{pagecount=(Gtotal/10)+1; }
  
  
  //startpage시작페이지 temp변수이용하믄 좋아요  1, 11, 21, 31 
  //[이전][21][22]~[27클릭]~[29][30][다음]
  //temp=6 (pageNUM-1)%10 		
  //[27=pageNUM변수숫자타입]  27-6=21
  temp=(pageNUM-1)%10;
  startpage=pageNUM-temp;		
  endpage=startpage+9;
  //코드더 기술해야합니다
	if(endpage>pagecount){
		endpage=pagecount;
	}
  
  
 String a=" select * from (";
 String b=" select rownum rn, sabun,name,title,nalja,pay from guest ";
 String z=" ";
 
 String c=") where rn between " + start + " and " + end ;

 //msg="select rownum,sabun,name,title,nalja,pay from guest " ;
 st=con.createStatement();
 sql=a+b+c;
 
 //Rnum=Gtotal-(pageNUM-1)*10;
 rs=st.executeQuery(sql); 
 while(rs.next()){
	 sabun=rs.getInt("sabun");
	 title=rs.getString("title");
%>
  <tr onmouseover="this.style.backgroundColor='#00ffff'" onmouseout="this.style.backgroundColor='#ffffff'">
    <td> <%=rs.getInt("rn")%> </td> 
    <td> <%= rs.getInt("sabun") %> </td> 
    <td> <%= rs.getString("name") %> </td> 
    <td> <a href="guestDetail.jsp?Gidx=<%=sabun%>"> <%=title%> </a> </td> 
    <td> <%= rs.getDate("nalja") %> </td>
    <td> <%= rs.getInt("pay") %>
 </tr>
 <% 
  } //while end  
 %>
 
 <tr align="center">
  <td colspan="6">
  	<%
  	  //[이전] startpage번호 1 11 21 31
  	if(startpage>10){
       out.println("<a href=guestListte.jsp?Gnum="+(startpage-10)+">[이전]</a>");
     }
  	
  	  //페이징번호[1]~[10]
  	  for(int i=startpage; i<=endpage; i++){
  		  if(i==pageNUM){
			out.println("<font style='font-size:25px; color:red;'>["+i+"]</font>");  			  
  		  }else{
  		  	out.println("<a href=guestListte.jsp?Gnum="+i+">["+i+"]</a>");
  		  }
  	  }
  	
  	 //참고  startpage번호 1 11 21 31
     //[다음] endpage번호 10 20 30 40
     if(endpage<pagecount){
       out.println("<a href=guestListte.jsp?Gnum="+(startpage+10)+">[다음]</a>");
     }
  	%> 
  </td>
 </tr>
 
  <tr align="center">
  <td colspan="6">
  <form action="gusetlistte2.jsp">
  	검색 : <select name="keyfield">
  	<option>선택하세요</option>
  	<option value="">전체검색</option>
  	<option value="name">이름검색</option>
  	<option value="title">제목검색</option>
  	<option value="">내용검색</option>
  	</select>
  	<input type="text" size=10 name="keyword">
  	<input type="submit" value="검색">
  </form>
  </td>
 </tr>
 	
 	
 <tr align="center">
  <td colspan="6">
  <a href="guestList.jsp">[전체출력]</a>  
  <a href="index.jsp">[index]</a>
  <a href="#">[로그인]</a>
  <a href="guestWrite.jsp">[입력화면]</a>
  </td>
 </tr>
 </table> 	
  
</body>
</html>



