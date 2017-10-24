<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
</head>
<body>
<a href="home.do"><img src="${pageContext.request.contextPath}/resources/images/4clover.jpeg" width="50" height="50"></a>
<hr>회원가입<hr>
<form name="joinForm" action="join.do" method="post">
<table>
	<tr>
		<td>아이디</td>
		<td><input type="text" id="userId" name="userId"></td>
	</tr>
	<tr>
		<td>패스워드</td>
		<td><input type="password" id="userPw" name="userPw"></td>
	</tr>
	<tr>
		<td>이름</td>
		<td><input type="text" id="userName" name="userName"></td>
	</tr>
	<tr>
		<td>등급</td>
		<td><input type="text" id="grade" name="grade"></td>
	</tr>
</table>
<input type="submit" value="회원가입">
</form>
</body>
</html>