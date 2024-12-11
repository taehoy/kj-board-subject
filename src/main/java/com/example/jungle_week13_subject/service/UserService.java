package com.example.jungle_week13_subject.service;

public interface UserService {
    void registerUser(String userId, String password, String nickname);
    String login(String userId, String password);
}
