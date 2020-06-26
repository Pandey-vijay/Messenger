package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDAO;
import com.example.demo.entity.User;

@Service
public class UserService{

	private final UserDAO userDAO;
	
	public UserService(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public void addUser(User user) {
		userDAO.addUser(user);
		
	}

	public User getUser(int userId) {
		return userDAO.getUser(userId);
	}

	public void removeUser(int userId) {
		userDAO.removeUser(userId);
		
	}

	public void updateUserName(int userId, String userName) {
		userDAO.updateUserName(userId, userName);
		
	}

	public void updateStatus(int userId, String status) {
		userDAO.updateStatus(userId, status);
		
	}

	public void updateLastSeen(int userId, long lastSeen) {
		userDAO.updateLastSeen(userId, lastSeen);
		
	}

	public void updatePassword(int userId, String pass) {
		userDAO.updatePassword(userId, pass);
	}

}
