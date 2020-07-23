package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import com.example.demo.dao.UserDAO;
import com.example.demo.entity.Message;
import com.example.demo.entity.User;
import com.example.demo.service.DataBaseService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.persistence.Query;


public class UserController implements UserDAO {

	@Autowired
	DataBaseService dataBaseService;
	//Map<Integer,User> users = new HashMap();
	@Override
	public void addUser(User user) {
		Session session = dataBaseService.createNewSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public User getUser(int userId) {
		Session session = dataBaseService.createNewSession();
		session.beginTransaction();
		User user = session.get(User.class,userId);
		session.close();
		return user;
	}

	@Override
	public boolean check(int userId) {
		Session session = dataBaseService.createNewSession();
		session.beginTransaction();
		Query query = session.createQuery("select count(user_id) from user where user_id = :userId");
		query.setParameter("userId",userId);
		int i = Integer.parseInt(query.getSingleResult().toString());
		session.close();
		if(i == 1)
			 return true;
		else
			return false;
	}

	@Override
	public void removeUser(int userId) {
		Session session = dataBaseService.createNewSession();
		session.beginTransaction();
		Query query = session.createQuery("delete from user where user_id = :user_id");
		query.setParameter("user_id",userId);
		query.executeUpdate();
		session.close();

	}

	@Override
	public void updateUserName(int userId, String userName) {
		Session session = dataBaseService.createNewSession();
		session.beginTransaction();
		Query query = session.createQuery("update user set user_name = :user_name where user_id = :user_id");
		query.setParameter("user_id",userId);
		query.setParameter("user_name",userName);
		query.executeUpdate();
		session.close();

	}

	@Override
	public void updateStatus(int userId, String status) {
		Session session = dataBaseService.createNewSession();
		session.beginTransaction();
		Query query = session.createQuery("update user set status = :user_status where user_id = :user_id");
		query.setParameter("user_id",userId);
		query.setParameter("user_status",status);
		query.executeUpdate();
		session.close();

	}

	@Override
	public void updateLastSeen(int userId, long lastSeen) {
		Session session = dataBaseService.createNewSession();
		session.beginTransaction();
		Query query = session.createQuery("update user set last_seen = :last_seen where user_id = :user_id");
		query.setParameter("user_id",userId);
		query.setParameter("last_seen",lastSeen);
		query.executeUpdate();
		session.close();

	}

	@Override
	public void updatePassword(int userId, String pass) {
		Session session = dataBaseService.createNewSession();
		session.beginTransaction();
		Query query = session.createQuery("update user set password = :password where user_id = :user_id");
		query.setParameter("user_id",userId);
		query.setParameter("password",pass);
		query.executeUpdate();
		session.close();

	}


}
