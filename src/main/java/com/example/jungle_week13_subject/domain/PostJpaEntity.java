package com.example.jungle_week13_subject.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class PostJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;              // 고유 식별자
    private String title;         // 게시글 제목
    private String content;       // 게시글 내용
    private LocalDateTime createdAt; // 게시일자
    private String authorNickname;  // 작성자 닉네임
}
