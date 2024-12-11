package com.example.jungle_week13_subject.dto;

import lombok.Data;

@Data
public class PostRequest {
    private String title;
    private String content;
    private String authorNickname;
}
