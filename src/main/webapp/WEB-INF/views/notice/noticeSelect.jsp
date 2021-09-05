<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<c:import url="../temp/boot_head.jsp"></c:import>
</head>
<body>
	<c:import url="../temp/boot_nav.jsp"></c:import>
	<h1>Notice Select Page##</h1>
	
	<h4>Notice NUM: ${dto.num}</h4>
	<h4>Notice TITLE: ${dto.title}</h4>
	<h4>Notice CONTENTS: ${dto.contents}</h4>
	<h4>Notice WRITER: ${dto.writer}</h4>
	<h4>Notice REGDATE: ${dto.regdate}</h4>
	<h4>Notice HITS: ${dto.hits}</h4>
	
	<a href="./noticeDelete?num=${dto.num}">DELETE</a>
	<a href="./noticeUpdate?num=${dto.num}">UPDATE</a>
	
	
</body>
</html>