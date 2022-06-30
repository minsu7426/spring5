<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원 정보 입력</h2>
	<form:form action="step3" modelAttribute="registerRequest">
	<%-- <form action="step3" method="post"> --%>
		<p>
			<label>이메일 :<br>
			<form:input path="email"/>
			<!-- <input type="text" name="email" id="email"> -->
			</label>
		<p>
		<p>
			<label>이름 :<br>
			<form:input path="name"/>
			<!-- <input type="text" name="name" id="name"> -->
			</label>
		<p>
		<p>
			<label>비밀번호 :<br>
			<form:password path="password"/>
			<!-- <input type="password" name="password" id="password"> -->
			</label>
		<p>
		<p>
			<label>비밀번호 확인 :<br>
			<form:password path="confirmPassword"/>
			<!-- <input type="password" name="confirmPassword" id="confirmPassword"> -->
			</label>
		<p>
		<p>
			<form:input path="email"/>
		<p>
		<input type="submit" value="가입완료">
	</form:form>
	<%-- </form> --%>


</body>
</html>