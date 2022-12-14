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
	int s=Integer.parseInt(request.getParameter("isabun"));
	String na=request.getParameter("iname");
	String ti=request.getParameter("ititle");
	int pa=Integer.parseInt(request.getParameter("ipay"));
	

	sql="insert into guest values( ? , ? , ? , sysdate , ? )";
	ps=con.prepareStatement(sql);
	ps.setInt(1,s);
	ps.setString(2, na);
	ps.setString(3, ti);
	ps.setInt(4, pa);
	
	ps.executeUpdate();
%>

  <div align="center" style="margin-top:50px;" >
 	<img src="images/sw03.png" height="450" width="700"><p>
 	<font size=7 color="blue"  face="comic Sans MS"><b>입력 진행중 Waiting...Loading...</b></font>
  </div>
</body>
</html>