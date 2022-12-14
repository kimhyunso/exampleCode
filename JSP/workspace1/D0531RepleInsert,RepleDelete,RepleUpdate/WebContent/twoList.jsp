<%@ page language="java" contentType="text/html; charset=UTF-8"   %>
<%@ include file="ssi.jsp" %>

<!DOCTYPE html>
<html> <head>
<title> [twoList.jsp]</title>
   <style type="text/css">
	  *{font-size:18pt; font-weight:bold;  font-family: Comic Sans MS ; }
	  a{font-size:18pt; text-decoration:none; font-weight:bold; color:blue;  font-family: Comic Sans MS ; }
	  a:hover{font-size:20pt; text-decoration:underline; color:green;  font-family: Comic Sans MS ; }
	  select,input{font-size:14pt; font-weight:bold;  font-family: Comic Sans MS ; }
	  #search{font-size:14pt; font-weight:bold;  font-family: Comic Sans MS ; }
   </style>
   
   <script type="text/javascript">
   	 function changeclear() {
	  	
	 }//end
   </script>
</head>
<body>

<!-- twoList.jsp 복사본 -->
<%!
   String pnum;
  int pageNUM, pagecount; 
  int start, end; //[7선택일때]  start=21, end=30
  int startpage, endpage; // [21startpage] ~~ [30endpage]
  int temp;  //임시변수 시작페이지구하기 1, 11, 21, 31 
  int Rnum;  //행번호 거꾸로 표시 나중에 
  
  //검색할때
  String sqry; 
  String skey, sval ;  // 검색필드, 검색어
  String returnpage ;  // 검색해서 페이지번호클릭할때사용 
%> 
  
<%
 	skey=request.getParameter("keyfield"); //선택한 필드명
 	sval=request.getParameter("keyword"); //입력한 검색조건값 
 	//returnpage=request.getParameter("ind");
 	if(skey==null || sval==null){
 		skey="title"; sval="";
 	}
 	
 
  	st=con.createStatement();
  	sql="select count(*) as cnt from guest where "+skey+" like "+"'%"+sval+"%'";
  	
  	rs=st.executeQuery(sql);
  	rs.next(); Gtotal=rs.getInt("cnt");  //전체총갯수

%> 
 <table border="1" width="1200"  cellspacing="0">
  <tr align="right">
    <td colspan="6"> 레코드갯수:<%=Gtotal%> &nbsp; </td>
  </tr>
 
  <tr bgcolor=yellow>
    <td>행번호</td>  <td>사 번</td> <td>이 름</td> 
    <td>제 목</td>   <td>날 짜</td> <td>급 여</td> 
  </tr>
  
<%

  	pnum=request.getParameter("ind"); //문자7
 	if(pnum==null || pnum.equals("")) pnum="1";  //필수항목 
 	pageNUM=Integer.parseInt(pnum.trim());
 	start=(pageNUM*10)-9;
 	end=pageNUM*10;
 	
 	temp=(pageNUM-1)%10;
  	startpage=pageNUM-temp;		
  	endpage=startpage+9;
	
 	if(Gtotal%10==0){
 		pagecount=Gtotal/10;
 	}else{
 		pagecount=(Gtotal/10)+1;
 	}
 	
 	if(endpage>pagecount){
 		endpage=pagecount;
 	}
 	
 	String a=" select * from ( ";
 	String b=" select rownum rn , g.* from ";
 	String c=" ( select *from guest where "+skey+" like '%"+sval+"%' ) g";
 	String d=" ) where rn between "+start+" and "+end;

 	sql=a+b+c+d;
 
 	st=con.createStatement();
 	rs=st.executeQuery(sql);
 	
 	while(rs.next()==true){
	 	sabun=rs.getInt("sabun");
	 	title=rs.getString("title");
%>
  
  <tr>
    <td><%=rs.getInt("rn")%></td> 
    <td> <%=sabun%></td> 
    <td> <%=rs.getString("name")%> </td> 
    <td>  <%=title%> </td> 
    <td> <%=rs.getDate("nalja") %> </td>
    <td> <%=rs.getInt("pay") %> </td>
 </tr>
 
 
 <% 
 	 }  
 %>
 
 <tr align="center">
  <td colspan="6">
  	<%
  	  //[이전] startpage번호 1 11 21 31
  	  if(startpage>10){
    	 out.print("<a href='twoList.jsp?ind= "+(startpage-10)+ "'>[이전]</a>");
     }
  	  
  	  //페이징번호[1]~~[10]
  	  for(int i=startpage; i<=endpage; i++){
  	  	out.print("<a href='twoList.jsp?ind="+i+" &keyfield="+ skey + " &keyword="+ sval +"' >["+i+"]</a>");
  	  }
  	
  	 
     //[다음] endpage번호 10 20 30 40
     if(endpage<pagecount){
    	 out.print("<a href='twoList.jsp?ind= "+(startpage+10)+" &keyfield="+ skey + " &keyword="+ sval +"'>[다음]</a>");
     }
     
  	%> 
  </td>
 </tr>
  <tr align="center">
   <td colspan="6"> 
       <form name="myform" action="twoList.jsp">
        <span id='search'>검색 :</span>
        <select name="keyfield">
        	<option value="">-선택하세요-</option>
        	<option value="">전체검색</option>
        	<option value="name" >이름검색</option>
        	<option value="title">제목검색</option>
        	<option value="">내용검색</option>
        </select>
        <input type="text" name="keyword"  size=10>
        <input type="submit" value="검 색 ">   
        <input type="button" value="index" onclick="location.href='index.jsp'">
        <input type="button" value="two출력"   onclick="location.href='twoList.jsp'">    
       </form>
   </td>
  </tr>
 </table> 	
</body>
</html>



