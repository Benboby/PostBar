package com.dao;
import com.pojo.Reply;

import java.util.Date;
import java.util.List;

public interface ReplyDao {
    Reply reply=new Reply();
    public boolean delete(int p_id,int u_id);//ɾ���ظ�
    public boolean add(Reply reply);//��ӻظ�
    public List<Reply> searchall();//��ѯȫ���ظ�
}
