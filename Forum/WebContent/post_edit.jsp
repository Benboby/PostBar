<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<title>Title</title>
<link rel="stylesheet" href="css/post-detail.css">
</head>
<body>

	<h3>编辑帖子</h3>
	<form action="PostServlet?op=add" method="post" enctype="multipart/form-data">
		 <input type="hidden" value=<%=request.getParameter("u_id")%> name="u_id"> 
		<input type="hidden" value=<%=request.getParameter("u_name")%> name="u_name">
		<table align="center">
			<tr>
				<td>标题：</td>
				<td><input type="text" name="p_title"></td>
			</tr>
			<tr>
				<td></td>
				<td><textarea cols="100" rows="30px" name="p_text"></textarea></td>
			</tr>
			<tr>
				<td>附件：</td>
				<td><input type="file" name="file1" contenteditable="false"
					onclick="info.innerHTML=''" />
			<tr>
				<td></td>
				<td><input type="submit" value="发布">
				<input type="reset" value="重置"></td>
			</tr>
		</table>
	</form>

</body>
</html>