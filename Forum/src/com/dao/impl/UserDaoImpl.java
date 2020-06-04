package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.dao.*;
import com.dao.impl.*;
import com.db.*;
import com.pojo.Users;

public class UserDaoImpl implements UserDao {
	protected static String SELECT_SQL="select * from pb_user where username=? and password=?";
	protected static String INSERT_SQL="insert into pb_user(username,password,role,state) values(?,?,?,?)";
	protected static String UPDATE_SQL="update pb_user SET username=?,password=?,role=?,state=? WHERE id=?";
	protected static String DELETE_SQL="delete from pb_user where id=? and username=? and password=?";
	protected static String SEARCHALL_SQL="select * from pb_user";

	//查找,登录
	public Users login(String name,String pwd) {
		// TODO Auto-generated method stub
		Connection con=null;
	    PreparedStatement prepStmt=null;
	    ResultSet rs=null;    
	    try {
	    	con=JDBCTools.getConnection();
            prepStmt = con.prepareStatement(SELECT_SQL);
            prepStmt.setString(1,name);
            prepStmt.setString(2,pwd);
            rs = prepStmt.executeQuery();
            if (rs.next()){
            	Users user=new Users();
            	user.setId(rs.getInt(1));
            	user.setUsername(rs.getString(2));
            	user.setPassword(rs.getString(3));
            	user.setRole(rs.getInt(4));
            	user.setState(rs.getInt(5));
            	return user;                  
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
	//更新
	public boolean update(String name, String pwd,int role,int state, int id) {
		// TODO Auto-generated method stub
		Connection con=null;
	    PreparedStatement prepStmt=null;
	    ResultSet rs=null;
	    
	    try {
	    	con=JDBCTools.getConnection();
            prepStmt = con.prepareStatement(UPDATE_SQL);
            prepStmt.setString(1,name);
            prepStmt.setString(2,pwd);
            prepStmt.setInt(3,role);
            prepStmt.setInt(4,state);
            prepStmt.setInt(5,id);
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
	//删除
	public boolean delete(int id,String name,String pwd) {
		// TODO Auto-generated method stub
		Connection con=null;
	    PreparedStatement prepStmt=null;
	    ResultSet rs=null;
	    
	    try {
	    	con=JDBCTools.getConnection();
            prepStmt = con.prepareStatement(DELETE_SQL);
            prepStmt.setInt(1,id);
            prepStmt.setString(2,name);
            prepStmt.setString(3,pwd);
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

	//查询
		public List<Users> searchall() {
			// TODO Auto-generated method stub
			List<Users> all = new ArrayList<Users>() ;
			Connection con=null;
		    PreparedStatement prepStmt=null;
		    ResultSet rs=null;
			try
			{
				con=JDBCTools.getConnection();
	            prepStmt = con.prepareStatement(SEARCHALL_SQL);
	            rs = prepStmt.executeQuery();
				 while (rs.next()){
					 Users user = new Users();
					 user.setId(rs.getInt(1));
					 user.setUsername(rs.getString(2));
					 user.setPassword(rs.getString(3));
					 user.setRole(rs.getInt(4));
					 user.setState(rs.getInt(5));
					 all.add(user);             
		           }
			}catch (Exception e) {
		          // handle exception
		    	  return null;
		      } finally {
		    	 JDBCTools.release(con, prepStmt, rs);
		       }
			return all;
	}
	//注册/添加
	@Override
	public boolean reg(String name, String pwd) {
		// TODO Auto-generated method stub
		Connection con=null;
	    PreparedStatement prepStmt=null;
	    ResultSet rs=null;
	    
	    try {
	    	con=JDBCTools.getConnection();
            prepStmt = con.prepareStatement(INSERT_SQL);
            prepStmt.setString(1,name);
            prepStmt.setString(2,pwd);
            prepStmt.setInt(3, 1); // role：0为管理员，1为用户 
            prepStmt.setInt(4, 1); //state：1为正常，0为封禁
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



}
