<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<html>
<head>
	<title>Home</title>
	
	
	
	<c:import url="./temp/boot_head.jsp"></c:import>
</head>
<body>
	<c:import url="./temp/boot_nav.jsp"></c:import>
	
	<c:if test="${not empty member}">
		<h3>${member.id}님 환영합니다~!~!</h3>
	</c:if>
	<c:if test="${empty member}">
		<h3>Login이 필요합니다</h3>
	</c:if>
	
	<h1 id="ar"></h1>
	
	<button id="btn">CLICK</button>
	
	<div>
		<table id="r" class="table table-hover">
			<tr>
				<td>ID</td>
				<td>TITLE</td>
				<td>USERID</td>
			</tr>
		</table>
	</div>
	
	<script type="text/javascript">
		
		$('#btn').click(function () {
			$.ajax({
				type : "GET",
				url : "http://jsonplaceholder.typicode.com/posts",
				success : function (result) {					
					console.log(result);
					for(v1 of result){
						let v = "<tr>";
						v = v + "<td>";
						v = v + v1.id;
						v = v + "</td>";
						v = v + "<td>";
						v = v + v1.title;
						v = v + "</td>";
						v = v + "<td>";
						v = v + v1.userId;
						v = v + "</td>";
						v = v + "</tr>"
						$('#r').append(v);
					}
					
					
				}
			});
		});
	
	</script>
	
</body>
</html>
