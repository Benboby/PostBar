<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>帖子详细</title>
<link rel="stylesheet" href="css/post-detail.css">
</head>
<body>
	<div class="main_bg">
		<div id="main">
			<!-- 简易输出 -->
			<div id="mtop">
				<p>用户名：${postf.u_name}</p>
			</div>
			<div id="mmain">
				<p>标题：${postf.p_title}</p><br>
				<p>内容：${postf.p_text }</p><br>
				<!-- 文件名不为空，可下载文件 -->
				<c:if test="${not empty postf.filetitle }">
					<p>
						文件名：${postf.filetitle}文件类型：${postf.filecontent}<a
							href="PostServlet?op=filedown&fileid=${postf.p_id}">下载</a>
					</p>
				</c:if><br>
				<p>日期：${postf.p_time}</p>
			</div>
		</div>
	</div>

</body>
</html>