package com.example.demo.service;

import com.example.demo.controller.AuthInfoController;
import com.example.demo.dao.AuthInfoDao;
import com.example.demo.entity.AuthInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;
@Component
public class AuthInfoService {
    @Autowired
    AuthInfoController authInfoController;

    public AuthInfo addAuth(int userId) {
        return authInfoController.addAuth(userId);
    }

    public boolean checkAuth(int userId, UUID authId) {
        return authInfoController.checkAuth(userId,authId);
    }

    public AuthInfo updateAuth(int userId) {
        return authInfoController.updateAuth(userId);
    }
}
