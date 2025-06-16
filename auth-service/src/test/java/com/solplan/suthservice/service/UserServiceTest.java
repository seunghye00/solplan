package com.solplan.suthservice.service;

import com.solplan.authservice.domain.Role;
import com.solplan.authservice.domain.User;
import com.solplan.authservice.dto.UserJoinRequest;
import com.solplan.authservice.dto.UserLoginRequest;
import com.solplan.authservice.repository.UserRepository;
import com.solplan.authservice.service.UserService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest(classes = com.solplan.authservice.AuthServiceApplication.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserServiceTest {

    @Autowired private UserService userService;
    @Autowired private UserRepository userRepository;
    @Autowired private BCryptPasswordEncoder passwordEncoder;

    @Test
    @Order(1)
    void 회원가입_성공() {
        UserJoinRequest req = new UserJoinRequest();
        req.setUserId("junituser");
        req.setPwd("1234");
        req.setEmail("junit@test.com");
        req.setName("테스트");
        req.setAddr("서울");
        req.setPhone("01012345678");
        req.setSsn("900101-1234567");

        userService.signup(req);

        User user = userRepository.findByUserId("junituser").orElseThrow();
        assertThat(user.getEmail()).isEqualTo("junit@test.com");
        assertThat(passwordEncoder.matches("1234", user.getPwd())).isTrue();
        assertThat(user.getRole()).isEqualTo(Role.USER);
    }

    @Test
    @Order(2)
    void 로그인_성공() {
        UserLoginRequest login = new UserLoginRequest();
        login.setUserId("junituser");
        login.setPwd("1234");

        User user = userService.login(login);
        assertThat(user.getName()).isEqualTo("테스트");
    }

    @Test
    @Order(3)
    void 로그인_실패_잘못된_비밀번호() {
        UserLoginRequest login = new UserLoginRequest();
        login.setUserId("junituser");
        login.setPwd("wrong");

        assertThatThrownBy(() -> userService.login(login))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("비밀번호가 일치하지 않습니다.");
    }
}