package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;
import com.example.demo.dao.MessageDAO;
import com.example.demo.entity.Message;

public class MessageController implements MessageDAO {


	Map<Integer,HashMap<Integer, Message>> messagesStack = new HashMap<Integer, HashMap<Integer,Message>>();
	Map<Integer,Message> messages;
	//Store UserId and Is there new message
	Map<Integer,Boolean> hasNewMessage = new HashMap<Integer, Boolean>();
	@Override
	public void addMessage(Message message) {
		
		message.setSendtime(System.currentTimeMillis());
		
		if(messagesStack.containsKey(message.getRecevierId())){
			//Get the Message stack for user
			messages = messagesStack.get(message.getRecevierId());
			//Put Message into Message Stack
			messages.put(message.getMessageId(), message);
		}
		else {
			messagesStack.put(message.getRecevierId(), new HashMap<Integer, Message>());
			messagesStack.get(message.getRecevierId()).put(message.getMessageId(), message);
		}
			
	}

	@Override
	public Message getMessage(int userId,int MessageId) {
		return messagesStack.get(userId).get(MessageId);
		
	}

	@Override
	public Map<Integer, Message> getAllMessage(int userId) {
		Map<Integer,Message> messages = messagesStack.get(userId);
		return messagesStack.get(userId);
	}

	@Override
	public void setNew(int userId,boolean isNew) {
		hasNewMessage.put(userId,isNew);
	}

	@Override
	public boolean getNew(int userId) {
		return hasNewMessage.get(userId);
	}


}
