package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "user")
@Table(name = "user")
public class User {
	@Id
	@Column(name = "user_id")
	private int userId;
	@Column(name = "user_name")
	private String userName;
	@Column(name = "password")
	private String password;
	@Column(name = "status")
	private String status = "Hello There";
	@Column(name = "last_seen")
	private long lastSeen = System.currentTimeMillis();

	public User(){
		
	}


	public User(int userId, String userName, String password) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
	}

	public User(int userId, String userName, String password, String status, long lastSeen) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.status = status;
		this.lastSeen = lastSeen;
	}

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
				"\n User Name : "+ getUserName();
	}
	
	
}
