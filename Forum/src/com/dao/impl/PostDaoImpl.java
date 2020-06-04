package com.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.pojo.Post;
import com.dao.*;
import com.db.JDBCTools;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;





public class PostDaoImpl implements PostDao{
	protected static String SELECT_SQL="select * from pb_post where p_id=?";
	protected static String INSERT_SQL="insert into pb_post(u_id,u_name,p_title,p_text,p_filetitle,p_filecontent,p_time,p_state,p_filepath) values(?,?,?,?,?,?,?,?,?)";
	protected static String UPDATE_STATE="update pb_post SET p_state=? WHERE p_id=?";
	protected static String UPDATE_SQL="update pb_post SET p_title=?,p_text=?,p_filetitle=?,p_filecontent=?,p_time=?,p_filepath=? WHERE p_id=?";
	protected static String DELETE_SQL="delete from pb_post where p_id=? and u_id=?";
	protected static String SEARCHALL_SQL="select * from pb_post";

	//封贴，解封
		public boolean state(int p_id, int state) {
			// TODO Auto-generated method stub
			Connection con=null;
		    PreparedStatement prepStmt=null;
		    ResultSet rs=null;
		    
		    try {
		    	con=JDBCTools.getConnection();
	            prepStmt = con.prepareStatement(UPDATE_STATE);
	            prepStmt.setInt(1, state);
	            prepStmt.setInt(2, p_id);
	            int i = prepStmt.executeUpdate();
	            if (i>0){
	            	return true;                  
	           }else {
	        	   return false ;
	           }
	      } catch (Exception e) {
	    	  return false;
	      } finally {
	    	  JDBCTools.release(con, prepStmt, rs);
	    }
		}
	//查找
	public Post findPost(int p_id) {
		// TODO Auto-generated method stub
		Connection con=null;
	    PreparedStatement prepStmt=null;
	    ResultSet rs=null;    
	    try {
	    	con=JDBCTools.getConnection();
            prepStmt = con.prepareStatement(SELECT_SQL);
            prepStmt.setInt(1,p_id);
            rs = prepStmt.executeQuery();
            if (rs.next()){
            	Post post=new Post();
            	post.setP_id(rs.getInt(1));
            	post.setU_id(rs.getInt(2));
            	post.setU_name(rs.getString(3));
            	post.setP_title(rs.getString(4));
            	post.setP_text(rs.getString(5));
            	post.setFiletitle(rs.getString(6));
            	post.setFilecontent(rs.getString(7));
            	post.setP_time(rs.getDate(8));
            	post.setP_state(rs.getInt(9));
            	post.setFilepath(rs.getString(10));
            	return post;                  
           }else {
        	   return null ;
           }
      } catch (Exception e) {
          // handle exception
    	  return null;
      } finally {
    	  JDBCTools.release(con, prepStmt, rs);
       }	
	}

	//更新@Override
	public boolean update(String p_title,String p_text,String filetitle,String filecontent, Date p_time,String filepath,int p_id) {
		// TODO Auto-generated method stub
		Connection con=null;
	    PreparedStatement prepStmt=null;
	    ResultSet rs=null;
	    
	    try {
	    	con=JDBCTools.getConnection();
            prepStmt = con.prepareStatement(UPDATE_SQL);
            prepStmt.setString(1,p_title);
            prepStmt.setString(2,p_text);
            prepStmt.setString(3,filetitle);
            prepStmt.setString(4,filecontent);
            prepStmt.setDate(5, new java.sql.Date(new Date().getTime()));
            prepStmt.setString(6,filepath);
            prepStmt.setInt(7, p_id);
           
            int i = prepStmt.executeUpdate();
            if (i>0){
            	return true;                  
           }else {
        	   return false ;
           }
      } catch (Exception e) {
          // handle exception
    	  return false;
      } finally {
    	  JDBCTools.release(con, prepStmt, rs);
    }	
	}
   // 删除
	public boolean delete(int p_id ,int u_id) {
		// TODO Auto-generated method stub
			Connection con=null;
		    PreparedStatement prepStmt=null;
		    ResultSet rs=null;
		    
		    try {
		    	con=JDBCTools.getConnection();
	            prepStmt = con.prepareStatement(DELETE_SQL);
	            prepStmt.setInt(1,p_id);
	            prepStmt.setInt(2,u_id);
	            int i = prepStmt.executeUpdate();
	            if (i>0){
	           	
	            	return true;                  
	           }else {
	        	   return false ;
	           }
	      } catch (Exception e) {
	    	  return false;
	      } finally {
	    	  JDBCTools.release(con, prepStmt, rs);
		  }
	}

	//添加发帖
	public boolean add(Post post) {
		// TODO Auto-generated method stub
		Connection con=null;
	    PreparedStatement prepStmt=null;
	    ResultSet rs=null;
	    
	    try {
	    	con=JDBCTools.getConnection();
            prepStmt = con.prepareStatement(INSERT_SQL);
            prepStmt.setInt(1,post.getU_id());
            prepStmt.setString(2,post.getU_name());
            prepStmt.setString(3,post.getP_title());
            prepStmt.setString(4,post.getP_text());
            prepStmt.setString(5,post.getFiletitle());
            prepStmt.setString(6,post.getFilecontent());
            prepStmt.setDate(7,new java.sql.Date(new Date().getTime()));
            prepStmt.setInt(8, post.getP_state());
            prepStmt.setString(9,post.getFilepath());
            int i = prepStmt.executeUpdate();
            if (i>0){
            	
            	return true;                  
           }else {
        	   return false ;
           }
      } catch (Exception e) {
          // handle exception
    	  return false;
      } finally {
    	  JDBCTools.release(con, prepStmt, rs);
      }
	}

	@Override
	//查询全部
	public List<Post> searchall() {
		// TODO Auto-generated method stub
		List<Post> all = new ArrayList<Post>() ;
		Connection con=null;
	    PreparedStatement prepStmt=null;
	    ResultSet rs=null;
		try
		{
			con=JDBCTools.getConnection();
            prepStmt = con.prepareStatement(SEARCHALL_SQL);
            rs = prepStmt.executeQuery();
			 while (rs.next()){
				 Post post = new Post();
					post.setP_id(rs.getInt(1));
		            post.setU_id(rs.getInt(2));
		            post.setU_name(rs.getString(3));
		            post.setP_title(rs.getString(4));
		            post.setP_text(rs.getString(5));
		            post.setFiletitle(rs.getString(6));
		            post.setFilecontent(rs.getString(7));
		            post.setP_time(rs.getDate(8));
		            post.setP_state(rs.getInt(9));
		            post.setFilepath(rs.getString(10));
				all.add(post);         
	           }
		}catch (Exception e) {
	    	  return null;
	      } finally {
	    	  JDBCTools.release(con, prepStmt, rs);
	       }
		return all;
	}


}
