<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="common.Person"%>
<%@page import="java.util.LinkedList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>List 컬렉션</h4>
	<%
		LinkedList<Person> list = new LinkedList<Person>();
		list.add(new Person("맹사성",34));
		list.add(new Person("장영실",50));
		list.add(new Person("신숙주",42));
	%>
	
	<c:forEach items="<%=list %>" var="list">
		<li>
			이름 : ${list.name }, 나이 : ${list.age }
		</li>
	</c:forEach>
	
	<h4>Map 컬렉션 사용하기</h4>
	<%
		Map<String, Person> maps = new HashMap<String,Person>();
		maps.put("1st",new Person("맹사성",34));
		maps.put("2st",new Person("장영실",50));
		maps.put("3st",new Person("신숙주",42));
	%>
	<c:forEach items="<%=maps %>" var="map">
		<li>
			key -> ${map.key }<br>
			Value -> 이름 : ${map.value.name }, 나이 : ${map.value.age }
		</li>
	</c:forEach>
	
	
</body>
</html>