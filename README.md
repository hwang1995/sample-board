# Kotlin 연습을 위한 샘플 게시판 프로젝트

## 만든 목적

- Spring 개발을 Java로는 해보았지만 Kotlin으론 해본적이 없어 연습겸 제작
- 지금은 작은 프로젝트지만 서서히 크게 만들어 보고 싶습니다.

## 시스템 설계

- Backend
    - Kotlin / Java 17
    - Spring Boot 2.6.5
    - Spring Data JPA
    - H2 Database (Test Purpose)
    - AWS RDS or DynamoDB (아직 고민중... )
- Frontend
    - React
    - Material-UI
    - Styled-components
- Infra
    - Amazon Web Services
        - API Gateway (지금은 게시판만 있지만, 인증 / 인가 서버 등 필요할 수 있으니)
        - S3 (스토리지 저장을 위해)

## 요구사항 정의

- requirements 폴더에 정의하겠습니다.
    - FR.md (기능적 요구사항 정의)
    - NFR.md (비기능적 요구사항 정의)

## 고민 사항

- AWS Aurora를 사용하고 싶은데 비용도 너무 쎄다... 가장 싼게 DynamoDB인데 이것도 고려중.