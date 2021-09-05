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

	<h1>Notice Update Page$$</h1>
	
	<div class="container-fluid">
		<form class="col-md-5 mx-auto" action="./noticeUpdate" method="post">
		
		<div class="mb-3">
			<label for="num" class="form-label">Num</label>
			<input type="text" class="form-control"  readonly="readonly" value="${dto.num}" name="num">
		</div>
		
		<div class="mb-3">
		  <label for="title" class="form-label">Title</label>
		  <input type="text" class="form-control" value="${dto.title}" name="title" id="title" placeholder="Enter title">
		</div>
		
		<div class="mb-3">
		  <label for="contents" class="form-label">Contents</label>
		  <input type="text" class="form-control" value="${dto.contents}" name="contents" id="contents" placeholder="Enter contents">
		</div>
		
		<div class="mb-3">
		  <label for="writer" class="form-label">Writer</label>
		  <input type="text" class="form-control" value="${dto.writer}" name="writer" id="writer">
		</div>		
		
		<button type="submit" class="btn btn-success">UPDATE</button>
		
		</form>
		
	</div>

</body>
</html>