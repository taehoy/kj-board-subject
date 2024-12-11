package com.example.jungle_week13_subject.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponse {
    private String userId;
    private String nickname;
    private String message;
}
