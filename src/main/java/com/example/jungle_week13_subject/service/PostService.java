package com.example.jungle_week13_subject.service;

import com.example.jungle_week13_subject.domain.PostJpaEntity;

import java.util.List;

public interface PostService {
    PostJpaEntity createPost(String title, String content, String authorNickname);
    List<PostJpaEntity> getAllPosts();
    PostJpaEntity getPostById(Long id);
    PostJpaEntity updatePost(Long id, String title, String content);
    void deletePost(Long id);

}
