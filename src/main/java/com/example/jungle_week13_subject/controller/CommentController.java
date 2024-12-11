package com.example.jungle_week13_subject.controller;

import com.example.jungle_week13_subject.domain.CommentJpaEntity;
import com.example.jungle_week13_subject.dto.CommentRequest;
import com.example.jungle_week13_subject.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
    // 댓글 작성
    @PostMapping
    public ResponseEntity<CommentJpaEntity> createComment(@RequestBody CommentRequest request) {
        CommentJpaEntity comment = commentService.createComment(
                request.getPostId(),
                request.getContent(),
                request.getAuthorNickname()
        );
        return ResponseEntity.ok(comment);
    }

    // 특정 게시글의 댓글 조회
    @GetMapping("/post/{postId}")
    public ResponseEntity<List<CommentJpaEntity>> getCommentsByPostId(@PathVariable Long postId) {
        return ResponseEntity.ok(commentService.getCommentsByPostId(postId));
    }

    // 댓글 삭제
    @DeleteMapping("/{commentId}")
    public ResponseEntity<String> deleteComment(@PathVariable Long commentId) {
        commentService.deleteComment(commentId);
        return ResponseEntity.ok("댓글이 삭제되었습니다.");
    }
}
