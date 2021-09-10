<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Id Check Page</h1>
	
		<div>
			${param.id}는
			<c:if test="${empty dto}">사용 가능한 id입니다~!</c:if>
			<c:if test="${not empty dto}">중복된 id 입니다.....</c:if>			
		</div>
		
		<form id="frm" class="col-md-5 mx-auto" action="./idCheck" method="get">
			<div class="mb-3">
			  <label for="id" class="form-label">아이디</label>
			  <input type="text" class="form-control c1" name="id" value="${param.id}" id="id">
			  <button id="idCheck" type="submit">ID중복확인</button>
			  
			  <c:if test="${empty dto}">
			  	<button type="button" id="useId">ID 사용</button>
			  </c:if>
			  
			  <div id="idResult"></div>		  
			</div>
		</form>
		
		<script type="text/javascript">
			/* opener 사용 */
			const useId = document.getElementById('useId');
			useId.addEventListener('click', function(){
				let id = window.document.getElementById('id').value;
				opener.document.getElementById('id').value = id;
				close();
			});
		
		</script>
</body>
</html>