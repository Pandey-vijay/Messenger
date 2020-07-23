package com.example.demo.dao;

import com.example.demo.entity.AuthInfo;

import java.util.UUID;

public interface AuthInfoDao {
    AuthInfo addAuth(int userId);
    AuthInfo updateAuth(int userId);
    boolean checkAuth(int userId,UUID authId);
}
