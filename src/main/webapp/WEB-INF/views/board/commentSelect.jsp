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
	<h1>${board} CommentSelect Page</h1>
	
	<h1>commentNum: ${comment.commentNum}</h1>
	<h1>num : ${comment.num}</h1>
	<h1>writer: ${comment.writer}</h1>
	<div>	
		${comment.contents}
	</div>
	<h1>regdate: ${comment.regdate}</h1>
	<h1>board: ${comment.board}</h1>
</body>
</html>