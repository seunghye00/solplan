package com.solplan.authservice.controller;

import com.solplan.authservice.domain.User;
import com.solplan.authservice.service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * UserController
 *
 * - 사용자 관련 HTTP 요청을 처리하는 컨트롤러
 * - 회원가입, 로그인, 사용자 정보 조회 등 API 엔드포인트 정의
 */
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor // UserService 자동 주입
public class UserController {

    private final UserService userService;

    /**
     * 회원가입 API
     * POST /api/users/register
     *
     * @param request 클라이언트로부터 받은 회원가입 정보
     * @return 생성된 사용자 정보
     */
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody RegisterRequest request) {
        User user = userService.register(
                request.getUserId(),
                request.getPwd(),
                request.getEmail(),
                request.getName(),
                request.getAddr(),
                request.getPhone(),
                request.getSsn()
        );
        return ResponseEntity.ok(user);
    }

    /**
     * 회원가입 요청을 담는 DTO 클래스
     */
    @Data
    public static class RegisterRequest {
        private String userId;
        private String pwd;
        private String email;
        private String name;
        private String addr;
        private String phone;
        private String ssn;
    }
}