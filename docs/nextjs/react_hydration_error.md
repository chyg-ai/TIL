# React Hydration Error

# Why This Error Occurred

- Next.js 애플리케이션이 렌더링되는 동안, 사전 렌더링되는 리액트 트리와 브라우저에서 처음 렌더링되는 리액트 트리 사이에 차이점이 존재합니다.
- 브라우저에서 처음 렌더링되는 것을 `Hydration`이라고 합니다.

# Possible Ways to Fix it

- Styled Components / Emotion을 사용하는 경우
- css-in-js 라이브러리들은 pre-rendering 설정이 되어 있지 않아서 종종 hydration 불일치를 일으킵니다.
-

# Reference

- [React Hydration Error](https://nextjs.org/docs/messages/react-hydration-error#why-this-error-occurred)
- [Hydration](https://reactjs.org/docs/react-dom.html#hydrate)
