package com.example.demo.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MessageDAO;
import com.example.demo.entity.Message;

@Service
public class MessageService{
	@Autowired
	MessageDAO messageDao;

	public void addMessage(Message message) {
		messageDao.addMessage(message);
	}

	public Message getMessage(int userId, int MessageId) {
		return messageDao.getMessage(userId, MessageId);
	}

	public List<Message> getAllMessage(int userId) {
		return messageDao.getAllMessage(userId);
	}

	public void setNew(int userId, boolean isNew) {
		messageDao.setNew(userId,isNew);
	}

	public boolean getNew(int userId) {
		return messageDao.getNew(userId);
	}

}
