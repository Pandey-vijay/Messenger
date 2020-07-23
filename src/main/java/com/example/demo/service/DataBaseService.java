package com.example.demo.service;

import com.example.demo.entity.AuthInfo;
import com.example.demo.entity.Message;
import com.example.demo.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

@Component
public class DataBaseService {

    SessionFactory sessionFactory;
    Session session;

    DataBaseService(){
        try{
            sessionFactory = new Configuration()
                    .configure("hibernate/hibernate.cfg.xml")
                    .addAnnotatedClass(User.class)
                    .addAnnotatedClass(Message.class)
                    .addAnnotatedClass(AuthInfo.class)
                    .buildSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(new User(1,"vijay","12345"));
            session.getTransaction().commit();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public Session createNewSession(){
        return sessionFactory.openSession();
    }

}
