<%@page import="dto.MemberDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	List<MemberDto> list = (List<MemberDto>) request.getAttribute("list");
%>
	<h2>회원 검색</h2>
	<p>
	<a href="main">메인화면</a>
	<table border="1">
		<tr>
			<th>순서</th>
			<th>아이디</th>
			<th>이름</th>
			<th>나이</th>
		</tr>
	<%
		if(list.equals("null")){
	%>
		<h2>일치하는 회원이 없습니다.</h2>	
	<%
		
	} else{
		
		for(int i = 0; i < list.size(); i++){
			MemberDto member = list.get(i);	
	%>
		<tr>
			<td><%=i+1 %></td>
			<td><%=member.getId() %></td>
			<td><%=member.getName() %></td>
			<td><%=member.getAge() %></td>
		</tr>
	<%
		}
	}
	%>
	</table>
</body>
</html>