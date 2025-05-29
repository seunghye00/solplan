# SolPlan Backend

혼자 여행하는 사람들을 위한 여행 일정 공유 플랫폼 **SolPlan**의 백엔드 저장소입니다.  
Spring Boot 기반으로 마이크로서비스 아키텍처(MSA)를 적용하여 멀티모듈 구조로 개발되었습니다.

---

## 📌 프로젝트 개요

- **프로젝트명**: SolPlan (혼행을 위한 여행 일정 공유 플랫폼)
- **역할**: 백엔드 설계 및 전체 서비스 구현
- **주요기능**:
  - 사용자 인증 및 JWT 토큰 기반 보안
  - 여행 일정 생성, 조회, 수정
  - 댓글 기능 및 사용자 정보 관리
  - Gateway 기반 API 라우팅
- **구성 방식**: Spring Boot 멀티모듈 + MSA 구조

---

## 🛠 기술 스택

| 항목 | 기술 |
|------|------|
| Language | Java 17 |
| Framework | Spring Boot 3.x |
| Build Tool | Gradle (Groovy DSL) |
| DB | MySQL |
| Auth | Spring Security, JWT |
| API Gateway | Spring Cloud Gateway |
| Version Control | Git, GitHub |
| IDE | IntelliJ IDEA |

---

## 📁 프로젝트 구조

<pre>
solplan-backend/
├── auth-service/              # 사용자 인증 및 JWT 기능
├── gateway/                   # Spring Cloud Gateway
├── user-service/              # 사용자 정보 관리
├── schedule-service/          # 여행 일정 기능
├── build.gradle               # 루트 빌드 스크립트
├── settings.gradle            # 모듈 등록 설정
└── .gitignore                 # 공통 예외 설정
</pre>

---

## 📦 멀티모듈 구성

| 모듈명 | 설명 |
|--------|------|
| `auth-service` | 로그인, 회원가입, JWT 발급 및 검증 |
| `gateway` | 외부 요청을 각 서비스로 라우팅 |
| `user-service` | 사용자 기본 정보 관리 (프로필, 탈퇴 등) |
| `schedule-service` | 여행 일정 등록, 조회, 수정, 삭제 등 기능 |

---

## 🚀 실행 방법

1. 저장소 클론
   ```bash
   git clone https://github.com/your-username/solplan-backend.git
   cd solplan-backend
