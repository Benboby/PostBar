package com.pojo;
import java.util.Date;

public class Post {
	private int p_id;
	private int u_id;
	private String u_name;
	private String p_title;
	private String p_text;
	private String filetitle;
	private String filecontent;//文件类型
	private java.sql.Date p_time;
	private int p_state;//状态：封贴解封
	private String filepath;//文件路径

	public int getP_id() {
		return p_id;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getP_title() {
		return p_title;
	}
	public void setP_title(String p_title) {
		this.p_title = p_title;
	}
	public String getP_text() {
		return p_text;
	}
	public void setP_text(String p_text) {
		this.p_text = p_text;
	}
	public String getFiletitle() {
		return filetitle;
	}
	public void setFiletitle(String filetitle) {
		this.filetitle = filetitle;
	}
	public String getFilecontent() {
		return filecontent;
	}
	public void setFilecontent(String filecontent) {
		this.filecontent = filecontent;
	}
	public java.sql.Date getP_time() {
		return p_time;
	}
	public void setP_time(Date p_time) {
		this.p_time = (java.sql.Date) p_time;
	}
	public int getP_state() {
		return p_state;
	}
	public void setP_state(int p_state) {
		this.p_state = p_state;
	}

}
