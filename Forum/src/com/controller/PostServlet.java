package com.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.ServletUtils;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.*;
import com.dao.impl.*;
import com.pojo.Post;

/**
 * Servlet implementation class PostServlet
 */
@WebServlet("/PostServlet")
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PostServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		Map<String, String> m1 = new HashMap<String, String>();
		this.getServletContext().setAttribute("ipsno", m1);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String op = request.getParameter("op");
		if (op == null) {
			String identity = request.getParameter("identity");
			//System.out.print(identity + "!!!!");
			//查询全部帖子
			List<Post> list = new ArrayList<Post>();
			PostDao dao = new PostDaoImpl();
			list = dao.searchall();
			//用户查看帖子
			if (list != null && (identity == "us" || identity.equalsIgnoreCase("us"))) {
				int id = Integer.parseInt(request.getParameter("u_id"));
				String name = request.getParameter("u_name");
				request.setAttribute("u_id", id);
				request.setAttribute("u_name", name);
				request.setAttribute("list", list);
				request.getRequestDispatcher("post_home.jsp").forward(request, response);
			//用户管理帖子
			} else if (list != null && (identity == "usop" || identity.equalsIgnoreCase("usop"))) {
				int u_id = Integer.parseInt(request.getParameter("u_id"));
				request.setAttribute("u_id", u_id);
				request.setAttribute("list", list);
				request.getRequestDispatcher("u_forumop.jsp").forward(request, response);
			//管理员管理帖子
			} else if (list != null && (identity == "ad" || identity.equalsIgnoreCase("ad"))) {
				request.setAttribute("list", list);
				request.getRequestDispatcher("ad_forumop.jsp").forward(request, response);
			//游客查看帖子
			} else if (list != null && (identity == "vi" || identity.equalsIgnoreCase("vi"))) {
				request.setAttribute("list", list);
				request.getRequestDispatcher("vistor_home.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
		} else if (op == "add" || op.equalsIgnoreCase("add")) {//添加帖子和文件
			add(request, response);
		} else if (op == "update" || op.equalsIgnoreCase("update")) {//更新帖子和文件
			update(request, response);
		} else if (op == "delete" || op.equalsIgnoreCase("delete")) {//删除帖子和文件
			delete(request, response);
		} else if (op == "postfind" || op.equalsIgnoreCase("postfind")) {//查看详细，查找帖子
			postfind(request, response);
		} else if (op == "filedown" || op.equalsIgnoreCase("filedown")) {//文件下载
			filedown(request, response);
		} else if (op == "upstate" || op.equalsIgnoreCase("upstate")) {//封贴，解封
			upstate(request, response);
		}
	}
	//封贴，解封
	private void upstate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int p_id = Integer.parseInt(request.getParameter("p_id"));
		int state = Integer.parseInt(request.getParameter("state"));
		System.out.print(p_id + state);
		PostDao dao = new PostDaoImpl();
		boolean flag = dao.state(p_id, state);
		if (flag) {
			request.setAttribute("flag", flag);
			request.getRequestDispatcher("ad_forumop.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}

	}
	//文件下载
	private void filedown(HttpServletRequest request, HttpServletResponse response)
			throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		String fileid = request.getParameter("fileid");
		PostDao dao = new PostDaoImpl();
		Post file = dao.findPost(Integer.parseInt(fileid));
		String filepath = file.getFilepath();
		File tempFile = new File(file.getFilepath());
		String fileName = tempFile.getName();
		// System.out.println("filepath="+filepath);
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));

		ServletUtils.returnFile(filepath, response.getOutputStream());

	}
	//查看详细，查找帖子
	private void postfind(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int p_id = Integer.parseInt(request.getParameter("p_id"));
		PostDao dao = new PostDaoImpl();
		Post postf = dao.findPost(p_id);
		if (postf != null) {
			request.setAttribute("postf", postf);
			request.getRequestDispatcher("post_detail.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}
	//添加帖子
	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String requestip = request.getRemoteAddr();
		// String requesthostName=request.getRemoteHost();
		String filepath;

		String saveDirectory = this.getServletContext().getRealPath("") + "\\pload";
		File savedir = new File(saveDirectory);
		if (!savedir.exists()) {
			savedir.mkdirs();
		}
		int maxPostSize = 3 * 5 * 5 * 1024 * 1024; // 总上传大小限制：75M
		// 重命名策略,不覆盖原来的文件，自动为新文件重新命名，在其后加01，02，03。。。
		FileRenamePolicy policy = (FileRenamePolicy) new DefaultFileRenamePolicy();
		MultipartRequest multi = new MultipartRequest(request, saveDirectory, maxPostSize, "utf-8", policy);
		System.out.println(multi.getParameter("username"));
		int u_id = 0;
		String u_name = null, p_title = null, p_text = null;
		Enumeration formValue = multi.getParameterNames();
		// while(formValue.hasMoreElements()){
		String param = (String) formValue.nextElement();
		u_id = Integer.parseInt(multi.getParameter("u_id"));
		u_name = multi.getParameter("u_name");
		p_title = multi.getParameter("p_title");
		p_text = multi.getParameter("p_text");
		// }
		System.out.print(u_id + u_name + p_title + p_text + "!!!!???");
		// 上传文件的信息
		Enumeration fileNames = multi.getFileNames();
		// while(fileNames.hasMoreElements()){
		String name = (String) fileNames.nextElement();
		File file = multi.getFile(name);// 得到上传的文件
		if (null != p_title) {
			String oldName = multi.getOriginalFileName(name);
			String fileName = multi.getFilesystemName(name); // 取得文件名
			filepath = saveDirectory + "\\" + fileName;
			String contentType = multi.getContentType(name);// 类型
			Post post = new Post();
			post.setU_id(u_id);
			post.setU_name(u_name);
			post.setP_title(p_title);
			post.setP_text(p_text);
			post.setFiletitle(fileName);
			post.setFilecontent(contentType);
			post.setP_state(1);// 0为封禁
			post.setFilepath(filepath);
			PostDao postdao = new PostDaoImpl();
			boolean b = postdao.add(post);
		}
		// }
		request.getRequestDispatcher("post_edit.jsp").forward(request, response);

	}
	//删除帖子
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int u_id = Integer.parseInt(request.getParameter("u_id"));
		int p_id = Integer.parseInt(request.getParameter("p_id"));
		String filepath = request.getParameter("filepath");
		System.out.println("!!!!" + u_id + "  " + p_id + filepath);
		PostDao dao = new PostDaoImpl();
		boolean flag = dao.delete(p_id, u_id);
		//文件删除
		java.io.File del_file = new java.io.File(filepath);
		del_file.delete();
		if (flag) {
			request.getRequestDispatcher("u_forumop.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}
	//修改帖子
	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String requestip = request.getRemoteAddr();
		String filepath;
		String saveDirectory = this.getServletContext().getRealPath("") + "\\pload";
		File savedir = new File(saveDirectory);
		if (!savedir.exists()) {
			savedir.mkdirs();
		}
		int maxPostSize = 3 * 5 * 5 * 1024 * 1024; // 总上传大小限制：75M
		// 重命名策略,不覆盖原来的文件，自动为新文件重新命名，在其后加01，02，03。。。
		FileRenamePolicy policy = (FileRenamePolicy) new DefaultFileRenamePolicy();
		MultipartRequest multi = new MultipartRequest(request, saveDirectory, maxPostSize, "utf-8", policy);
		Enumeration formValue = multi.getParameterNames();
		// while(formValue.hasMoreElements()){
		String param = (String) formValue.nextElement();
		int u_id = Integer.parseInt(multi.getParameter("u_id"));
		int p_id = Integer.parseInt(multi.getParameter("p_id"));
		String u_name = multi.getParameter("u_name");
		String p_title = multi.getParameter("p_title");
		String p_text = multi.getParameter("p_text");
		System.out.println(p_id);
		System.out.println(u_id);
		System.out.println(u_name);
		System.out.println(p_title);
		System.out.println(p_text);
		// }
		
		// 上传文件的信息
		Enumeration fileNames = multi.getFileNames();
		String name = (String) fileNames.nextElement();
		File file = multi.getFile(name);// 得到上传的文件
		String oldName = multi.getOriginalFileName(name);
		String fileName = multi.getFilesystemName(name); // 取得文件名
		String contentType = multi.getContentType(name);// 类型
		Date p_time = new java.sql.Date(new Date().getTime());
		filepath = saveDirectory + "\\" + fileName;
		PostDao postdao = new PostDaoImpl();
		boolean flag = postdao.update(p_title, p_text, fileName, contentType, p_time, filepath, p_id);
		if (flag) {
			request.getRequestDispatcher("success.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

}
