<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"   %>
<%@ include file="ssi.jsp" %>

<!DOCTYPE html>
<html> <head>
<title> [guestListCo.jsp]</title>
   <style type="text/css">
	  *{font-size:20pt; font-weight:bold;  font-family: Comic Sans MS ; margin-left: 10px; }
	  a{font-size:20pt; text-decoration:none; font-weight:bold; color:blue;  font-family: Comic Sans MS ; }
	  a:hover{font-size:24pt; text-decoration:underline; color:green;  font-family: Comic Sans MS ; }
	  .page a{text-decoration:none; color:#606060;}
	  .page a:hover {text-decoration:underline; color:#007070;}
   </style>

 <script type="text/javascript">
    function notice(){
      open("popup.jsp", "ab", "width=650,height=500,left=300,top=300");
    }
 </script>
 
</head>
<body>
 <font color=blue>[guestList.jsp]</font><p>  
 <%!
 	String pnum;
 	int start=1 , end=10;
 	int pageMUM, pagecount;
 	int startpage=1 , endpage=10;
 	int temp;
 	int Rnum;
 	int total;
 	
 	String sqry;
 	String skey, sval;
 	String returnpage;
 	
 %>
 
 
 <table border="1" width="900"  cellspacing="0">
 
  <tr bgcolor=yellow>
    <td>번호</td>  <td>사 번</td> <td>이 름</td> 
    <td>제 목</td>   <td>날 짜</td> <td>급 여</td> 
  </tr>
  
<%
	st=con.createStatement();
	sql="select count(*) as cnt from guest";
	rs=st.executeQuery(sql);
	
	if(rs.next()){
		total=rs.getInt("cnt");
		System.out.print(total);
	}
	
	
	st=con.createStatement();
	if(request.getParameter("gnum")!=null){
		pnum=request.getParameter("gnum");
		pageMUM= Integer.parseInt(request.getParameter("gnum"));
		start=(pageMUM*10)-9; end=pageMUM*10;
	}
	
	pagecount=total/10;
	temp=total%10;
	System.out.print(pagecount);
	
	
	if(request.getParameter("nextu")!=null){
		/*startpage=endpage+1;
		endpage=startpage+9;
		start=(pageMUM*10)-9; end=pageMUM*10;*/
		temp=(pageMUM-1)%10;
		startpage=endpage-temp;
		endpage=startpage+9;
	}

	/*String a="select *from ";
	String b="(select rownum rn , g.*from guest g)";
	String z=" ";
	String c="where rn between "+start+" and "+end;*/
	
	
 	sql="select *from ";
 	sql+="(select rownum rn ,g.*from guest g)where rn between "+start+" and "+end;
 	/*sql=a;
 	sql+=b;
 	sql+=c;*/
 	
 	rs=st.executeQuery(sql); //조회한결과를 RS가 통째전체기억
 	while(rs.next()){
	 	sabun=rs.getInt("sabun");
	 	title=rs.getString("title");
%>
  <tr>
    <td> <%= rs.getInt("rn") %> </td> 
    <td> <%=sabun%> </td> 
    <td> <%= rs.getString("name") %> </td> 
    <td> <a href="guestDetail.jsp?idx=<%=sabun%>"> <%=title%> </a> </td> 
    <td> <%= rs.getDate("nalja") %> </td>
    <td> <%= rs.getInt("pay") %>
 </tr>
<% } %>

</table>
<div class="page">
<%
	for(int i=startpage; i<=endpage; i++){
		if(startpage>pagecount){
			out.print("<a href='guestListCo.jsp?nextu='"+startpage+10+"'"+"> next </a>");		
		}	
		
%>
	<a href="guestListCo.jsp?gnum=<%=i%>"><%=i%></a>
<%
		if(endpage>pagecount){
			out.print("<a href='guestListCo.jsp?nextu='"+startpage+10+"'"+"> next </a>");		
		}
	
	}
%>	
</div>
  <p>
  <a href="guestListCo.jsp">[전체출력]</a>  
  <a href="#">[로그인]</a>
  <a href="guestWrite.jsp?idx=<%=sabun%>">[입력화면]</a>
</body>
</html>



