package com.solplan.authservice.service;

import com.solplan.authservice.domain.Role;
import com.solplan.authservice.domain.User;
import com.solplan.authservice.dto.UserJoinRequest;
import com.solplan.authservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import java.time.LocalDateTime;
import org.springframework.stereotype.Service;

/**
 *  회원가입 처리 로직
 */
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    // 회원가입 처리 메서드
    public void register(UserJoinRequest dto) {
        User user = User.builder()
                .userId(dto.getUserId())
                .pwd(dto.getPwd())
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
}