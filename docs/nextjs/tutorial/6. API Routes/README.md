# API Routes

- Next.js는 [API Routes](https://nextjs.org/docs/api-routes/introduction)를 지원합니다.

## 배울 내용

- API Route 생성 방법
- API Routes에 대한 유용한 정보

## API Routes 생성하기

- API Routes는 Next.js 앱 내부에서 API 엔드 포인트를 생성합니다.

```
// pages/api/hello.js

// req : HTTP 요청 메시지, res : HTTP 응답 메시지
export default function handler(req, res) {
  res.status(200).json({ text: "Hello" });
}
```

- http://localhost:3000/api/hello로 접속하면 {"text":"Hello"} 메시지를 확인합니다.
- req : [http.IncomingMessage](https://nodejs.org/api/http.html#http_class_http_incomingmessage)의 인스턴스입니다.
- res : [http.ServerResponse](https://nodejs.org/api/http.html#http_class_http_serverresponse)의 인스턴스입니다.

## API Routes 세부 내용

[API Routes](https://nextjs.org/docs/api-routes/introduction)에 대해 반드시 알아야할 중요 내용에 대해서 다룹니다.

1. getStaticProps 혹은 getStaticPaths 에서 API Routes를 호출하지 마세요.
2. getStaticProps와 getStaticPaths는 오직 서버 사이드 렌더링에서만 동작합니다.
3. 이 함수들은 브라우저의 JS 번들러에 포함되지 않습니다.
4. [Writing Server-Side code Documentation](https://nextjs.org/docs/basic-features/data-fetching/get-static-props#write-server-side-code-directly)를 참고하세요.

## API Routes의 사용 사례

- 폼의 입력값을 처리할 때 API Routes를 사용합니다.
- 예를 들어, 페이지에서 폼을 생성하고 API Route에 POST 요청을 보냅니다.
- 폼의 입력 값은 데이터베이스에 저장됩니다.
- API Route는 클라이언트 번들러에 추가되지 않아 안전하게 서버 사이드 코드로 동작합니다.

## Preview Mode

- [Preview Mode Documentation](https://nextjs.org/docs/advanced-features/preview-mode)를 참고하세요.

## Dynamic Routes

- [Dynamic API Routes](https://nextjs.org/docs/api-routes/dynamic-api-routes)를 참고하세요.

# Reference

- [Next.js API Routes](https://nextjs.org/learn/basics/api-routes)
- [Headless CMS](https://en.wikipedia.org/wiki/Headless_content_management_system)
