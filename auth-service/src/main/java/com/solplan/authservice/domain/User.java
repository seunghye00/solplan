package com.solplan.authservice.domain;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

/**
 * 사용자 정보를 저장하는 엔티티 클래스
 */
@Entity
@Table(name = "users")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키 자동 증가 (MySQL 기준)
    private Long id;

    @Column(nullable = false, unique = true)
    private String userId; // 사용자 아이디

    @Column(nullable = false)
    private String pwd; // 비밀번호

    @Column(nullable = false, unique = true)
    private String email; // 이메일

    @Column(nullable = false)
    private String name; // 이름

    @Column(nullable = false)
    private String addr; // 주소

    @Column(nullable = false)
    private String phone; // 전화번호

    @Column(nullable = false)
    private String ssn; // 주민등록번호

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role; // 사용자 권한 (USER, ADMIN)

    @Column(name = "reg_date", nullable = false)
    private LocalDateTime regDate; // 가입일시

    /**
     * 엔티티가 저장되기 전 호출되어 가입일시를 현재 시간으로 설정
     */
    @PrePersist
    protected void onCreate() {
        this.regDate = LocalDateTime.now();
    }
}