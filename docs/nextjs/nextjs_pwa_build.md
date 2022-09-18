# PWA 빌드 방법

## Next.js 프로젝트 생성

```
# npx create-next-app@latest
```

## next-pwa 설치

```
# npm install next-pwa

// or

# yarn add next-pwa
```

## next.config.js 수정

```
// next.config.js

/** @type {import('next').NextConfig} */

const withPWA = require("next-pwa")({
  dest: "public",
});

const nextConfig = withPWA({
  reactStrictMode: true,
  swcMinify: true,
});

module.exports = nextConfig;
```

## manifest 파일 추가

## Head 메타데이터 추가

- `_document.js` 파일 생성

```
// pages/_document.js

import { Html, Head, Main, NextScript } from "next/document";

export default function Document() {
  return (
    <Html lang="ko">
      <Head>
        <link rel="manifest" href="manifest.json" />
        <link rel="apple-touch-icon" href="/icon.png" />
        <link rel="theme-color" href="#fff" />
      </Head>
      <body>
        <Main />
        <NextScript />
      </body>
    </Html>
  );
}

```

## npm run build

## npm run start

# Reference

- [next-pwa](https://www.npmjs.com/package/next-pwa)
- [Document](https://nextjs.org/docs/advanced-features/custom-document)
- https://www.youtube.com/watch?v=ARNN_zmrwcw
- [manifest generator](https://www.simicart.com/manifest-generator.html/)
- https://github.com/vercel/next.js/issues/40155
- https://stackoverflow.com/questions/58985103/progressive-web-app-not-showing-install-button-in-browser-bar
