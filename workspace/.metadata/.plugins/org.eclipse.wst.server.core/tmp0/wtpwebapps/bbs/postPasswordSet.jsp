<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>비밀번호 설정</title>
<link rel="stylesheet"
	href="<c:url value='/resources/css/bootstrap.css'/>">
<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>

</head>
<body>
	<script type="text/javascript">
		var isMatching = '${isMatching}'
		var postPassword = '${postPassword}'
		//null 체크
		if (isMatching) {

			if (isMatching === 'no') {
				window.alert("비밀번호가 일치하지 않습니다.");
			} else if (isMatching === 'yes') {
					$.ajax({
						url : 'writePost.jsp',
						type : 'POST',
						data : {
							'postPassword' : postPassword
						},
						success : function(data) {
							window.close();
						},
						error : function() {
							alert("에러");
						}
					});
				

			}
		}
	</script>

	<div style="text-align: center">
		<form action="/postPasswordCheck" method="post">
			<h3>비밀번호 설정</h3>
			<div>
				<div style="display: inline-block;">
					<label style="margin-right: 46px">비밀번호 : </label> <input
						type="password" name="postPassword"> <br> <label>비밀번호
						재입력 : </label> <input type="password" name="postPasswordCheck"><br>
				</div>
				<div style="display: inline-block;">
					<input
						style="margin-left: 5px; height: 54px; position: relative; bottom: 14px;"
						type="submit" value="저장">
				</div>
			</div>

			${isMatching}
		</form>
	</div>
</body>
</html>
