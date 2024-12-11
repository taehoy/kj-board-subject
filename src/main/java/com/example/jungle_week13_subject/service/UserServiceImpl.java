package com.example.jungle_week13_subject.service;

import com.example.jungle_week13_subject.domain.UserJpaEntity;
import com.example.jungle_week13_subject.jwt.JwtUtil;
import com.example.jungle_week13_subject.repository.UserJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserJpaRepository userRepository;
    private final JwtUtil jwtUtil;

    public UserServiceImpl(UserJpaRepository userRepository, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
    }

    @Transactional
    @Override
    public void registerUser(String userId, String password, String nickname) {
        // 유저 ID 중복 체크
        if (userRepository.existsByUserId(userId)) {
            throw new IllegalArgumentException("이미 존재하는 사용자 ID입니다.");
        }

        // 닉네임 중복 체크
        if (userRepository.existsByNickname(nickname)) {
            throw new IllegalArgumentException("이미 존재하는 닉네임입니다.");
        }

        UserJpaEntity user = UserJpaEntity.builder()
                .userId(userId)
                .password(password)
                .nickname(nickname)
                .build();

        userRepository.save(user);

    }

    @Override
    public String login(String userId, String password) {
        // 유저 조회
        Optional<UserJpaEntity> user = userRepository.findByUserId(userId);

        if (user.isEmpty() || !user.get().getPassword().equals(password)) {
            throw new IllegalArgumentException("ID 또는 비밀번호가 잘못되었습니다.");
        }

        // 로그인 성공
        return jwtUtil.generateToken(user.get().getUserId());
    }

}
