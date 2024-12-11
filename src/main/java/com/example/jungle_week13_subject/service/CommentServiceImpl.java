package com.example.jungle_week13_subject.service;

import com.example.jungle_week13_subject.domain.CommentJpaEntity;
import com.example.jungle_week13_subject.domain.PostJpaEntity;
import com.example.jungle_week13_subject.repository.CommentJpaRepository;
import com.example.jungle_week13_subject.repository.PostJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{
    private final CommentJpaRepository commentJpaRepository;
    private final PostJpaRepository postJpaRepository;

    public CommentServiceImpl(CommentJpaRepository commentJpaRepository, PostJpaRepository postJpaRepository) {
        this.commentJpaRepository = commentJpaRepository;
        this.postJpaRepository = postJpaRepository;
    }

    @Transactional
    @Override
    public CommentJpaEntity createComment(Long postId, String content, String authorNickname) {
        // 게시글 존재 확인
        PostJpaEntity post = postJpaRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("게시글을 찾을 수 없습니다. ID: " + postId));

        // 댓글 생성
        CommentJpaEntity comment = CommentJpaEntity.builder()
                .content(content)
                .authorNickname(authorNickname)
                .createdAt(LocalDateTime.now())
                .post(post)
                .build();

        return commentJpaRepository.save(comment);
    }

    @Transactional
    @Override
    public List<CommentJpaEntity> getCommentsByPostId(Long postId) {
        return commentJpaRepository.findByPostId(postId);
    }

    @Transactional
    @Override
    public void deleteComment(Long commentId) {
        if (!commentJpaRepository.existsById(commentId)) {
            throw new IllegalArgumentException("댓글을 찾을 수 없습니다. ID: " + commentId);
        }
        commentJpaRepository.deleteById(commentId);
    }
}
