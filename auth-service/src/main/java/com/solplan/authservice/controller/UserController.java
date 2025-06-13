package com.solplan.authservice.controller;

import com.solplan.authservice.dto.UserJoinRequest;
import com.solplan.authservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    // 회원가입 API
    @PostMapping("/signup")
    public ResponseEntity<String> register(@RequestBody UserJoinRequest dto) {
        userService.register(dto);
        return ResponseEntity.ok("회원가입 성공!");
    }
}