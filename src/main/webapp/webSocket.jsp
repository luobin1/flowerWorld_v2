<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>WebSocket示例</title>
<script type="text/javascript" src="resources/jquery.js"></script>
</head>
<body>
	<form action="msg/login.do" method="post">
		用户名:
		<input name="u_phone" value="senly">
		密码:
		<input name="u_pwd" type="password" value="senly">
		<input type="submit" value="登录">
	</form>
</body>

</html>
