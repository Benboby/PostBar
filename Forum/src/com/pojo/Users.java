package com.pojo;

public class Users {
    private int id;          // 用户id
    private String username;     //用户账号
    private String password;     // 密码
    private int role;             // role：0为管理员，1为用户  
    private int state;            // state：1为正常，0为封禁



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}
    
}
