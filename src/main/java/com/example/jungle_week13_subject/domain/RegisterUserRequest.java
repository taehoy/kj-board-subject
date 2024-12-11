package com.example.jungle_week13_subject.domain;

import lombok.Data;

@Data
public class RegisterUserRequest {
    private String userId;
    private String password;
    private String nickname;
}
