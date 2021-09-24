<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="table table-striped table-hover">	
		<tr align=center>
			<th>COMMENTNUM</th><th>WRITER</th><th>CONTENTS</th><th>REGDATE</th><th>BOARD</th>				
		</tr>
		<c:forEach items="${comments}" var="comment">
			<tr align=center>
				<td>${comment.writer}</td>
				<td>${comment.commentNum}</td>																
				<td id="content${comment.commentNum}">						    		 
			    <%-- <textarea class="form-control" placeholder="Leave a comment here" name="contents" id="" rows="3" readonly="readonly"></textarea> --%>
			    <div>${comment.contents}</div>						
				</td>
				<td>${comment.regdate}</td>
				<td>${comment.board}</td>
				<td>
				<c:if test="${member.id eq comment.writer}">
				<button class="commentUpdate" data-comment-update="${comment.commentNum}">UPDATE</button>
				<button class="commentDel" data-comment-del="${comment.commentNum}">DEL</button>
				</c:if>
				</td>
			</tr>
		</c:forEach>			
</table>
<!-- Paging start-->
		<nav aria-label="Page navigation example">
		  <ul class="pagination">
		    <li class="page-item">
		      <span class="page-link more" data-comment-pn="1" aria-label="Previous">
		        <span aria-hidden="true">&laquo;</span>
		      </span>
		    </li>
		    
		    <li class="page-item">
		      <span class="page-link more" data-comment-pn="${pager.startNum-1}" aria-label="Previous">
		        <span aria-hidden="true">&lt;</span>
		      </span>
		    </li>
		    
		  	<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="n">
          		<li class="page-item"><span class="page-link more" data-comment-pn="${n}">${n}</span></li>
         	</c:forEach>
         	
         	<li class="page-item">
		      <span class="page-link more" data-comment-pn="${pager.lastNum+1}" aria-label="Next">
		        <span aria-hidden="true">&gt;</span>
		      </span>
		    </li>
         	
		    <li class="page-item">
		      <span class="page-link more" data-comment-pn="${pager.totalPage}" aria-label="Next">
		        <span aria-hidden="true">&raquo;</span>
		      </span>
		    </li>
		  </ul>
		</nav>
		<!-- Paging finish-->