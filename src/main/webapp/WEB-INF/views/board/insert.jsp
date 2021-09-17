<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/boot_head.jsp"></c:import>

<!-- include libraries(jQuery, bootstrap) -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>

<style type="text/css">
	#d1 {
		width: 300px;
		height: 300px;
		background-color: yellow; 
	}
</style>
</head>
<body>
	<c:import url="../temp/boot_nav.jsp"></c:import>
	<h1>${board} Insert Page</h1>
	
	<div class="container-fluid">
		<form class="col-md-5 mx-auto" action="./insert" method="post" enctype="multipart/form-data">
		
		<div class="mb-3">
		  <label for="title" class="form-label">title</label>
		  <input type="text" class="form-control" name="title" id="title">
		</div>
		
		<div class="mb-3">
		  <label for="writer" class="form-label">writer</label>
		  <input type="text" class="form-control" value="${sessionScope.member.id}" name="writer" id="writer">
		</div>
		
		<div class="mb-3">
		  <label for="contents" class="form-label">contents</label>		  
		  <textarea class="form-control" placeholder="Leave a comment here" name="contents" id="contents"></textarea>
		</div>
		
		<button id="fileAdd" type="button" class="btn btn-primary">file add</button>		  
		<button type="button" class="del">DELETE</button>
		
		<div id="fileAddResult">
			
		</div>
		
		<button type="submit" class="btn btn-success">SUBMIT</button>
		
		</form>
		
	</div>
	
	<div id="d1">
		<button id="c1">click</button>
	</div>
	
	<script type="text/javascript" src="../resources/js/boardFile.js"></script>
	
	<script type="text/javascript">

		$('#contents').summernote();
	
	
		$("#d1").click(function(){
			alert('d1');
		});
		
		$('#c1').click(function () {
			alert('c1');
		});
		
	</script>
	
</body>
</html>