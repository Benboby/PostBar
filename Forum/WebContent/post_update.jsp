<%--
  Created by IntelliJ IDEA.
  User: satan666
  Date: 2020/5/20
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<title>修改帖子</title>
<link rel="stylesheet" href="css/post-detail.css">
</head>
<body>
	<!--  <div id="container">-->
	<h3>修改帖子</h3>
	<form action="PostServlet?op=update" method="post"
		enctype="multipart/form-data">
		<input type="hidden" value=<%=request.getParameter("p_id")%>
			name="p_id">
			 <input type="hidden" value=<%=request.getParameter("u_id")%> name="u_id"> <input
			type="hidden" value=<%=request.getParameter("u_id")%> name="u_name">
		<table align="center">
			<tr>
				<td>标题：</td>
				<td><input type="text" name="p_title"
					value=<%=request.getParameter("p_title")%>></td>
			</tr>
			<tr>
				<td></td>
				<td><textarea cols="100" rows="30px" name="p_text"><%=request.getParameter("p_text")%></textarea></td>
			</tr>
			<tr>
				<td>附件：</td>
				<td><input type="file" name="file1" contenteditable="false"
					onclick="info.innerHTML=''" /> <!--内容：<input type="text" name="p_filecontent"></td></tr>-->
			<tr>
				<td></td>
				<td><input type="submit" value="修改"><input type="reset"
					value="重置"></td>
			</tr>
		</table>
	</form>

</body>
</html>