package com.example.demo.controller;

import com.example.demo.dao.AuthInfoDao;
import com.example.demo.entity.AuthInfo;
import com.example.demo.entity.User;
import com.example.demo.service.DataBaseService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Query;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class AuthInfoController implements AuthInfoDao {

    @Autowired
    DataBaseService dataBaseService;

    @Override
    public AuthInfo addAuth(int userId) {
        AuthInfo authInfo = new AuthInfo(userId);
        try{
            Session session = dataBaseService.createNewSession();
            session.beginTransaction();
            session.save(authInfo);
            session.getTransaction().commit();
            session.close();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return authInfo;
    }

    @Override
    public boolean checkAuth(int userId, UUID authId) {
        return false;
    }

    @Override
    public AuthInfo updateAuth(int userId) {
        AuthInfo authInfo;
        Session session = dataBaseService.createNewSession();
        session.beginTransaction();
        Query query = session.createQuery("update auth_info set auth_id = :authId , time_stamp = :timeStamp where user_id = :userId ");
        query.setParameter("authId",UUID.randomUUID().toString());
        query.setParameter("timeStamp",System.currentTimeMillis());
        query.setParameter("userId",userId);
        query.executeUpdate();
        session.getTransaction().commit();
        authInfo = session.get(AuthInfo.class,userId);
        session.close();
        return authInfo;
    }
}
