package com.example.demo.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class AuthInfo {
	
	Map<Integer,UUID> authData = new HashMap<Integer,UUID>();
	
	public boolean checkAuth(int userId,UUID authId) {
		
		System.out.println(authData.get(userId)+" "+authId);
		System.out.print(authData.get(userId) == authId);
		if(authData.get(userId).equals(authId)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void addAuth(int userId,UUID authId) {
		authData.put(userId, authId);
	}
	
}
