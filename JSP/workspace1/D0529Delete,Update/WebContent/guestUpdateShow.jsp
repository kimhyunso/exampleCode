<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="ssi.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title> [index.jsp]</title>
  <script type="text/javascript">
    window.setTimeout("location.href='guestList.jsp'",3000);
  </script>
</head>
<body>
<%
	//st=con.createStatement();
	int sab=Integer.parseInt(request.getParameter("usabun"));
	String na=request.getParameter("uname");
	String ti=request.getParameter("utitle");
	int p=Integer.parseInt(request.getParameter("upay"));
	//sql="update guest set sabun= " +sab+", name= '" +na+"' ,title= '"+ti+"' , nalja= sysdate ,pay= "+p+" where sabun= "+sab;
	sql="update guest set sabun= ?,name= ?,title= ?,nalja= sysdate, pay= ? where sabun= ?";
	ps=con.prepareStatement(sql);
	ps.setInt(1, sab);
	ps.setString(2, na);
	ps.setString(3, ti);
	ps.setInt(4, p);
	ps.setInt(5, sab);
	
	ps.executeUpdate();
	//st.executeUpdate(sql);
%>

  <div align="center" style="margin-top:50px;" >
 	<img src="images/sw03.png" height="450" width="700"><p>
 	<font size=7 color="blue"  face="comic Sans MS"><b> 수정진행중 Waiting...Loading...</b></font>
  </div>
</body>
</html>