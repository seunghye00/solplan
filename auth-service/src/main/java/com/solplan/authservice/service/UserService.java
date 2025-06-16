package com.solplan.authservice.service;

import com.solplan.authservice.domain.Role;
import com.solplan.authservice.domain.User;
import com.solplan.authservice.dto.UserJoinRequest;
import com.solplan.authservice.dto.UserLoginRequest;
import com.solplan.authservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * 회원가입 처리 로직
 */
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    // 회원가입 처리 메서드
    public void signup(UserJoinRequest dto) {

        if (userRepository.existsByUserId(dto.getUserId())) {
            throw new IllegalArgumentException("이미 사용 중인 아이디입니다.");
        }

        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new IllegalArgumentException("이미 사용 중인 이메일입니다.");
        }

        User user = User.builder()
                .userId(dto.getUserId())
                .pwd(passwordEncoder.encode(dto.getPwd())) // 암호화
                .email(dto.getEmail())
                .name(dto.getName())
                .addr(dto.getAddr())
                .phone(dto.getPhone())
                .ssn(dto.getSsn())
                .role(Role.USER)
                .regDate(LocalDateTime.now())
                .build();

        userRepository.save(user);
    }

    // 로그인 처리 메서드
    public User login(UserLoginRequest dto) {
        User user = userRepository.findByUserId(dto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 아이디입니다."));

        if (!passwordEncoder.matches(dto.getPwd(), user.getPwd())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        return user;
    }
}