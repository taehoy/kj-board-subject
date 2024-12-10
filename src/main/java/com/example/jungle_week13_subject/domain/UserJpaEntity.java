package com.example.jungle_week13_subject.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;          // 고유 식별자
    private String userId;    // 로그인 ID
    private String password;  // 비밀번호
    private String nickname;  // 닉네임

    public UserJpaEntity() {
    }

}
