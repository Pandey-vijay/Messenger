package com.example.demo.dao;

import java.util.Map;

import com.example.demo.entity.Message;

public interface MessageDAO {

	public void addMessage(Message message);
	public Message getMessage(int userId,int MessageId);
	public Map<Integer, Message> getAllMessage(int userId);

}
