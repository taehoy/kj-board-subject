package com.example.jungle_week13_subject.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class UserJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;          // 고유 식별자

    @Column(nullable = false, unique = true)
    private String userId; // 로그인 ID

    @Column(nullable = false)
    private String password; // 비밀번호

    @Column(nullable = false)
    private String nickname; // 닉네임

    public UserJpaEntity makeUserJpaEntity(String userId, String password, String nickname){
        this.userId = userId;
        this.password = password;
        this.nickname = nickname;

        return this;
    }

}
