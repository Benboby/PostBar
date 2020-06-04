package com.controller;

import java.io.File;
import com.pojo.Post;
import java.io.IOException;
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

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.dao.ReplyDao;
import com.dao.impl.ReplyDaoImpl;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;
import com.pojo.Post;
import com.pojo.Reply;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReplyServlet
 */
@WebServlet("/ReplyServlet")
public class ReplyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init() throws ServletException {
        // TODO Auto-generated method stub
        Map<String, String> m1 = new HashMap<String, String>();
        this.getServletContext().setAttribute("ipsno", m1);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doPost(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String op=request.getParameter("op");
       // System.out.print(op+"!!!");
        if(op==null) {
            List<Reply> rlist = new ArrayList<Reply>();
            ReplyDao dao=new ReplyDaoImpl();
            rlist=dao.searchall();
            if(rlist!=null) {
        		String id = request.getParameter("u_id");
            	String p_id=request.getParameter("p_id");
            	 System.out.print(id+"!!!");
        		request.setAttribute("u_id", id);
            	request.setAttribute("p_id", p_id);
                request.setAttribute("rlist", rlist);
                request.getRequestDispatcher("post_reply.jsp").forward(request, response);
            }else {
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
        }else if(op=="add"||op.equalsIgnoreCase("add")){//添加回复
            add(request,response);
        }
        else if(op=="delete"||op.equalsIgnoreCase("delete")){//删除回复
            delete(request,response);
        }
    }
    //添加回复
    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // TODO Auto-generated method stub
        int u_id = Integer.parseInt(request.getParameter("u_id"));
        String u_name = request.getParameter("u_name");
        int p_id = Integer.parseInt(request.getParameter("p_id"));
        String u_reply = request.getParameter("u_reply");
        System.out.print(u_id+u_name+p_id+u_reply);
        Reply reply = new Reply();
        reply.setU_id(u_id);
        reply.setU_name(u_name);
        reply.setP_id(p_id);
        reply.setU_reply(u_reply);
        reply.setR_state(1);//0为封禁

        ReplyDao replydao=new ReplyDaoImpl();
        boolean b=replydao.add(reply);

        request.getRequestDispatcher("post_home.jsp").forward(request, response);
    }
    //删除回复
    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        int u_id=Integer.parseInt(request.getParameter("u_id"));
        int r_id=Integer.parseInt(request.getParameter("r_id"));
        System.out.println("!!!!"+u_id+"  "+r_id);
        ReplyDao dao=new ReplyDaoImpl();
        boolean flag=dao.delete(r_id,u_id);
        if(flag) {
            request.getRequestDispatcher("post_home.jsp").forward(request, response);
        }else {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
