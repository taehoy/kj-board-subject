package com.example.jungle_week13_subject.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 댓글 고유 ID

    @Column(nullable = false)
    private String content; // 댓글 내용

    @Column(nullable = false)
    private String authorNickname; // 댓글 작성자 닉네임

    @Column(nullable = false)
    private LocalDateTime createdAt; // 댓글 작성 시간

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false)
    @JsonBackReference
    private PostJpaEntity post; // 댓글이 속한 게시글
}
