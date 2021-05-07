<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>로그인</title>
<link rel="stylesheet"
	href="<c:url value='/resources/css/bootstrap.css'/>">
</head>
<body>

	<script type="text/javascript">
		if ('${msgCoincidePassword}') {
			var msg = '${msgCoincidePassword}';
			alert(msg);
		} else if ('${msgNotExistId}') {
			var msg = '${msgNotExistId}';
			alert(msg);
		}
	</script>



	<div style="text-align : center">
		<form action="/userCheck" method="post">

			<h3>로그인</h3>
			<div>
				<div style="display:inline-block;">
					<label style="padding-right: 9px">ID</label> <input type="text"
						name="id"> <br> <label>PW</label> <input
						type="password" name="password"><br> <label>로그인
						유지</label> <input type="checkbox" name="loggedinMaintain" id="checked">

				</div>
				<div style="display:inline-block;">
					<input style="margin-left: 5px; height: 54px; position: relative; bottom: 41px;" type="submit"
						value="로그인">
				</div>
			</div>


		</form>
	</div>

</body>
</html>
