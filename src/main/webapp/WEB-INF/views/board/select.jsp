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
	<h1>${board} Select Page</h1>
	
	<h1>num: ${dto.num}</h1>
	<h1>title : ${dto.title}</h1>
	<h1>contents: ${dto.contents}</h1>
	<h1>writer: ${dto.writer}</h1>
	<h1>regdate: ${dto.regdate}</h1>
	<h1>hits: ${dto.hits}</h1>
	
	
	<c:forEach items="${dto.files}" var="f">
		<div>
		<a href="../resources/upload/${board}/${f.fileName}">${f.oriName}</a>
		</div>
	</c:forEach>
	
	
	<a href="./delete?num=${dto.num}">DELETE</a>
	<a href="./update?num=${dto.num}">UPDATE</a>
	<c:if test="${board eq 'qna'}">
		<a href="./reply?num=${dto.num}">REPLY</a>
	</c:if>
</body>
</html>