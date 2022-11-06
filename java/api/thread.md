# Thread

## 중첩 클래스

| 클래스명                        | 설명                                                             |
| ------------------------------- | ---------------------------------------------------------------- |
| Thread.state                    | 스레드의 상태값                                                  |
| Thread.UncaughtExceptionHandler | 예외 발생시 스레드가 갑자기 종료될 때 실행되는 핸들러 인터페이스 |

## 필드

| 필드명        | 설명                                      |
| ------------- | ----------------------------------------- |
| MAX_PRIORITY  | 스레드에게 부여할 수 있는 우선순위 최대값 |
| MIN_PRIORITY  | 스레드에게 부여할 수 있는 우선순위 최소값 |
| NORM_PRIORITY | 스레드에게 부여할 수 있는 우선순위 기본값 |

## 메서드

| 메서드명      | 설명                                                    |
| ------------- | ------------------------------------------------------- |
| currentThread | 스레드의 참조값을 반환합니다.                           |
| getName       | 스레드의 이름을 반환합니다.                             |
| setName       | 스레드의 이름을 변경합니다.                             |
| getPriority   | 스레드의 우선순위를 반환합니다.                         |
| setPriority   | 스레드의 우선순위를 변경합니다.                         |
| getState      | 스레드의 상태(대기/실행/정지/종료 상태)값을 반환합니다. |
| interrupt     | 스레드를 중단시킵니다.                                  |
| yield         | 다른 스레드에게 프로세서의 사용을 양도합니다.           |

# Reference

- [Thread (Java Platform SE 7)](https://docs.oracle.com/javase/7/docs/api/java/lang/Thread.html)
- [Thread.State (Java Platform SE 7)](https://docs.oracle.com/javase/7/docs/api/java/lang/Thread.State.html)
