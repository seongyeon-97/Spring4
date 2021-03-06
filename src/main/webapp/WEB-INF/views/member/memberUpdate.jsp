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
	<h1>Member Update Page</h1>
	
	<div class="container-fluid">
		<form class="col-md-5 mx-auto" action="./memberUpdate" method="post">
		
		<div class="mb-3">
			<label for="id" class="form-label">id</label>
			<input type="text" class="form-control"  readonly="readonly" value="${member.id}" name="id">
		</div>
		<div class="mb-3">
			<label for="pw" class="form-label">pw</label>
			<input type="text" class="form-control" value="${sessionScope.member.pw}" name="pw">
		</div>
		
		<div class="mb-3">
		  <label for="name" class="form-label">name</label>
		  <input type="text" class="form-control" value="${sessionScope.member.name}" name="name">
		</div>
		
		<div class="mb-3">
		  <label for="phone" class="form-label">phone</label>		  
		  <input type="text" class="form-control" value="${sessionScope.member.phone}" name="phone">
		</div>
		
		<div class="mb-3">
		  <label for="email" class="form-label">email</label>		  
		  <input type="text" class="form-control" value="${sessionScope.member.email}" name="email">
		</div>
		
		<button type="submit" class="btn btn-success">UPDATE</button>
		
		</form>
		
	</div>
</body>
</html>