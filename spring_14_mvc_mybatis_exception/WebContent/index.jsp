<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

System.out.println("\n## path : " + path);
System.out.println("\n## basePath : " + basePath);
//## path : /spring14
//## basePath : http://localhost:8070/spring14/
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>회원관리</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	
  </head>
  
  <body> 
      
    <h3>회원관리</h3>
    <hr> 
   	<a href="loginView.do">로그인</a>	&nbsp;&nbsp;
    <a href="joinView.do">회원가입</a>
  </body>
</html>










