# Node

- Node 환경에서 `Mock Service Worker`를 사용하는 방법 중 하나는 `통합 테스트(Integration Test)`를 위한 `request handler 함수`를 활용하는 것입니다.

# Configure server

- `src/mocks/server.js` 파일 생성
- setupServer 함수 불러오기
- server 인스턴스 생성 및 request handlers 불러오기

```
import { setupServer } from "msw/node";
import { handlers } from "./handlers";

export const server = setupServer(...handlers);
```

# Setup

# Reference

- [Node](https://mswjs.io/docs/getting-started/integrate/node)
