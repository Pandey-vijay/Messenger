package com.example.demo.dao;

import com.example.demo.entity.User;

public interface UserDAO {

	public void addUser(User user);
	public User getUser(int userId);
	public boolean check(int userId);
	public void removeUser(int userId);
	public void updateUserName(int userId,String userName);
	public void updateStatus(int userId,String status);
	public void updateLastSeen(int userId,long lastSeen);
	public void updatePassword(int userId,String pass);
}
