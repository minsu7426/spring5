<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="step2" method="post">
		<label>
			아이디 : <input type="text" name="id">
		</label>
		<p>
		<label>
			이름 : <input type="text" name="name">
		</label>
		<p>
		<label>
			나이 : <input type="text" name="age">
		</label>
		<p>
		<label>
			이메일 : <input type="text" name="email">
		</label>
		<p>
		<label>
			비밀번호 : <input type="password" name="password">
		</label>
		<p>
		<label>
			비밀번호확인 : <input type="password" name="confirmpassword">
		</label>
		<p>
		<input type="submit" value="전송">
	</form>
</body>
</html>