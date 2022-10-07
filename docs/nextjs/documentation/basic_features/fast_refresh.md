# Fast Refresh

- Next.js 애플리케이션 `9.4 버전 이상`에서 기본적으로 활성화됩니다.
- Next.js `Fast Refresh` 기능이 활성화되면 컴포넌트의 상태값이 사라지지 않고 변경 내용이 반영됩니다.

# How It Works

- 리액트 컴포넌트 파일을 수정하면 `Fast Refresh`는 해당 파일의 코드를 업데이트하고 컴포넌트를 리렌더링합니다.
- 리액트 컴포넌트 파일에서 스타일, 렌더링 로직, 이벤트 핸들러, 이펙트 등 어떠한 코드도 수정할 수 있습니다.
- 리액트 컴포넌트가 아닌 파일을 수정하면 `Fast Refresh`는 해당 파일과 의존관계를 맺는 파일을 포함해서 전부 재실행합니다.
- 예를 들어 `Button.js`와 `Modal.js`는 `theme.js`를 임포트합니다. 그리고 `theme.js`를 수정하면 두 컴포넌트도 업데이트됩니다.
- 마지막으로 리액트 트리(React tree) 바깥에서 불러오는 파일들을 수정하면, `Fast Refresh`는 페이지를 완전히 리로드시킵니다.

# Error Resilience

## Syntax Errors

- 개발 기간동안 문법 에러가 발생하면 파일을 수정해서 저장합니다.
- 이 에러는 자동으로 사라지며 앱을 리로드할 필요가 없습니다.
- 따라서 컴포넌트의 상태가 사라지지 않습니다.

## Runtime Errors

# Limitations

# Tips

- `Fast Refresh`는 기본적으로 함수형 컴포넌트에서 리액트의 로컬 상태값을 보존합니다.
- 가끔 상태값을 강제로 초기화시키거나 컴포넌트가 리마운트되길 원합니다.
- 이를 위해서 `// @refresh rest` 코드를 수정하는 파일에 추가하세요.
- 이 디렉티브는 로컬로 선언되며 파일이 변경될 때마다 `Fast Refresh`가 컴포넌트를 리마운트하게 만듭니다.

# Fast Refresh and Hooks

- `Fast Refresh`는 수정이 되면 컴포넌트의 상태를 보존시킵니다.
- 특히, `useState`와 `useRef`는 이전 상태 값을 보존시킵니다.

# Reference

- [Fast Refresh](https://nextjs.org/docs/basic-features/fast-refresh#how-it-works)
