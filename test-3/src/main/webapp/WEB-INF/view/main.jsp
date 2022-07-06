<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>메인화면</h2>
	
	<a href="input">회원 추가하기</a>
	<p>
	<a href="searchAll">전체 회원 검색</a>
	<p>
	<form action="search" method="post">
		회원 검색 : 
		<select name="title">
			<option value="id" selected>아이디</option>
			<option value="name">이름</option>
			<option value="age">나이</option>
		</select>
		<input type="text" name="text">
		<input type="submit" value="검색">
	</form>
</body>
</html>