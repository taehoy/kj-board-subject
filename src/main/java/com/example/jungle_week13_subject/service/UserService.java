package com.example.jungle_week13_subject.service;

import com.example.jungle_week13_subject.dto.LoginResponse;

public interface UserService {
    void registerUser(String userId, String password, String nickname);
    LoginResponse login(String userId, String password);
}
