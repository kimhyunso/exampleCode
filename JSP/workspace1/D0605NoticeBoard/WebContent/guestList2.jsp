<%@ page language="java" contentType="text/html; charset=UTF-8"   %>
<%@ include file="ssi.jsp" %>

<!DOCTYPE html>
<html> <head>
<title> [guestList.jsp]</title>
   <style type="text/css">
	  *{font-size:20pt; font-weight:bold;  font-family: Comic Sans MS ; }
	  a{font-size:20pt; text-decoration:none; font-weight:bold; color:blue;  font-family: Comic Sans MS ; }
	  a:hover{font-size:24pt; text-decoration:underline; color:green;  font-family: Comic Sans MS ; }
   		img{width:70px; height:70px;}
   </style>
   
   <script type="text/javascript">
   	 function changeclear() {
	  	document.myform.keyword.value="";
	  	document.myform.keyword.focus();
	 }//end
   </script>
</head>
<body>
 <font color=blue>[guestList.jsp]</font><p> 
<%!
  String pnum;
  int pageNUM, pagecount; 
  int start, end; //[7선택일때]  start=21, end=30
  int startpage, endpage; // [21startpage] ~~ [30endpage]
  int temp;  //임시변수 시작페이지구하기 1, 11, 21, 31 
  //int Rnum;  //행번호 거꾸로 표시 나중에 
  int position;
  
  //검색할때
  String sqry; 
 	String skey, sval ;  // 검색필드, 검색어
 	
 	String img;
 	
%> 
  
<%
 skey=request.getParameter("keyfield");
 sval=request.getParameter("keyword");
	if(skey==null || sval==null){
	 	 skey="title"; sval="";
 	 }
	st=con.createStatement();
	sqry="select count(*) as cnt from guest where "+ skey+" like '%"+ sval +"%' ";
	rs=st.executeQuery(sqry);
	if(rs.next()){
		Stotal=rs.getInt("cnt");
	}
	
	//sqry="select count(*) as cnt from guest where "+ skey+" like '%"+ sval +"%' ";
	
  st=con.createStatement();
  sql="select count(*) as cnt from guest ";
  st=con.createStatement();
  rs=st.executeQuery(sql);
  if( rs.next() ){ //한건일때는 RS.next(); 기술가능
   Stotal=rs.getInt("cnt");
  }
%> 
 <table border="1" width="1200"  cellspacing="0">
  <tr align="right">
    <td colspan="6"> 레코드갯수: <%=Stotal%> &nbsp; </td>
  </tr>
 
  <tr bgcolor=yellow>
    <td>행번호</td>  <td>사 번</td> <td>이 름</td> 
    <td>제 목</td>   <td>날 짜</td> <td>조회수</td>
  </tr>
  
<%
  pnum=request.getParameter("Gnum"); //문자7
  if(pnum==null || pnum=="")pnum="1";  //필수항목 
  pageNUM=Integer.parseInt(pnum); //숫자7변환
  start=(pageNUM-1)*10+1 ;
  end=(pageNUM*10); 
  //System.out.println("start="+start +"\tend="+end);
  
  //데이터갯수=316 페이징갯수=32
  if(Stotal%10==0){ pagecount=Stotal/10;}
  else{pagecount=(Stotal/10)+1; }
  
  //startpage시작페이지 temp변수이용하믄 좋아요  1, 11, 21, 31 
  //[이전][21][22]~[27클릭]~[29][30][다음]
  //temp=6 (pageNUM-1)%10 		
  //[27=pageNUM변수숫자타입]  27-6=21
  temp=(pageNUM-1)%10;
  startpage=pageNUM-temp;		
  endpage=startpage+9;
  
  //endpage 10 20 30 40,  pagecount=32 
  if(endpage > pagecount){ endpage=pagecount; }
  
 st=con.createStatement();
 String a=" select * from (";
 String b=" select rownum rn, g.*from (";
 String z=" select *from guest where "+ skey +" like '%"+ sval +"%' order by sabun asc )g";
 String c=") where rn between " + start + " and " + end ;

 //msg="select rownum,sabun,name,title,nalja,pay from guest " ;
 sql=a+b+z+c;
 
 //행번호 역순으로 출력
 //Rnum=Gtotal-(pageNUM-1)*10;
 
 rs=st.executeQuery(sql); 
 while(rs.next()){
	 sabun=rs.getInt("sabun");
	 title=rs.getString("title");
	position=rs.getInt("position");
	Statement ss=con.createStatement();
	String m="select *from bod ";
	ResultSet r=ss.executeQuery(m);
	r.next();
	img=r.getString("path");
	
	Statement sts=con.createStatement();
	String ms="select count(*) as cnt from guestreply where sabun= "+sabun;
	ResultSet rss=sts.executeQuery(ms);
	rss.next();
	Rcnt=rss.getInt("cnt");
	
%>
  <tr onmouseOver="this.style.backgroundColor='lightgray'" onmouseOut="this.style.backgroundColor=''">
    <td> <%=rs.getInt("rn")%> </td> 
    <td> <%=rs.getInt("sabun") %> </td> 
    <td> <%=rs.getString("name") %> </td> 
    <td> <a href="guestDetail.jsp?Gidx=<%=sabun%>"> <% out.print(title+" "+"<font style='font-size:24pt; color:red;'>["+Rcnt+"]</font>"+"<img alt='img' src='"+"./storage/"+img+"'>"); %> </a> </td> 
    <td> <%=rs.getDate("nalja") %> </td>
    <td> <%=position%> </td>
 </tr>
 <% 
  } //while end  
 %>
 <tr align="center">
  <td colspan="6">
  	<%
  	  //[이전] startpage번호 1 11 21 31
  	  if(startpage>10){
  	  	out.println("<a href=guestList.jsp?Gnum="+(startpage-10)+">[이전]</a>");
  	  }
  	
  	  //페이징번호[1]~[3선택=pageNUM]~[10]
  	  for(int i=startpage; i<=endpage; i++){
  	  	if(i==pageNUM){
  	  	 out.println("<font style='font-size:24pt; color:red;'>["+i+"]</font>");
  	  	}else{
  	  	 out.println("<a href=guestList.jsp?Gnum="+i+"&keyfield="+skey+"&keyword="+sval+">["+i+"]</a>");
  	  	}
  	  	
  	  }
  	
  	 //참고  startpage번호 1 11 21 31
     //[다음] endpage번호 10 20 30 40
     if(endpage<pagecount){
       out.println("<a href=guestList.jsp?Gnum="+(startpage+10)+"&keyfield="+skey+"&keyword="+sval+">[다음]</a>");
     }
  	%> 
  </td>
 </tr>
 
  <tr align="center">
   <td colspan="6"> 
   <form action="guestList.jsp" name="myform">
              <span id="serch">검색 :</span>
        <select name="keyfield"  onchange="changeclear();" >
        	<option value="" >-선택하세요-</option>
        	<option value="">전체검색</option>
        	<option value="name" <%if(skey.equals("name")){out.print("selected");} %>>이름검색</option>
        	<option value="title" <%if(skey.equals("title")){out.print("selected");} %>>제목검색</option>
        	<option value="">내용검색</option>
        </select>
        <input type="text" name="keyword" size=10 value="<%=sval%>">
        <input type="submit" value="검  색 ">       
       <input type="button" value="입 력" onclick="location.href='guestWrite.jsp'">
    </form>
    <form action="bbb.jsp" method="post" enctype="multipart/form-data">
    <input type="file" name="file"> <input type="submit" value="전송">
   </form>
   </td>
  </tr>
 </table>
 		<a href="login.jsp">[로그인]</a>
</body>
</html>