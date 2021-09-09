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
	<h1>Join Page</h1>
	
	<div class="container-fluid">
		<form class="col-md-5 mx-auto" action="./insert" method="post">
		
		<div class="mb-3">
		  <label for="id" class="form-label">아이디</label>
		  <input type="text" class="form-control" name="id" id="id">
		</div>
		
		<div class="mb-3">
		  <label for="password" class="form-label">비밀번호</label>
		  <input type="text" class="form-control" name="password" id="password">
		</div>
		
		<div class="mb-3">
		  <label for="name" class="form-label">이름</label>
		  <input type="text" class="form-control" name="name" id="name">
		</div>
		
		<div class="mb-3">
		  <label for="phone" class="form-label">핸드폰 번호</label>
		  <input type="text" class="form-control" name="phone" id="phone">
		</div>
		
		<div class="mb-3">
		  <label for="email" class="form-label">이메일</label>
		  <input type="text" class="form-control" name="email" id="email">
		</div>
		
		<button type="submit">SUBMIT</button>
		
</body>
</html>