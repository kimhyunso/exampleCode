<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ include file="ssi.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> [guest_reply.jsp]</title>
  <style type="text/css">
    *{font-size:20pt; font-weight:bold;  font-family:  Segoe UI Symbol , comic Sans MS ;  }
    a{font-size:20pt; font-weight:bold; color:blue; text-decoration:none; }
    a:hover{font-size:26pt; font-weight:bold; color:green; text-decoration:underline; }
    #rsave{
      font-size:26pt; font-weight:bold; 
      background: #00FF00; height:150px;
    }                
  </style>
  
  <script type="text/javascript">
     var br_num;	//전역변수
	function re_edit(num, writer,content,sabun){//num,writer,content,sabun
	    br_num=num;
		reply_form.bt_save.value = "댓글수정";
		reply_form.writer.value=writer;
		reply_form.content.value=content;
	   }//end
	  
	  function re_save(sabun){
		 var writer = reply_form.writer.value;
		 var content = reply_form.content.value;
		 //alert(bt +" " + writer +" "+content);	
	 }//re_save end
	  
	function save() {
		var vt=reply_form.bt_save.value;
		var rw=reply_form.writer.value;
		var rc=reply_form.content.value;
		if(rw==null || rw==""){
			alert("댓글이 공백입니다.");
			rw.focus();
			return false;
		}
		
		if(rc==null || rc==""){
			alert("댓글이 공백입니다.");
			rc.focus();
			return false;
		}
		
		document.reply_form.submit();
	}
	 
	 
	function update() {
		var bt = reply_form.bt_save.value="댓글수정";
	}
	
	function edit(num,sabun) {
		var bt = reply_form.bt_save.value;
		var rw=reply_form.writer.value;
		var rc=reply_form.content.value;
		if(bt=="댓글수정"){
			location="guest_reply_edit.jsp?sabun="+sabun+"&con="+rc+"&wri="+rw+"&num="num;
		}
		
		document.reply_form.submit();
	}
	
  </script>
 </head>
<body>

<%
 //guest_reply.jsp문서는 단독실행 금지
   String Rdata=request.getParameter("Gidx"); 
%>

<form name="reply_form" method="get" action="guest_reply_insert.jsp">
 <table  width=900 border=1 cellspacing=0 >
   <input type="hidden" name="sabun" value="<%=Rdata%>"> 
   <tr>
	 <td> <img src="images/z1.gif">저자:<img src="images/z1.gif"> </td>
	 <td> <input type="text" name="writer" size=25 maxlength="10" ></td>
			
	  <td rowspan=2 align="center">
	   <input type="button"  onclick="edit('<%=Rnum%>','<%=sabun%>');" name="bt_save" value="댓글저장" id="rsave">
	   </td>
	</tr>
		
	<tr>
		<td><img src="images/z1.gif">내용:<img src="images/z1.gif"> </td>
		<td>
		  <textarea cols=27 rows=3 name="content"></textarea>       
		</td>
	</tr>
 </table>
</form>

 <table  width=900 border=0 cellspacing=0 >
   <tr bgcolor="pink" align="center">
     <td colspan="4">댓글 데이터 출력 </td>
   </tr>  
   <%
    st=con.createStatement();
   //sql="insert into guestreply values(guestreply_seq.nextval ,"   +Rdata+")";
   	//sql="select *from guest g inner join guestreply r on g."+Rdata+" = r.sabun ";
   	StringBuffer sb=new StringBuffer();
   	sb.append(" select rownum rn, g.sabun , g.nalja , r.num , r.writer , r.content from guest g");
   	sb.append(" inner join guestreply r ");
   	sb.append(" on g.sabun=r.sabun ");
   	sb.append(" and r.sabun = "+ Rdata);
    rs=st.executeQuery(sb.toString());
    
    while(rs.next()) {
    	Rrn=rs.getInt("rn");
    	Rnum=rs.getInt("num");
    	Rwriter=rs.getString("writer");
    	Rcontent=rs.getString("content");
    	Rsabun=rs.getInt("sabun");
    	Rda=rs.getDate("nalja");
  %>
   <tr onmouseOver="this.style.backgroundColor='lightgray'" onmouseOut="this.style.backgroundColor=''">
    <td> <%=Rwriter%> </td>
    <td> <%=Rcontent%></td>
    <td>  <%=Rda%></td>
    
    <td align="right">
      <a class='bt' href="guest_reply_delete.jsp?Gidx=<%=Rsabun%>&Gnum=<%=Rnum%>" >[댓글삭제]</a>
      <a class='bt' href="#" onclick="update();" >[댓글수정]</a>
    </td>
   </tr>
  <% } %>   
 </table>	
</body>
</html>