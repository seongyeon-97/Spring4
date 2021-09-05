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
	<h1>List Page</h1>
	<div class="container-fluid">
		<div class="col-md-8 mx-auto">
		<table class="table table-striped table-hover">
			<tr align=center>
				<th>NUM</th><th>TITLE</th><th>CONTENTS</th><th>WRITER</th><th>REGDATE</th><th>HITS</th>				
			</tr>
			<c:forEach items="${list}" var="dto">
				<tr align=center>
					<td>${dto.num}</td>
					<td><a href="./noticeSelect?num=${dto.num}">${dto.title}</a></td>
					<td>${dto.contents}</td>
					<td>${dto.writer}</td>
					<td>${dto.regdate}</td>
					<td>${dto.hits}</td>
				</tr>
			</c:forEach>			
		</table>
		
		<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="n">
			<a href="./noticeList?pn=${n}">${n}</a>
		</c:forEach>
		
		
		<a href="./noticeInsert" class="btn btn-danger">ADD</a>
		</div>
	</div>
</body>
</html>