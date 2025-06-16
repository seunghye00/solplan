package com.solplan.authservice.dto;

import com.solplan.authservice.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 로그인 응답용 DTO
 * - 사용자 이름과 역할 정보를 포함
 */
@Getter
@AllArgsConstructor
public class UserLoginResponse {
    private String name;
    private Role role;
}