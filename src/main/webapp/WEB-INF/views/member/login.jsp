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

	<h1>Login Page</h1>
	<div class="container-fluid">
		<form id="frm" class="col-md-5 mx-auto" action="./login" method="post">
		
		<div class="mb-3">
		  <label for="id" class="form-label">아이디</label>
		  <input type="text" class="form-control c1" name="id" id="id">		  
		</div>
		
		<div class="mb-3">
		  <label for="password" class="form-label">비밀번호</label>
		  <input type="password" class="form-control c1 pw" name="pw" id="password">
		</div>
		
		
		<div class="mb-3 my-4">
		  <label class="form-label"></label>
		  <button id="btn" type="submit" class="btn btn-primary">LOGIN</button>
		</div>
		
		</form>
		</div>
		<script type="text/javascript" src="../resources/js/login.js"></script>
</body>
</html>