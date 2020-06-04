package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.dao.impl.*;
import com.pojo.Users;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/User")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String op=request.getParameter("op");
		System.out.print(op);
		if(op==null) {
		//1、获得用户的参数2、调用dao的方法3、资源的跳转
		String name=request.getParameter("username");
		String pwd=request.getParameter("password");
		//用户登录
		UserDao dao=new UserDaoImpl();
		Users user=dao.login(name, pwd);
		if(user!=null) {
			//普通用户登录
			if(user.getRole()==1) {
			request.setAttribute("user", user);
			request.getRequestDispatcher("index.jsp").forward(request, response);
			}else {//管理员登录
				request.setAttribute("user", user);
				request.getRequestDispatcher("ad_userop.jsp").forward(request, response);
			}
		}else {
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
		}else if(op=="reg"||op.equalsIgnoreCase("reg")){//注册
			reg(request,response);
		}
		else if(op=="update"||op.equalsIgnoreCase("update")){//修改，解封，封禁
				update(request,response);
		}
		else if(op=="delete"||op.equalsIgnoreCase("delete")){//删除
			delete(request,response);
		}
		else if(op=="searchall"||op.equalsIgnoreCase("searchall")){//查询全部
			searchall(request,response);
		} 
		
	}
	//注册
	protected void reg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1、获得用户的参数2、调用dao的方法3、资源的跳转
				String name=request.getParameter("username");
				String pwd=request.getParameter("password");
				UserDao dao=new UserDaoImpl();
				boolean flag=dao.reg(name, pwd);
				if(flag) {
					request.getRequestDispatcher("u_login.jsp").forward(request, response);	
				}else {
					request.getRequestDispatcher("error.jsp").forward(request, response);
				}
	}
	//修改，解封，封禁
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				String name=request.getParameter("username");
				String pwd=request.getParameter("password");
				int id=Integer.parseInt(request.getParameter("id"));
				int role=Integer.parseInt(request.getParameter("role"));
				int state=Integer.parseInt(request.getParameter("state"));
				System.out.print(name+pwd+id+role+state);
				UserDao dao=new UserDaoImpl();
				boolean flag=dao.update(name, pwd,role,state,id);
				if(flag) {
					request.getRequestDispatcher("ad_userop.jsp").forward(request, response);
				}else {
					request.getRequestDispatcher("error.jsp").forward(request, response);
				}

	}
	//删除
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				int id=Integer.parseInt(request.getParameter("id"));
				String name=request.getParameter("username");
				String pwd=request.getParameter("password");
				//System.out.print(id+"####"+name+"#####"+pwd);
				UserDao dao=new UserDaoImpl();
				boolean flag=dao.delete(id,name,pwd);
				if(flag) {
					request.getRequestDispatcher("ad_userop.jsp").forward(request, response);
				}else {
					request.getRequestDispatcher("error.jsp").forward(request, response);
				}
					
	}
	//查询全部
	protected void searchall(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		        List<Users> ulist = new ArrayList<Users>();
		        UserDao dao=new UserDaoImpl();
 		        try {
			    ulist = dao.searchall();
		        } catch (Exception e) {
			    // TODO Auto-generated catch block
			    e.printStackTrace();
		        }
 		        request.setAttribute("ulist", ulist);//将lists放到作用域
 		       request.getRequestDispatcher("ad_userop.jsp").forward(request, response);
	}
}
