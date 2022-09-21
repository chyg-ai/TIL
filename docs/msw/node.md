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

# Using Create React App

- `src/setupTests.js` 모듈은 `Create React App`으로 프로젝트 생성시 자동으로 생성되며 `Jest`의 `setupFilesAfterEnv`의 값으로 사용됩니다.
- `src/setupTests.js` 파일 수정

```
// src/setupTests.js

import { server } from "./mocks/server.js";

beforeAll(() => server.listen());
afterEach(() => server.resetHandlers()); // 테스트에 추가할 request handler 초기화
afterAll(() => server.close()); // 테스트 후 뒷정리
```

# Using manual setup

- `Create React App`을 사용하지 않으면 사용자 정의 `setup module`을 생성합니다.

```
$ touch jest.setup.js
```

- `jest.config.js` 파일에서 `setup module`을 참조합니다.

```
// jest.config.js
module.exports = {
    setupFilesAfterEnv: ['./jest.setup.js'],
}
```

# Run tests

# Reference

- [Node](https://mswjs.io/docs/getting-started/integrate/node)
