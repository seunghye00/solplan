package com.solplan.auth.repository;

import com.solplan.auth.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // 기본 CRUD + findByEmail 등 자동 생성됨
}