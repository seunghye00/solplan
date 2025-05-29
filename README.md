# SolPlan Backend

Spring Boot 기반 여행일정 공유 플랫폼 백엔드 프로젝트

## 📦 프로젝트 구조 (멀티모듈 구성)

solplan-backend/

├── auth-service/ # 사용자 인증 및 JWT

├── gateway/ # Spring Cloud Gateway (API 라우팅)

├── user-service/ # 사용자 정보 관리 (CRUD)

├── schedule-service/ # 여행 일정 관리

├── build.gradle # 루트 빌드 설정

├── settings.gradle # 모듈 등록 파일

└── .gitignore # 공통 및 모듈별 예외 설정

markdown
복사
편집

## ⚙ 기술 스택

- Java 17
- Spring Boot 3.x
- Gradle (Groovy DSL)
- Spring Security + JWT
- JPA + MySQL
- Spring Cloud Gateway
- GitHub / Git

## 🗂 모듈 설명

| 모듈 | 설명 |
|------|------|
| `auth-service` | 로그인, 회원가입, JWT 인증처리 |
| `gateway` | API 라우팅 및 인증 필터 |
| `user-service` | 사용자 프로필 및 기본 정보 관리 |
| `schedule-service` | 여행 일정 등록 및 조회 기능 |

---

## ✅ 빌드 및 실행

```bash
./gradlew build
./gradlew :auth-service:bootRun
