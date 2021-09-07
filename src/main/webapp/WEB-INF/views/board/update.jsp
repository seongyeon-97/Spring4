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
	<h1>${board} Update Page</h1>
	
	<div class="container-fluid">
		<form class="col-md-5 mx-auto" action="./update" method="post">
		
		<div class="mb-3">
			<label for="num" class="form-label">num</label>
			<input type="text" class="form-control"  readonly="readonly" value="${dto.num}" name="num">
		</div>
		<div class="mb-3">
			<label for="title" class="form-label">title</label>
			<input type="text" class="form-control" value="${dto.title}" name="title">
		</div>
		
		<div class="mb-3">
		  <label for="writer" class="form-label">writer</label>
		  <input type="text" class="form-control" value="${dto.writer}" name="writer" id="writer">
		</div>
		
		<div class="mb-3">
		  <label for="contents" class="form-label">contents</label>		  
		  <textarea class="form-control" value="${dto.contents}" name="contents" id="contents"></textarea>
		</div>
		
		<button type="submit" class="btn btn-success">UPDATE</button>
		
		</form>
		
	</div>
</body>
</html>