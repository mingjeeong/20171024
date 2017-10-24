<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
</head>
<body>
<a href="home.do"><img src="${pageContext.request.contextPath}/resources/images/4clover.jpeg" width="50" height="50"></a>
<hr>로그인<hr>
<form name="loginForm" action="login.do" method="post">
아이디 : <input type="text" id="userId" name="userId">
패스워드 : <input type="password" id="userPw" name="userPw"> 
<input type="submit" value="로그인">
</form>

</body>
</html>