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

	<h1>check page</h1>
	
	<div class="container-fluid">
	<div class="form-check">
  		<input class="form-check-input" type="checkbox" value="" id="all">
  		<label class="form-check-label" for="all">
    		CHECK ALL
 		</label>
	</div>
	<div class="form-check">
  		<input class="form-check-input c1 ch" type="checkbox" value="" id="flexCheckDefault">
  		<label class="form-check-label" for="flexCheckDefault">
    		약관1
 		</label>
	</div>
	<div class="form-check">
  		<input class="form-check-input c1 ch" type="checkbox" value="" id="flexCheckDefault">
  		<label class="form-check-label" for="flexCheckDefault">
    		약관2
 		</label>
	</div>
	<div class="form-check">
  		<input class="form-check-input c1 ch" type="checkbox" value="" id="flexCheckDefault">
  		<label class="form-check-label" for="flexCheckDefault">
    		약관3
 		</label>
	</div>
	<div class="form-check">
  		<input class="form-check-input c1" type="checkbox" value="" id="flexCheckDefault">
  		<label class="form-check-label" for="flexCheckDefault">
    		약관4(광고성)
 		</label>
	</div>
	<button id="btn">회원가입</button>	
	</div>
	<script type="text/javascript" src="../resources/js/check.js"></script>
</body>
</html>