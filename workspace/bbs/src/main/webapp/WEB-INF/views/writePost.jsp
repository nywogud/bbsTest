<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>게시글 작성</title>
<link rel="stylesheet"
	href="<c:url value='/resources/css/bootstrap.css'/>">
<script type="text/javascript">
	function setPostPassword() {
		var name = 'postPasswordSet';

		var _width = '500';
		var _height = '380';

		var _left = Math.ceil((window.screen.width - _width) / 2);
		var _top = Math.ceil((window.screen.height - _height) / 2);

		var option = 'top='
				+ _top
				+ ', left='
				+ _left
				+ ', width=500, height=130, status=no, menubar=no, toolbar=no, resize=no';
		window.open('postPasswordSet.jsp', name, option);
	}
</script>

</head>

<body>

	<h3 style="text-align: center">글쓰기</h3>
	<form action="/insertPost" method="post">
		<label style="padding-right: 12px">제목</label><input type="text"
			name="postTitle" style="width: 95%;"><br>
		<hr>
		<div>
			<label style="padding-right: 9px; position: relative; bottom: 135px;">내용</label>
			<textarea name="postTitle" cols="50" rows="13"
				style="width: 95%; resize: none;"></textarea>
			<br>
		</div>
		<hr>
		<div style="float: right; padding-right: 25px;">
			<input type="button" onclick="setPostPassword();" name="postPassword"
				value="비밀번호 설정" style="position: relative; bottom: 3.5px;">

			<label style="font-size: 23px;">N</label>
			

		</div>

	</form>

	${postPassword}

	<br>


</body>
</html>