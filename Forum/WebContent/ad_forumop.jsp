<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理员帖子管理</title>
<link rel="stylesheet" href="css/index.css">
</head>
<body>
	<!-- 自动提交查询全部 -->
		<c:if test="${empty list}">
	<form action="PostServlet?identity=ad" method="post" name='form2'></form>
	<script type="text/javascript">
		document.form2.submit();
	</script>
	</c:if>
<div class="main_bg" align="center">
	<table border="1" align="center">
		<tr>
		<tr>
			<th colspan="11">帖子表</th>
		</tr>
		<th>帖子ID</th>
		<th>用户ID</th>
		<th>用户名</th>
		<th>标题</th>
		<th>内容</th>
		<th>附件名</th>
		<th>附件类型</th>
		<th>时间</th>
		<th>0封禁|1正常</th>
		<th colspan="2">操作</th>
		</tr>
		<c:forEach items="${list}" var="post">
			<!-- 0为封禁 -->
			<tr>
				<td>${post.p_id}</td>
				<td>${post.u_id}</td>
				<td>${post.u_name}</td>
				<td>${post.p_title}</td>
				<td>${post.p_text }</td>
				<td>${post.filetitle}</td>
				<td>${post.filecontent}</td>
				<td>${post.p_time}</td>
				<td>${post.p_state}</td>
				<td><c:if test="${post.p_state==1 }">
						<a href="PostServlet?op=upstate&p_id=${post.p_id}&state=0">封禁
						</a>
					</c:if> <c:if test="${post.p_state==0 }">已封禁</c:if></td>
				<td><c:if test="${post.p_state==0 }">
						<a href="PostServlet?op=upstate&p_id=${post.p_id}&state=1">解封
						</a>
					</c:if> <c:if test="${post.p_state==1}">未封禁</c:if></td>
			</tr>
		</c:forEach>
		<tr>
			<th colspan="11"><a href="ad_userop.jsp">用户管理</a></th>
		</tr>
		<tr><th colspan="11"><a href="index.jsp?u_id=">返回主页</a></th></tr>
	</table>
	</div>
</body>
</html>