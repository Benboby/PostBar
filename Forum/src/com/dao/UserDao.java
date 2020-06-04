package com.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pojo.Users;

public interface UserDao {
	public Users login(String name,String pwd);//用户查询
	public boolean reg(String name,String pwd);//注册
	public boolean delete(int id, String name, String pwd);//删除
	public boolean update(String name,String pwd,int role,int state,int id);//修改/封号/解封
	public List<Users> searchall();//显示全部用户
}
