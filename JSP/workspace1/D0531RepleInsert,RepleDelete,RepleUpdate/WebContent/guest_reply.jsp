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
		 var bt = reply_form.bt_save.value;
		 var writer = reply_form.writer.value;
		 var content = reply_form.content.value;
		 //alert(bt +" " + writer +" "+content);	
	 }//re_save end
	  
	function re_edit2(num,writer,content,sabun){
	}//end
	
	function click() {
		$(".rsave").click(function () {
			doument.myform.writer.value="";
			doument.myform.content.value="";
		});
	}
	
  </script>
 </head>
<body>

<%
 //guest_reply.jsp문서는 단독실행 금지
   String Rdata=request.getParameter("Gidx"); 
   System.out.println("댓글넘어온  Rdata="+Rdata);
   
%>

<form name="reply_form">
 <table  width=900 border=1 cellspacing=0 >
   <input type="hidden" name="sabun" value="<%=Rdata%>"> 
   <tr>
	 <td> <img src="images/z1.gif">저자:<img src="images/z1.gif"> </td>
	 <td> <input type="text" name="writer" size=25></td>
			
	  <td rowspan=2 align="center">
	   <input type="button" name="bt_save"   value="댓글저장" id="rsave" onclick="click();" >
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
   	sql="select *from guest g inner join guestreply r on g."+Rdata+" = r.sabun ";
    rs=st.executeQuery(sql);
   	while(rs.next()) {
  %>
   
   <tr>
    <td> <%=rs.getString("writer")%> </td>
    <td>  <%=rs.getString("content")%></td>
    <td>  <%=rs.getDate("nalja")%></td>
    <td align="right">
      <a class='bt' href="" >[댓글삭제]</a>
      <a class='bt' href="#" onclick="" >[댓글수정]</a>
    </td>
   </tr>
  <% } %>   

 </table>	
</body>
</html>






