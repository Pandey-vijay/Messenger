package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.example.demo.dao.MessageDAO;
import com.example.demo.entity.Message;
import com.example.demo.service.DataBaseService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Query;

public class MessageController implements MessageDAO {

	@Autowired
	DataBaseService dataBaseService;
	Map<Integer,Boolean> hasNewMessage = new HashMap<Integer, Boolean>();
	@Override
	public int addMessage(Message message) {
		Session session= dataBaseService.createNewSession();
		session.beginTransaction();
		session.save(message);
		System.out.println(message);
		session.getTransaction().commit();
		session.close();
		return message.getMessageId();
	}

	@Override
	public Message getMessage(int userId,int messageId) {
		Session session= dataBaseService.createNewSession();
		session.beginTransaction();
		Query q = session.createQuery("from message where recevier_id = :userId AND message_id = :messageId");
		q.setParameter("userId",userId);
		q.setParameter("messageId",messageId);
		Message message = (Message) q.getSingleResult();
		session.close();
		return message;
		
	}

	@Override
	public List<Message> getAllMessage(int userId) {
		Session session= dataBaseService.createNewSession();
		session.beginTransaction();
		Query q = session.createQuery("from message where recevier_id = :userId AND recTime = 0 ");
		q.setParameter("userId",userId);
		List<Message> messages = q.getResultList();
		q = session.createQuery("update message set rec_time = :recTime where recevier_id = :recevierId and rec_time = 0");
		q.setParameter("recTime" , System.currentTimeMillis());
		q.setParameter("recevierId",userId);
		q.executeUpdate();
		session.close();
		System.out.println(messages);
		return messages;
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
