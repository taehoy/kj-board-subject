package com.example.jungle_week13_subject.service;

import com.example.jungle_week13_subject.domain.PostJpaEntity;
import com.example.jungle_week13_subject.repository.PostJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostServiceImpl implements PostService{
    private final PostJpaRepository postRepository;

    public PostServiceImpl(PostJpaRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Transactional
    @Override
    public PostJpaEntity createPost(String title, String content, String authorNickname) {
        PostJpaEntity post = PostJpaEntity.builder()
                .title(title)
                .content(content)
                .authorNickname(authorNickname)
                .createdAt(LocalDateTime.now())
                .build();
        return postRepository.save(post);
    }

    @Transactional(readOnly = true)
    @Override
    public List<PostJpaEntity> getAllPosts() {
        return postRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public PostJpaEntity getPostById(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("게시글을 찾을 수 없습니다. ID: " + id));
    }

    @Transactional
    @Override
    public PostJpaEntity updatePost(Long id, String title, String content) {
        PostJpaEntity post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("게시글을 찾을 수 없습니다. ID: " + id));

        post.setTitle(title);
        post.setContent(content);
        return postRepository.save(post);
    }

    @Transactional
    @Override
    public void deletePost(Long id) {
        if (!postRepository.existsById(id)) {
            throw new IllegalArgumentException("게시글을 찾을 수 없습니다. ID: " + id);
        }
        postRepository.deleteById(id);
    }
}
