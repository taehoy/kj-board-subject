package com.example.jungle_week13_subject.controller;

import com.example.jungle_week13_subject.domain.RegisterUserRequest;
import com.example.jungle_week13_subject.dto.LoginRequest;
import com.example.jungle_week13_subject.dto.LoginResponse;
import com.example.jungle_week13_subject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody RegisterUserRequest request) {
        try {
            userService.registerUser(request.getUserId(), request.getPassword(), request.getNickname());
            return ResponseEntity.ok("회원가입이 성공적으로 완료되었습니다.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginUser(@RequestBody LoginRequest request) {
        try {
            LoginResponse response = userService.login(request.getUserId(), request.getPassword());
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(LoginResponse.builder()
                    .message(e.getMessage())
                    .build());
        }
    }
}
