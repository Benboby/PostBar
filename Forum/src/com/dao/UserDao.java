package com.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pojo.Users;

public interface UserDao {
	public Users login(String name,String pwd);//�û���ѯ
	public boolean reg(String name,String pwd);//ע��
	public boolean delete(int id, String name, String pwd);//ɾ��
	public boolean update(String name,String pwd,int role,int state,int id);//�޸�/���/���
	public List<Users> searchall();//��ʾȫ���û�
}
