<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
 
<html>
<head>
	<title>Home</title>
	<!-- css -->
	<link type="text/css" rel="stylesheet" href="resources/css/core.css">
	<!-- js -->
	<script type="text/javascript" src="resources/js/common.js"></script>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<p>Message : ${message}</p>
<hr>
1. Image : <img src="resources/images/flower_image11.png" alt="MESSAGE IMAGE" title="메세지 이미지"><br>
2. EL태그 사용 : <img src="${pageContext.request.contextPath}/resources/images/flower_image11.png"><br>
3. JSTL태그 사용: <img src='<c:url value="resources/images/flower_image11.png"/>'/><br>
<hr>
<a href="loginView.do">로그인 : 아이디 암호</a><br>
<a href="joinView.do">회원가입 : 아이디 암호 이름 등급</a>
<hr>
</body>
</html>
