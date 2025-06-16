package com.solplan.authservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Spring Security 설정 클래스
 * 현재는 인증/인가 없이 모든 요청을 허용하고, CSRF 보호를 비활성화
 * 비밀번호 암호화를 위한 BCryptPasswordEncoder Bean도 함께 등록
 */
@Configuration
public class SecurityConfig {

    /**
     * SecurityFilterChain Bean 설정
     * - Spring Security 필터 체인을 구성
     * - 현재는 모든 HTTP 요청을 인증 없이 허용하며, CSRF 보호는 비활성화
     *
     * @param http Spring Security HTTP 보안 설정 객체
     * @return SecurityFilterChain 객체
     * @throws Exception 설정 중 예외 발생 시
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // CSRF 보안 비활성화 (API 테스트용)
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll() // 모든 요청 인증 없이 허용
                );
        return http.build();
    }

    /**
     * BCryptPasswordEncoder Bean 등록
     * - 비밀번호를 안전하게 암호화하기 위해 사용하는 인코더입니다.
     * - 회원가입 시 사용자의 비밀번호를 암호화하는 데 사용됩니다.
     *
     * @return BCryptPasswordEncoder 인스턴스
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}