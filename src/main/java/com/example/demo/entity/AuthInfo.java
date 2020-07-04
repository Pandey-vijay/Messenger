package com.example.demo.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class AuthInfo {
	int userId;
	UUID authId;
	long timeStamp;

	public AuthInfo(int userId,UUID authId,long timeStamp){
		this.userId = userId;
		this.authId = authId;
		this.timeStamp = timeStamp;
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
		return authId;
	}

	public void setAuthId(UUID authId) {
		this.authId = authId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
}
