package com.dao;
import java.util.Date;

import java.util.List;
import com.pojo.Post;

public interface PostDao {
	public Post findPost(int p_id);//查找
	//更新
	public boolean update(String p_title,String p_text,String filetitle,String filecontent, Date p_time,String filepath,int p_id);
	public boolean state(int p_id,int state);//封贴，解封
	Post post=new Post();
	public boolean delete(int p_id,int u_id);//删除帖子
	public boolean add(Post post);//添加帖子
	public List<Post> searchall();//查询全部
}
