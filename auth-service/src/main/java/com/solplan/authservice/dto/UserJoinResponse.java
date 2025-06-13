package com.solplan.authservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 회원가입 응답 정보를 담는 DTO 클래스
 */
@Getter
@AllArgsConstructor
public class UserJoinResponse {

    private Long id;       // 사용자 고유 ID
    private String userId; // 사용자 아이디
}