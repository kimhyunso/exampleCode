<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="common.Person"%>
<%@page import="java.util.ArrayList"%>
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
	<h4>List 컬렉션 이용하기</h4>
	<%
		ArrayList<Person> list = new ArrayList<Person>();
		list.add(new Person("성삼문",55));
		list.add(new Person("박팽년",60));
	%>
	
	<c:set var="personList" value="<%=list %>" scope="request" />
	
	<ul>
		<li>이름 :${personList[0].name }</li>
		<li>나이 : ${personList[0].age }</li>
	</ul>
	
	<h4>Map 컬렉션 이용하기</h4>
	<%
		Map<String, Person> map = new HashMap<String, Person>();
		map.put("personArgs1",new Person("하위지",65));
		map.put("personArgs2",new Person("이미자",16));
	%>
	<c:set var="personMap" value="<%=map %>" scope="request"/>
	<ul>
		<li>아이디 :${personMap.personArgs1.name }</li>
		<li>비번 : ${personMap.personArgs1.age }</li>
	</ul>
	
</body>
</html>