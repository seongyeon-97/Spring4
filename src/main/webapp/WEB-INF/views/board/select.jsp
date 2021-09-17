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
	
	<div>	
		${dto.contents}
	</div>
	
	<h1>writer: ${dto.writer}</h1>
	<h1>regdate: ${dto.regdate}</h1>
	<h1>hits: ${dto.hits}</h1>
	
	
	<c:forEach items="${dto.files}" var="f">
		<div>
		<a href="./down?fileName=${f.fileName}">${f.oriName}</a>
		</div>
	</c:forEach>
	
	<hr>
		<div>
			<div class="mb-3">
			  <label for="writer" class="form-label">writer</label>
			  <input type="text" class="form-control" value="${sessionScope.member.id}" name="writer" id="writer">
			</div>
			
			<div class="mb-3">
			  <label for="contents" class="form-label">contents</label>		  
			  <textarea class="form-control" placeholder="Leave a comment here" name="contents" id="contents"></textarea>
			</div>
			
			<button id="comment" type="button" class="btn btn-primary">WRITE</button>		  	
		</div>
	<hr>
	
	<a href="./delete?num=${dto.num}">DELETE</a>
	<a href="./update?num=${dto.num}">UPDATE</a>
	
	<c:if test="${board eq 'qna'}">
		<a href="./reply?num=${dto.num}">REPLY</a>
	</c:if>
	
	<script type="text/javascript">
		$('#comment').click(function(){
			let writer = $('#writer').val();
			let contents = $('#contents').val();			
			$.post('./comment', {num:'${dto.num}', writer:writer, contents:contents}, function (result) {
				console.log(result.trim());
			});	
		});
	</script>
</body>
</html>