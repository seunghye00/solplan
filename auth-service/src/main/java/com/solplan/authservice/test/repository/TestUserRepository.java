package com.solplan.authservice.test.repository;

import com.solplan.authservice.test.domain.TestUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestUserRepository extends JpaRepository<TestUser, Long> {
    // 기본 CRUD + findByEmail 등 자동 생성됨
}