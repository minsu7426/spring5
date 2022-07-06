<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>약관</h2>
	<p>약관 내용
	<form action="step1" method="post">
		<label>
			<input type="checkbox" name="step1_check" value="true"> 약관 동의
		</label>
		<p>
		<input type="submit" value="다음 단계">
		<a href="main">취소</a>
	</form>
</body>
</html>