package com.example.demo.controller;

import com.example.demo.dao.AuthInfoDao;
import com.example.demo.entity.AuthInfo;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class AuthInfoController implements AuthInfoDao {

    Map<Integer,AuthInfo> authInfos = new HashMap<Integer, AuthInfo>();

    @Override
    public AuthInfo addAuth(int userId, UUID authId) {
        authInfos.put(userId,new AuthInfo(userId,authId,System.currentTimeMillis()));
        return authInfos.get(userId);
    }

    @Override
    public boolean checkAuth(int userId, UUID authId) {
        return false;
    }
}
