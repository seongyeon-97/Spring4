<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<html>
<head>
	<title>Home</title>
	
	
	
	<c:import url="./temp/boot_head.jsp"></c:import>
</head>
<body>
	<c:import url="./temp/boot_nav.jsp"></c:import>
	
	<c:if test="${not empty member}">
		<h3>${member.id}님 환영합니다~!~!</h3>
	</c:if>
	<c:if test="${empty member}">
		<h3>Login이 필요합니다</h3>
	</c:if>

</body>
</html>
