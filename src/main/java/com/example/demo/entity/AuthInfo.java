package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
@Entity (name = "auth_info")
@Table (name = "auth_info")
public class AuthInfo {
	@Id
	@Column(name = "user_id") int userId;
	@Column (name = "auth_id")
	String authId = UUID.randomUUID().toString();
	@Column (name = "time_stamp")
	long timeStamp = System.currentTimeMillis();

	public AuthInfo(int userId){
		this.userId = userId;
	}

	public AuthInfo() {
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public int getUserId() {
		return userId;
	}

	public UUID getAuthId() {
		return UUID.fromString(authId);
	}

	public void setAuthId(UUID authId) {
		this.authId = authId.toString();
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "AuthInfo{" +
				"userId=" + userId +
				", authId='" + authId + '\'' +
				", timeStamp=" + timeStamp +
				'}';
	}
}
