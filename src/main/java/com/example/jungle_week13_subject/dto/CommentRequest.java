package com.example.jungle_week13_subject.dto;

import lombok.Data;

@Data
public class CommentRequest {
    private Long postId;
    private String content;
    private String authorNickname;
}
