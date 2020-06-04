<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户帖子管理</title>
</head>
<body>

	<!-- 自动提交查询全部 -->
	<c:if test="${empty list}">
		<form action="PostServlet?identity=usop" method="post" name='form2'>
			<input type="hidden" value=<%=request.getParameter("u_id")%>
				name="u_id">
		</form>
		<script type="text/javascript">
			document.form2.submit();
		</script>
	</c:if>
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
			<c:if test="${post.u_id==u_id }">
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
					<td><form action="PostServlet?op=delete" method="post"
							name='form6'>
							<input type="hidden" value="${post.u_id}" name="u_id"> 
							<input type="hidden" value="${post.filepath}" name="filepath">
							<input type="hidden" value="${post.p_id}" name="p_id"> 
							 <input  type="submit"  value="删除">
						</form></td>
					<!-- <td><a href="PostServlet?op=delete&p_id=${post.p_id}&u_id=${post.u_id}&filepath=${post.filepath}">删除</a></td> -->
					<td><a href="post_update.jsp?p_id=${post.p_id}&u_id=${post.u_id}&p_title=${post.p_title}&p_text=${post.p_text }">修改</a>
					</td>
				</tr>
			</c:if>
		</c:forEach>
		<tr>
			<th colspan="11"><a href="post_home.jsp?u_id=${u_id}">返回主页</a></th>
		</tr>
	</table>

</body>
</html>