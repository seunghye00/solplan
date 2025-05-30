package com.solplan.authservice.service;

import com.solplan.authservice.domain.User;
import com.solplan.authservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

/**
 * UserService
 *
 * - 사용자 관련 로직을 처리하는 서비스 클래스
 * - 회원가입, 사용자 조회, 중복 체크 등 핵심 비즈니스 로직 담당
 */
@Service
@RequiredArgsConstructor // 생성자를 통한 의존성 주입 (final 필드 자동 주입)
public class UserService {

    private final UserRepository userRepository;

    /**
     * 사용자 회원가입
     *
     * @param userId    사용자 아이디
     * @param pwd       사용자 비밀번호 (단순 문자열, 추후 암호화 적용 예정)
     * @param email     이메일
     * @param name      이름
     * @param addr      주소
     * @param phone     전화번호
     * @param ssn       주민등록번호
     * @return 저장된 사용자 객체
     */
    @Transactional
    public User register(String userId, String pwd, String email, String name,
                         String addr, String phone, String ssn) {

        // 1. 이메일 중복 체크
        if (userRepository.findByEmail(email).isPresent()) {
            throw new IllegalArgumentException("이미 존재하는 이메일입니다.");
        }

        // 2. 아이디 중복 체크
        if (userRepository.findByUserId(userId).isPresent()) {
            throw new IllegalArgumentException("이미 존재하는 아이디입니다.");
        }

        // 3. 사용자 생성 및 저장
        User user = User.builder()
                .userId(userId)
                .pwd(pwd) // 추후 BCrypt 등으로 암호화 적용 권장
                .email(email)
                .name(name)
                .addr(addr)
                .phone(phone)
                .ssn(ssn)
                .regDate(LocalDateTime.now()) // 가입일시 자동 생성
                .build();

        return userRepository.save(user); // 저장 후 반환
    }
}