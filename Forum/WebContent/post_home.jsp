<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>帖子页</title>
<link rel="stylesheet" href="css/index.css">
</head>
<body>

	<!-- 自动提交查询全部 -->
		<c:if test="${empty list}">
	<form action="PostServlet?identity=us" method="post" name='form0'>
		<input type="hidden" value=<%=request.getParameter("u_id")%>
			name="u_id"> <input type="hidden"
			value=<%=request.getParameter("u_name")%> name="u_name">
	</form>
	<script type="text/javascript">
		document.form0.submit();
	</script>
	</c:if>
	<div id="frame" target="frame">
		<div id="myheader">
			<!-- 背景图片 -->
			<div id="myheader_bg">
				<img alt="" src="images/img4.jpeg" width="100%" height="300px";>
			</div>
			<!-- 遮罩层 -->
			<div id="myheader_cover"></div>
		</div>


		<div class="main_bg" align="center">
	
					<!-- 简易输出 -->

					<table border="1" align="center">
						<tr>
							<th>用户名</th>
							<th>标题</th>
							<th>内容</th>
							<th>附件名</th>
							<th>附件类型</th>
							<th>日期</th>
							<th>详细</th>
							<th colspan="2">回复</th>
						</tr>
						<c:forEach items="${list}" var="post">
							<c:if test="${post.p_state==1 }">
								<!-- 0为封禁 -->
								<tr>
									<td>${post.u_name}</td>
									<td>${post.p_title}</td>
									<td>${post.p_text }</td>
									<td>${post.filetitle}</td>
									<td>${post.filecontent}</td>
									<td>${post.p_time}</td>
								<td><a href="PostServlet?op=postfind&p_id=${post.p_id}&u_id=<%request.getParameter("u_id");%>"
										target="mainFrame">详细</a></td>
								<td>  
										<form action="post_reply.jsp" method="post">
											<input type="hidden" value="${post.p_id}" name="p_id">
											<input type="hidden" value=<%=request.getParameter("u_id")%> name="u_id"> 
											<input type="submit" value="查看评论">
										</form>
									</td>
									<td>  
										<form action="ReplyServlet?op=add" method="post" name='form3'>
											<input type="hidden" value=<%=request.getParameter("u_id")%> name="u_id"> 
											<input type="hidden" value=<%=request.getParameter("u_name")%> name="u_name">
											<input type="hidden" value="${post.p_id}" name="p_id">
											<input type="text" name="u_reply"> 
											<input type="submit" value="回复">
										</form>
									</td>
								</tr>

							</c:if>
						</c:forEach>
					</table>
				</div>
				</div>
		
</body>
</html>
