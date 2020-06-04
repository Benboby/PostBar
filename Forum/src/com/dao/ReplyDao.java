package com.dao;
import com.pojo.Reply;

import java.util.Date;
import java.util.List;

public interface ReplyDao {
    Reply reply=new Reply();
    public boolean delete(int p_id,int u_id);//删除回复
    public boolean add(Reply reply);//添加回复
    public List<Reply> searchall();//查询全部回复
}
