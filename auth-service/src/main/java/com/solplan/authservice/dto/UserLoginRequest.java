package com.solplan.authservice.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * 로그인 요청 시 사용자 아이디와 비밀번호를 전달받는 DTO
 */
@Getter
@Setter
public class UserLoginRequest {
    private String userId;
    private String pwd;
}