<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理员用户管理</title>
<link rel="stylesheet" href="css/index.css">
</head>
<body>
	<!-- 自动提交查询全部 -->
		<c:if test="${empty ulist}">
	<form action="User?op=searchall" method="post" name='form1'></form>

	<script type="text/javascript">
		document.form1.submit();
	</script>
	</c:if>
<div class="main_bg" align="center">
	<table align="center" border="1">
		<tr>
			<th colspan="8">用户表</th>
		</tr>
		<tr>
			<th>ID</th>
			<th>用户名</th>
			<th>0管理员|1用户</th>
			<th>0封禁|1正常</th>
			<th colspan="4">操作</th>
		</tr>
		<c:forEach items="${ulist}" var="ulist">
			<tr>
				<td>${ulist.id}</td>
				<td>${ulist.username}</td>
				<td>${ulist.role}</td>
				<td>${ulist.state }</td>
				<td><a
					href="User?op=delete&id=${ulist.id}&username=${ulist.username}&password=${ulist.password}">删除</a></td>
				<td><c:if test="${ulist.state==1 }">
						<a
							href="User?op=update&id=${ulist.id}&username=${ulist.username}&password=${ulist.password}&role=${ulist.role}&state=0">封禁
						</a>
					</c:if> <c:if test="${ulist.state==0 }">已封禁</c:if></td>
				<td><c:if test="${ulist.state==0 }">
						<a
							href="User?op=update&id=${ulist.id}&username=${ulist.username}&password=${ulist.password}&role=${ulist.role}&state=1">解封
						</a>
					</c:if> <c:if test="${ulist.state==1 }">未封禁</c:if></td>
				<td><form action="User?op=update" method="post">
						<input type="hidden" value="${ulist.id}" name="id"> 用户名：<input
							type="text" name="username"> 密码：<input type="text"
							name="password"> 角色：<input type="text" name="role">
						状态：<input type="text" name="state"> <input type="submit"
							value="修改">
					</form></td>
			</tr>	
		</c:forEach>
				<tr><th colspan="8"><a href="ad_forumop.jsp">帖子管理</a></th></tr>
				<tr><th colspan="11"><a href="index.jsp?u_id=">返回主页</a></th></tr>
	</table>
</div>
</body>
</html>