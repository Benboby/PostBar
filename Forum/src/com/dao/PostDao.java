package com.dao;
import java.util.Date;

import java.util.List;
import com.pojo.Post;

public interface PostDao {
	public Post findPost(int p_id);//����
	//����
	public boolean update(String p_title,String p_text,String filetitle,String filecontent, Date p_time,String filepath,int p_id);
	public boolean state(int p_id,int state);//���������
	Post post=new Post();
	public boolean delete(int p_id,int u_id);//ɾ������
	public boolean add(Post post);//�������
	public List<Post> searchall();//��ѯȫ��
}
