package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import com.example.demo.dao.UserDAO;
import com.example.demo.entity.User;

public class UserController implements UserDAO {
	
	Map<Integer,User> users = new HashMap<Integer, User>() ;
	
	
	@Override
	public void addUser(User user) {
		users.put(user.getUserId(), user);
	}

	@Override
	public User getUser(int userId) {
		return users.get(userId);
	}

	@Override
	public void removeUser(int userId) {
		User user = users.get(userId);
		users.remove(user.getUserId());
		
	}

	@Override
	public void updateUserName(int userId, String userName) {
		User user = users.get(userId);
		user.setUserName(userName);
		
	}

	@Override
	public void updateStatus(int userId, String status) {
		User user = users.get(userId);
		user.setStatus(status);
		
	}

	@Override
	public void updateLastSeen(int userId, long lastSeen) {
		User user = users.get(userId);
		user.setLastSeen(lastSeen);
		
	}

	@Override
	public void updatePassword(int userId, String pass) {
		User user = users.get(userId);
		user.setPass(pass);
		
	}
	
	
}
