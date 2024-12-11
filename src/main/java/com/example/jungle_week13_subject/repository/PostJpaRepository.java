package com.example.jungle_week13_subject.repository;

import com.example.jungle_week13_subject.domain.PostJpaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostJpaRepository extends JpaRepository<PostJpaEntity, Long> {
    // 페이징 지원
}
