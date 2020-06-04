package com.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.dao.ReplyDao;
import com.db.JDBCTools;
import com.pojo.Reply;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReplyDaoImpl implements ReplyDao {
    protected static String INSERT_SQL="insert into pb_reply(u_id, p_id, u_name, u_reply, r_state) values(?,?,?,?,?)";
    protected static String DELETE_SQL="delete from pb_reply where r_id=? and u_id=?";
    protected static String SEARCHALL_SQL="select * from pb_reply";

    // 删除
    public boolean delete(int r_id ,int u_id) {
        // TODO Auto-generated method stub
        Connection con=null;
        PreparedStatement prepStmt=null;
        ResultSet rs=null;

        try {
            con=JDBCTools.getConnection();
            prepStmt = con.prepareStatement(DELETE_SQL);
            prepStmt.setInt(1,r_id);
            prepStmt.setInt(2,u_id);
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

    //添加
    public boolean add(Reply reply) {
        // TODO Auto-generated method stub
        Connection con=null;
        PreparedStatement prepStmt=null;
        ResultSet rs=null;

        try {
            con=JDBCTools.getConnection();
            prepStmt = con.prepareStatement(INSERT_SQL);
            prepStmt.setInt(1,reply.getU_id());
            prepStmt.setInt(2,reply.getP_id());
            prepStmt.setString(3,reply.getU_name());
            prepStmt.setString(4,reply.getU_reply());
            prepStmt.setInt(5,reply.getR_state());
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
    public List<Reply> searchall() {
        // TODO Auto-generated method stub
        List<Reply> all = new ArrayList<Reply>() ;
        Connection con=null;
        PreparedStatement prepStmt=null;
        ResultSet rs=null;
        try
        {
            con=JDBCTools.getConnection();
            prepStmt = con.prepareStatement(SEARCHALL_SQL);
            rs = prepStmt.executeQuery();
            while (rs.next()){
                Reply reply = new Reply();
                reply.setR_id(rs.getInt(1));
                reply.setU_id(rs.getInt(2));
                reply.setP_id(rs.getInt(3));
                reply.setU_name(rs.getString(4));
                reply.setU_reply(rs.getString(5));
                reply.setR_state(rs.getInt(6));
                all.add(reply);
            }
        }catch (Exception e) {
            // handle exception
            return null;
        } finally {
            JDBCTools.release(con, prepStmt, rs);
        }
        return all;
    }
}
