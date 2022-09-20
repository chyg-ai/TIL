# Mocking REST API

# Imports

- `src/mocks/handlers.js` 파일에서 `REST API`를 모킹하기 위해 필요한 것들을 불러옵니다.

```
// src/mocks/handlers.js
import { rest } from "msw";
```

# Request handler

- REST API 요청을 처리하기 위해 `요청 방법`, `경로`, `응답을 반환하는 함수`를 정의해야 합니다.

```
import { rest } from "msw";

export const handlers = [
    rest.post('/login', null),
    rest.get('/user', null)
]
```

# Response resolver

```
import { rest } from "msw";

export const handlers = [
  rest.post("/login", (req, res, ctx) => {
    sessionStorage.setItem("is-authenticated", "true");
    return res(ctx.status(200));
  }),

  rest.get("/user", (req, res, ctx) => {
    const isAuthenticated = sessionStorage.getItem("is-authenticated");

    if (!isAuthenticated) {
      return res(
        ctx.status(403),
        ctx.json({
          errorMessage: "Not authorized",
        })
      );
    }

    return res(
      ctx.status(200),
      ctx.json({
        username: "admin",
      })
    );
  }),
];

```

> 더 복잡한 API 시나리오와 상호작용을 처리하기 위해서 `sessionStorage`, `localStorage`, 또는 `IndexedDB`를 활용하세요.
