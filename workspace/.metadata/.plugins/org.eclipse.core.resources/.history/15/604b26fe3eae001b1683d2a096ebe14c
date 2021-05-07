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

			var postPassword = $("#postPassword").val();
			var postPasswordCheck = $('#postPasswordCheck').val();
			
			if (postPassword=='' && postPasswordCheck==''){
				alert("비밀번호와 비밀번호 확인을 모두 입력하지 않았습니다.")
			} 
			else if(postPassword=='' || postPasswordCheck==''){
				alert("비밀번호 혹은 비밀번호 확인을 입력하지 않았습니다.")
			}
			
			else{
				if (postPassword === postPasswordCheck) {
					$.ajax({
						type : 'post',
						url : '${contextPath}/postPassword',
						data : {"postPassword" : $("#postPassword").val()},

						success : function() {
							window.opener.changeStatus();//자식창에서 부모창의 함수 호출. 반대는 popup
							window.close();
						},
						error : function(request, status, error) {
							alert("code = " + request.status + "message = "
									+ request.responseText + "error = " + error);
						}

					});
				}
				else {
					alert("비밀번호가 일치하지 않습니다.")
				}
			}

		});
	});
	
</script>

</head>
<body>

	<div style="text-align: center">
		<form>
			<h3>비밀번호 설정</h3>
			<div>
				<div style="display: inline-block;">
					<label style="margin-right: 46px">비밀번호 : </label> 
					<input type="password" id="postPassword"> 
					<br> 
					<label>비밀번호 재입력 : </label> 
					<input type="password" id="postPasswordCheck"><br>
				</div>
				<div style="display: inline-block;">
					<input id="btn"
						style="margin-left: 5px; height: 54px; position: relative; bottom: 14px;"
						type="button" value="저장">
				</div>
			</div>
		</form>
	</div>
</body>
</html>
