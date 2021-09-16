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
	<h1>My Page</h1>
	<h1>ID : ${member.id}</h1>
	<h1>PW : ${member.pw}</h1>
	<h1>NAME : ${member.name}</h1>
	<h1>PHONE : ${member.phone}</h1>
	<h1>E-mail : ${member.email}</h1>
	
	<div>
		<img alt="" src="../resources/upload/member/${member.memberFilesDTO.fileName}">
	</div>
	
	<a href="./memberUpdate?id=${member.id}">정보수정</a>
	<a href="./memberDelete?id=${member.id}">회원탈퇴</a>
	
	
</body>
</html>