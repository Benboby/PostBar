<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>主页</title>
<link rel="stylesheet" href="css/index.css">
</head>
<body>
	 	<div class="header">
		<div class="logo">论坛</div>
		<ul>
		<c:if test="${not empty user.id}">
			<li> <form action="PostServlet?op=postfind" method="post" target="mainFrame">
			<input type="hidden" value="${post.u_id}" name="u_id"> 
			<input maxlength="8" width="110px" placeholder="请输入帖子ID。。。" type="text" name="p_id">
			<input style="border-bottom: 0px; font-size: 15px" type="submit" name="loginBut" value="搜索"/></form></li>
			<li><a href="post_home.jsp?u_id=${user.id}&u_name=${user.username}" target="mainFrame">主页</a></li>
			<li><a href="post_edit.jsp?u_id=${user.id}&u_name=${user.username}" target="mainFrame">发帖</a></li>
			<li><a href="u_forumop.jsp?u_id=${user.id}&u_name=${user.username}" target="mainFrame">帖子管理</a></li>
			</c:if>
			<c:if test="${empty user.id}">
			<li><a href="u_login.jsp">登录</a></li>
			<li><a href="u_register.jsp" target="mainFrame">注册</a></li>
			</c:if>
			<li><a href="ad_login.jsp" >管理员登录</a></li>
			<li class="move"></li>
		</ul>
	</div>
		<c:if test="${not empty user.id}">
		<iframe src="post_home.jsp?u_id=${user.id}&u_name=${user.username}" name="mainFrame" scrolling="no" width="100%" height="100%"></iframe>
		</c:if>
		<c:if test="${empty user.id}">
		<iframe src="vistor_home.jsp" name="mainFrame" width="100%" height="100%" scrolling="no"></iframe>
		</c:if>
</body>
</html>
