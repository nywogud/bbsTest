<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>비밀번호 설정</title>
<link rel="stylesheet"
	href="<c:url value='/resources/css/bootstrap.css'/>">
<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script type="text/javascript">

	$(document).ready(function() {
		$("#btn").click(function() {
			var postPassword = window.opener.postPassword;
			var postPasswordCheck = $('#postPasswordCheck').val();
			//값을 잘 받아옴.
			
			if(postPasswordCheck==''){
				alert("비밀번호를 입력하지 않았습니다.")
				window.opener.goBoard();
				window.close();
			}
			else {
				if(postPassword==postPasswordCheck){
					window.opener.goDetails();
					window.close();
				}
				else {
					alert("비밀번호가 일치하지 않습니다.")
					window.opener.goBoard();
					window.close();
				}
			}
		});
	});
	
</script>

</head>
<body>

	<div style="text-align: center">
		<form>
			<h4>비밀번호 확인</h4>
			<div>
				<div style="display: inline-block;">
					<label>비밀번호 : </label> <input type="password"
						id="postPasswordCheck">
				</div>
				<div style="display: inline-block;">
					<input id="btn" style="height: 25px;" type="button" value="확인">
				</div>
			</div>
		</form>
	</div>
</body>
</html>
