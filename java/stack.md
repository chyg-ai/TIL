# Stack

# 생성 방법

```
Stack<E> stack = new Stack<E>();
```

# 메소드 종류

| 리턴 타입 | 메소드명         | 설명                                                                                |
| --------- | ---------------- | ----------------------------------------------------------------------------------- |
| boolean   | empty()          | 스택이 비어있는지 확인합니다.                                                       |
| E         | peek()           | 스택의 맨 위 요소를 제거하지 않고 출력합니다.                                       |
| E         | pop()            | 스택의 맨 위 요소를 제거합니다.                                                     |
| E         | push(E item)     | 스택의 맨 위에 요소를 추가합니다.                                                   |
| int       | search(Object o) | 스택에 존재하는 오브젝트의 위치를 반환합니다. 존재하지 않는 경우 `-1`을 반환합니다. |

# Reference

- [Stack](https://docs.oracle.com/javase/7/docs/api/java/util/Stack.html)
