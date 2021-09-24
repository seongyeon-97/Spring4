<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/boot_head.jsp"></c:import>
<style type="text/css">
	.more{
		cursor: pointer;
	}
</style>
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
	
	<!-- commentList -->
	<div id="commentList" data-board-num="${dto.num}">
		
	</div>
	
		<div>
			<div class="mb-3">
			  <label for="writer" class="form-label">writer</label>
			  <input type="text" class="form-control" value="${sessionScope.member.id}" name="writer" id="writer">
			</div>
			
			<div class="mb-3">
			  <label for="contents" class="form-label">contents</label>		  
			  <textarea class="form-control" placeholder="Leave a comment here" name="contents" id="contents"></textarea>
			</div>
			

			<div class="mt-3 ml-0">
            <button type="submit" class="btn btn-success" id="comment">WRITE</button>
        	</div>		  	
		</div>		
	<hr>
	
	<a href="./delete?num=${dto.num}">DELETE</a>
	<a href="./update?num=${dto.num}">UPDATE</a>
	
	<c:if test="${board eq 'qna'}">
		<a href="./reply?num=${dto.num}">REPLY</a>
	</c:if>
	
	<script type="text/javascript">
		getCommentList(1);
		let content='';
		
		$('#commentList').on('click', '.commentUpdate', function () {
			console.log('update');			
			let num = $(this).attr("data-comment-update");
			content = $('#content'+num).text().trim();
			$('#content'+num).children().css("display", "none");
			let ta = '<textarea class="form-control" placeholder="Leave a comment here" name="contents" id="" rows="3">'
			ta = ta + content.trim() + '</textarea>'
			ta = ta + '<button type="button" class="btn btn-success up">UPDATE</button>'
			ta = ta + '<button type="button" class="btn btn-danger can">CANCEL</button>'
			$('#content'+num).append(ta);
			
		});		
		
		//cancel
		$('#commentList').on('click', '.can', function () {
			$(this).parent().children('div').css('display', 'block');
			$(this).parent().children('textarea').remove();
			$(this).parent().children('button').remove();
		});
		
		$('#commentList').on('click', '.up', function () {
			let contents = $(this).prev().val();
			console.log(contents);
			let cn = $(this).parent().prev().text().trim();
			console.log(cn);
			let selector=$(this);
			$.ajax({
				type : "POST",
				url : "./commentUpdate",
				data : {
					commentNum :cn,
					contents:contents
				},
				success : function (result) {
					if(result.trim()>0){
						alert('수정 성공');
						//getCommentList(1);
						selector.parent().children('div').text(contents);
						selector.parent().children('div').css('display', 'block');
						selector.parent().children('textarea').remove();
						selector.parent().children('button').remove();
					}else{
						alert('수정 실패');
					}
				},
				error : function () {
					alert('수정실패');
				}
			})
		});
		
		$('#commentList').on("click", ".commentDel", function () {
			let commentNum = $(this).attr("data-comment-del");
			$.ajax({
				type : "POST",
				url : "./commentDel",
				data : {commentNum : commentNum},
				success : function(result){
					result = result.trim();
					$('#commentList').html(result);
				},
				error : function(xhr, status, error){
					console.log(error);
				}
			});
		});
		
		$("#commentList").on("click", ".more", function () {
			let pn = $(this).attr("data-comment-pn"); 
			getCommentList(pn);
		});
	
		function getCommentList(pageNumber) {
			let num = $('#commentList').attr("data-board-num");
			$.ajax({
				type : "GET",
				url : "./getCommentList",
				data : {num : num, pn : pageNumber},
				success : function(result){
					result = result.trim();
					$('#commentList').html(result);
				},
				error : function(xhr, status, error){
					console.log(error);
				}
			});
		}	
	
	
	
		$('#comment').click(function(){
			let writer = $('#writer').val();
			let contents = $('#contents').val();			
			$.post('./comment', {num:'${dto.num}', writer:writer, contents:contents}, function (result) {
				console.log(result.trim());
				getCommentList();
			});	
		});
		
		
	</script>
</body>
</html>