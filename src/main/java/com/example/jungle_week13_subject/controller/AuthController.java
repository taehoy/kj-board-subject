package com.example.jungle_week13_subject.controller;

import com.example.jungle_week13_subject.dto.LoginRequest;
import com.example.jungle_week13_subject.dto.LoginResponse;
import com.example.jungle_week13_subject.jwt.JwtUtil;
import com.example.jungle_week13_subject.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    // 로그인
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        String token = userService.login(request.getUserId(), request.getPassword());
        return ResponseEntity.ok(new LoginResponse(token));
    }

}
