package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.example.demo.entity.Message;

public interface MessageDAO {

	public void addMessage(Message message);
	public Message getMessage(int userId,int MessageId);
	public List<Message> getAllMessage(int userId);
	public void setNew(int userId,boolean isNew);
	public boolean getNew(int userId);
}
