package com.example.jungle_week13_subject.repository;

import com.example.jungle_week13_subject.domain.CommentJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentJpaRepository extends JpaRepository<CommentJpaEntity, Long> {
    // 특정 게시글 댓글 조회
    List<CommentJpaEntity> findByPostId(Long postId);
}
