<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ include file="ssi.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> [guest_reply.jsp]</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
  <style type="text/css">
    *{font-size:20pt; font-weight:bold;  font-family:  Segoe UI Symbol , comic Sans MS ;  }
    a{font-size:20pt; font-weight:bold; color:blue; text-decoration:none; }
    a:hover{font-size:20pt; font-weight:bold; color:green; text-decoration:underline; }
    #rsave{
      font-size:26pt; font-weight:bold; 
      background: #00FF00; height:150px;
    }
    table{width:1000px; border-spacing:0;}                
  </style>
  
<script type="text/javascript">

	/* function re_edit(num, writer,content){//num,writer,content
         reply_form.save.value="댓글수정";
		 reply_form.num.value=num;
		 reply_form.writer.value=writer;
         reply_form.content.value=content;
         reply_form.action="reply_update.do";
	 }*/
	 
	 function re_edit(num, writer,content,sabun){
		$("#writer"+num).html("<input type='text' id='edit_writer' value='"+writer+"' required size='10'>");
		$("#content"+num).html("<input type='text' id='edit_content' value='"+content+"' required size='10'>");
		$("#bt"+num).html("<input type='button' id='btnEdit' size='10' value='[수정]' onclick='clicked("+num+","+sabun+");'>  <a href='javascript:location.reload()'>[취소]</a>"); 
	 }
	 
	 function clicked(num,sabun){
		 var writer=$("#edit_writer").val();
		 var content=$("#edit_content").val();
		 location.href="reply_update.do?sabun="+sabun+"&num="+num+"&writer="+writer+"&content="+content;
	 }
	  	 
	function doclick() {
		var rw=reply_form.writer.value;
		var rc=reply_form.content.value;
		
		if(rw==null || rw==""){ 
			alert("댓글 이름데이터  공백입니다");
			reply_form.writer.focus();
			return false;
		}	
		if(rc==null || rc==""){ 
			alert("댓글 내용데이터가 공백입니다");
			reply_form.content.focus();
			return false;
		}  
		return true;
	}
	
	function reply(num){
		document.getElementById("name"+num).setAttribute('type', 'text');
		document.getElementById("cont"+num).setAttribute('type','text');
		document.getElementById("hidename"+num).innerHTML="이름 ";
		document.getElementById("hidecon"+num).innerHTML="내용 ";
	}
	
	  
</script>
 </head>
<body>

<form name="reply_form" action="reply_insert.do" onsubmit="return doclick();" >
          	<input type="hidden" name="sabun" value="${sabun}">
          	<input type="hidden" name="num">
<table border=1 >
  	
  	<tr>
		 <td> 
		 	<img src="resouces/images/z1.gif">저자:<img src="resouces/images/z1.gif">
		 </td>
		 
		 <td>
		 	<input type="text" name="writer" size=25>
		 </td>
				
		 <td rowspan=2 align="center">
		 	<input type="submit" name="save" value="댓글저장"">
		 </td>
	</tr>
		
	<tr>
		<td>
			<img src="resouces/images/z1.gif">내용:<img src="resouces/images/z1.gif">
		</td>
		<td>
		  	<textarea cols=27 rows=2 name="content"></textarea>       
		</td>
	</tr>
	
</table>
</form>

<table>
   <tr bgcolor="pink" align="center">
     <td colspan="6">댓글 데이터 출력 </td>
   </tr>  
</table>	
</body>
</html>