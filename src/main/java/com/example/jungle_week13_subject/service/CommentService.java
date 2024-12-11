package com.example.jungle_week13_subject.service;

import com.example.jungle_week13_subject.domain.CommentJpaEntity;

import java.util.List;

public interface CommentService {
    CommentJpaEntity createComment(Long postId, String content, String authorNickname);
    List<CommentJpaEntity> getCommentsByPostId(Long postId);
    void deleteComment(Long commentId);

}
