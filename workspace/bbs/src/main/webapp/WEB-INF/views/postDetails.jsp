<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>상세 페이지</title>
<link rel="stylesheet"
	href="<c:url value='/resources/css/bootstrap.css'/>">
<script type="text/javascript">
	function setPostPassword(postNumber) {
		
		postNumberSetPassword = postNumber;
		
			var name = 'postPasswordSetFromDetails';

			var _width = '500';
			var _height = '380';

			var _left = Math.ceil((window.screen.width - _width) / 2);
			var _top = Math.ceil((window.screen.height - _height) / 2);

			var option = 'top='
					+ _top
					+ ', left='
					+ _left
					+ ', width=500, height=130, status=no, menubar=no, toolbar=no, resize=no';
			window.open('postPasswordSetFromDetails.jsp', name, option);
		}
	

	function goBoard() {
		window.location.href="${contextPath}/board";
	}
	
</script>
</head>
<body>
	<h3>상세 페이지</h3>
	<table class="table table-bordered">
		<thead>
			<tr>
				<th style="width: 5%; text-align: center;">번호</th>
				<th style="width: 79%; text-align: center;">제목</th>
				<th style="width: 8%; text-align: center;">작성자</th>
				<th style="width: 8%; text-align: center;">조회수</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td style="text-align: center">${post.postNumber}</td>
				<td style="text-align: center">${post.postTitle}</td>
				<td style="text-align: center">${post.postWriter}</td>
				<td style="text-align: center">${post.views}</td>
			</tr>
			<tr>
				<td colspan="4" height="100">${post.contents}</td>
			</tr>
		</tbody>
	</table>
	<input type="button" onclick="setPostPassword(${post.postNumber});"
		name="postPassword" value="비밀번호 설정">
	<input type="button" onclick="location.href='/board'" value="게시판으로 이동">

</body>
</html>
