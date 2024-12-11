package com.example.jungle_week13_subject.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "posts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;              // 고유 식별자
    @Column(nullable = false)
    private String title;         // 게시글 제목

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;       // 게시글 내용

    @Column(nullable = false)
    private LocalDateTime createdAt; // 작성 시간

    @Column(nullable = false)
    private String authorNickname;  // 작성자 닉네임

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<CommentJpaEntity> comments = new ArrayList<>();
}
