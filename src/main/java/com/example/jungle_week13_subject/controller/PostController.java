package com.example.jungle_week13_subject.controller;

import com.example.jungle_week13_subject.domain.PostJpaEntity;
import com.example.jungle_week13_subject.dto.PostRequest;
import com.example.jungle_week13_subject.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    //create
    @PostMapping
    public ResponseEntity<PostJpaEntity> createPost(@RequestBody PostRequest request) {
        PostJpaEntity post = postService.createPost(request.getTitle(), request.getContent(), request.getAuthorNickname());
        return ResponseEntity.ok(post);
    }

    // Read (전체 조회)
    @GetMapping
    public ResponseEntity<List<PostJpaEntity>> getAllPosts() {
        return ResponseEntity.ok(postService.getAllPosts());
    }

    // Read (단일 조회)
    @GetMapping("/{id}")
    public ResponseEntity<PostJpaEntity> getPostById(@PathVariable Long id) {
        return ResponseEntity.ok(postService.getPostById(id));
    }

    // Update
    @PostMapping("/{id}")
    public ResponseEntity<PostJpaEntity> updatePost(@PathVariable Long id, @RequestBody PostRequest request) {
        PostJpaEntity updatedPost = postService.updatePost(id, request.getTitle(), request.getContent());
        return ResponseEntity.ok(updatedPost);
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return ResponseEntity.ok("게시글이 삭제되었습니다.");
    }

}
