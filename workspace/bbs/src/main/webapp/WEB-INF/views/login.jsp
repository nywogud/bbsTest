<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>로그인</title>
</head>
<body>

	<script type="text/javascript">
		
		if ('${msgCoincidePassword}'){
			var msg = '${msgCoincidePassword}';
			alert(msg);
		} else if('${msgNotExistId}'){
			var msg = '${msgNotExistId}';
			alert(msg);
		}
	</script>

	<div>
		<form action="/userCheck" method="post">
			<label>ID&nbsp;</label> <input type="text" name="id"> <br>

			<label>PW</label> <input type="password" name="password"> <input
				type="submit" value="로그인"> <br> <label>로그인 유지</label> <input
				type="checkbox" name="loggedinMaintain" id="checked">
		</form>
	</div>
</body>
</html>
