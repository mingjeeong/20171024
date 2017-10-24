<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="home.do"><img src="resources/images/4clover.jpeg" width="50" height="50"></a>
<hr>
<a href="home.do">로그아웃</a>
<a href="showInfo.do">마이페이지</a>
<hr>
${userId}${successMessage}
<hr>
내정보 수정하기
<a href="delete.do">탈퇴하기</a>
</body>
</html>