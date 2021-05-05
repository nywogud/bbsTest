<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>게시글 목록</title>
<link rel="stylesheet"
	href="<c:url value='/resources/css/bootstrap.css'/>">

</head>

<body>

	<h3>게시글 목록</h3>
	<div>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th style="width: 5%; text-align : center;">번호</th>
					<th style="width: 79%; text-align : center;">제목</th>
					<th style="width: 8%; text-align : center;">작성자</th>
					<th style="width: 8%; text-align : center;">조회수</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${post}" var="post">
					<tr>
						<td style="text-align : center">${post.postNumber}</td>
						<td>${post.postTitle}</td>
						<td style="text-align : center">${post.postWriter}</td>
						<td style="text-align : center">${post.views}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<hr>
	<div style="text-align:center">
		<a class="btn btn-default" href="writePost">글쓰기</a>
		
	</div> 
	

</body>
</html>