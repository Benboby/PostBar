<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>回复页</title>
</head>
<body>
						<!-- 自动提交 -->
							<c:if test="${empty rlist}">
						<form action="ReplyServlet" method="post" name='form5'>
						<input type="hidden" value=<%=request.getParameter("p_id")%> name="p_id"> 
							<input type="hidden" value=<%=request.getParameter("u_id")%> name="u_id"> 
						</form>
						<script type="text/javascript">
							document.form5.submit();
						</script>
							</c:if>
						<p>评论</p>
						<table border="1" >
							<tr>
								<th>用户ID</th>
								<th>用户名</th>
								<th>内容</th>
							</tr>
							<c:forEach items="${rlist}" var="rlist">
							<c:if test="${rlist.p_id==p_id }">
								<tr>
									  <td>${rlist.u_id}</td>
									  <td>${rlist.u_name}</td>
									  <td>${rlist.u_reply }</td>
									  <c:if test="${rlist.u_id==u_id}">
									<td><a href="ReplyServlet?op=delete&r_id=${rlist.r_id}&u_id=${rlist.u_id}">删除</a></td>
							</c:if>
								</tr>
								</c:if>
							</c:forEach>
								<tr><th colspan="3"><a href="post_home.jsp?u_id=${u_id}">返回主页</a></th></tr>
						</table>
</body>
</html>