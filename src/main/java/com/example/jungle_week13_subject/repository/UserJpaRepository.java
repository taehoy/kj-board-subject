package com.example.jungle_week13_subject.repository;

import com.example.jungle_week13_subject.domain.UserJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<UserJpaEntity, Long> {
    boolean existsByUserId(String userId); // 유저 ID 중복 확인용

    boolean existsByNickname(String nickname); // 닉네임 중복 확인

    Optional<UserJpaEntity> findByUserId(String userId); // ID로 사용자 조회

}
