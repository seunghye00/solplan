package com.solplan.authservice.dto;

import lombok.*;

/**
 * 회원가입 요청 정보를 담는 DTO 클래스
 * - Controller에서 클라이언트 요청(Request Body)을 받을 때 사용
 */
@Setter             // 모든 필드의 Setter 메서드를 자동 생성
@Getter             // 모든 필드의 Getter 메서드를 자동 생성 (데이터 조회용)
@NoArgsConstructor  // 기본 생성자 자동 생성 (JSON → 객체 변환 시 필요)
@AllArgsConstructor // 모든 필드를 매개변수로 받는 생성자 자동 생성 (테스트나 코드 내부 생성 시 유용)
@Builder            // Builder 패턴을 사용할 수 있게 해줌 (가독성과 유연한 객체 생성에 도움)
public class UserJoinRequest {
    private String userId;   // 사용자 아이디
    private String pwd;      // 비밀번호
    private String email;    // 이메일
    private String name;     // 이름
    private String addr;     // 주소
    private String phone;    // 전화번호
    private String ssn;      // 주민등록번호
}
