package com.example.jungle_week13_subject.jwt;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class JwtAuthenticationToken extends AbstractAuthenticationToken {

    private final Object principal; // 사용자 정보 (예: UserDetails)
    private Object credentials;     // 인증 토큰 (일반적으로 JWT)

    public JwtAuthenticationToken(Object principal, Object credentials) {
        super(null); // 권한이 설정되지 않은 초기 상태
        this.principal = principal;
        this.credentials = credentials;
        setAuthenticated(false); // 초기에는 인증되지 않은 상태로 설정
    }

    public JwtAuthenticationToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
        super(authorities); // 권한 설정
        this.principal = principal;
        this.credentials = credentials;
        setAuthenticated(true); // 인증된 상태로 설정
    }

    @Override
    public Object getCredentials() {
        return credentials;
    }

    @Override
    public Object getPrincipal() {
        return principal;
    }

    @Override
    public void eraseCredentials() {
        super.eraseCredentials();
        credentials = null; // 자격 증명 제거
    }
}
