package com.solplan.authservice.test.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TestUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // MySQL auto_increment
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String name;

    // 생성자
    @Builder
    public TestUser(String email, String name) {
        this.email = email;
        this.name = name;
    }
}