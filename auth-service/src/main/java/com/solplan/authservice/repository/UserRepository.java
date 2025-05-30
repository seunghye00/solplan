package com.solplan.authservice.repository;

import com.solplan.authservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * UserRepository
 *
 * - User 엔티티에 대한 CRUD (Create, Read, Update, Delete)를 처리하는 인터페이스
 * - Spring Data JPA에서 제공하는 JpaRepository를 상속하여 기본적인 DB 작업을 자동으로 구현
 * - 메서드 이름만으로도 쿼리를 자동 생성하는 기능을 활용할 수 있음
 * - 추가적으로 필요한 검색 기능은 직접 메서드로 선언하면 Spring이 구현체를 자동 생성함
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * 이메일(email)로 사용자 정보 조회
     * 메서드 이름만으로 자동으로 SQL이 생성됨
     * 예: SELECT * FROM users WHERE email = ?
     *
     * @param email 사용자 이메일
     * @return 해당 이메일을 가진 사용자 객체 (Optional로 감싸서 null 방지)
     */
    Optional<User> findByEmail(String email);

    /**
     * 사용자 아이디(userId)로 사용자 정보 조회
     * 예: SELECT * FROM users WHERE user_id = ?
     *
     * @param userId 사용자 아이디 (로그인 ID)
     * @return 해당 아이디를 가진 사용자 객체
     */
    Optional<User> findByUserId(String userId);

    // 필요한 다른 메서드는 추후 추가 예정 2025.05.30
}