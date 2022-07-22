# 백엔드 개발

**백엔드 개발 도구**

- 스프링 부트(Springboot)
- 그래들(Gradle)
- 롬복(Lombok)
- 포스트맨(Postman)
- REST
- 레이어드 아키텍처(Layered Architecture)

**스프링 프레임워크**

- 제어의 역전(Inversion of Control, IoC)
- 의존성 주입(Dependency Injection, DI)
- 스프링 AOP(Aspect Oriented Programming)
- 스프링 ORM(Object Relational Mapping)

## 의존성 주입

- Constructor
- Setter

```
// constructor
public class Service{
    private final Interface if;

    // 생성자의 매개변수 : Interface의 구현체
    public Service(Interface if){
        this.if = if;
    }
}
```

```
// Setter
public class Service{
    private final Interface if;

    // 세터 함수의 매개변수: Interface의 구현체
    public void setImp(Interface if){
        this.if = if;
    }
}
```

## 스프링 부트

- 스프링 기반 애플리케이션을 쉽게 구동
- 스탠드 얼론 애플리케이션
- 자동 설정

**Before**

자바 애플리케이션 → WAR 파일 → 톰캣배포

**After**

자바 애플리케이션 → 실행
