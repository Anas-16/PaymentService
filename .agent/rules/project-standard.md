---
trigger: always_on
---

# Project Standards & Architecture

## Tech Stack
- Java 21 (LTS)
- Spring Boot 3.2+
- Maven
- PostgreSQL (via Docker Compose)
- JUnit 5 + Mockito for testing

## Architecture: Hexagonal (Ports & Adapters)
- STRICTLY separate `domain` (core logic) from `infrastructure` (database/web).
- `domain` must NOT depend on Spring Boot, Hibernate, or any framework.
- Use `records` for DTOs and Value Objects.
- Use `UUID` for all primary keys.

## Coding Standards
- Use `Lombok` for boilerplate (@Data, @Builder).
- No field injection (@Autowired). Use Constructor Injection only.
- All public methods must have Javadoc.

## Git Commit Rules
- Follow Conventional Commits: `feat:`, `fix:`, `chore:`, `refactor:`, `docs:`.
- Example: "feat: scaffold domain entities for payment transaction"