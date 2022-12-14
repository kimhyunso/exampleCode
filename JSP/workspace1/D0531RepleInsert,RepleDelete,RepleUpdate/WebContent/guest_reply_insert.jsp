<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ include file="ssi.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> [guest_reply_insert.jsp]</title>
  <style type="text/css">
    *{font-size:20pt; font-weight:bold;  font-family:  Segoe UI Symbol , comic Sans MS ;  }
    a{font-size:20pt; font-weight:bold; color:blue; text-decoration:none; }
    a:hover{font-size:26pt; font-weight:bold; color:green; text-decoration:underline; }
    #rsave{
      font-size:26pt; font-weight:bold; 
      background: #00FF00; height:150px;
    }                
  </style>
 </head>
<body>

<%
   String Rdata= "1200"; //request.getParameter("Gidx"); 
   System.out.println("댓글넘어온  Rdata="+Rdata);
%>

<form name="reply_form">
 <table  width=900 border=1 cellspacing=0 >
   <input type="hidden" name="sabun" value="<%=Rdata%>"> 
   <tr>
	 <td> <img src="images/z1.gif">저자:<img src="images/z1.gif"> </td>
	 <td> <input type="text" name="writer" size=25></td>
			
	  <td rowspan=2 align="center">
	   <input type="button" name="bt_save"   value="댓글저장" id="rsave" >
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
    //msg="select  from guest g  inner join guestreply  r on  " ;
    //ST=CN.createStatement();
    //RS=ST.executeQuery(msg);
    //while(RS.next()==true) {
  %>
   
   <tr>
    <td>  </td>
    <td>  </td>
    <td>  </td>
    <td align="right">
      <a class='bt' href="" >[댓글삭제]</a>
      <a class='bt' href="#" onclick="" >[댓글수정]</a>
      <a class='bt' href="#" onclick="" >[댓글수정2]</a>
    </td>
   </tr>
  <% //} %>   

 </table>	
</body>
</html>












