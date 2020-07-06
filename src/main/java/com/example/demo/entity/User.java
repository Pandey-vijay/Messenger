package com.example.demo.entity;


public class User {

	private int userId;
	private String userName,password,status="Hello there";
	private long lastSeen;
	
	public int getUserId() {
		return userId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public long getLastSeen() {
		return lastSeen;
	}
	public void setLastSeen(long lastSeen) {
		this.lastSeen = lastSeen;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String pass) {
		this.password = pass;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "User Id "+getUserId()+" " +
				"\n User Name : "+ getPassword();
	}
	
	
}
