# useRouter

```
import { useRouter }

function ActiveLink({children, href}) {
    const router = useRouter();
    const style = {
        marginRight: 10,
        color: router.asPath === href ? 'red' : 'black'
    }

    const handleClick = (e) => {
        e.preventDefault();
        router.push(href);
    }

    return (
        <a href={href} onClick={handleClick} style={style}>{children}
        </a>
    );
}

export default ActiveLink;
```

> `useRouter`는 `React Hook`이므로 클래스형 컴포넌트에서 사용할 수 없습니다. 대신에 `withRouter`를 사용하세요.

# router object

- `useRouter`의 반환값

| **프로퍼티**         | **설명**                                                                                                                                                        |
| -------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `pathname`: `String` | 현재 라우트 파일의 경로입니다.                                                                                                                                  |
| `query`: `Object`    | dynamic route 파마리터를 포함하는 쿼리 스트링 오브젝트입니다. 서버 사이드 렌더링을 사용하지 않으면 사전 렌더링(pre-rendering) 동안에는 비어있는 오브젝트입니다. |
| `query`: `Object`    | dynamic route 파마리터를 포함하는 쿼리 스트링 오브젝트입니다.                                                                                                   |

# router.push

```
router.push(url, as, options);
```

| 파라미터                     | 설명                   |
| ---------------------------- | ---------------------- |
| `url`: `UrlObject or String` | 이동할 URL 주소입니다. |
| `as`: `UrlObject or String`  |                        |
| `options`                    | 옵션 오브젝트입니다.   |

**options object**

| 파라미터  | 설명                                                                                                                                     |
| --------- | ---------------------------------------------------------------------------------------------------------------------------------------- |
| `scroll`  | 이동이 완료되고 페이지의 상단으로 스크롤을 제어합니다. 기본값은 `true`입니다.                                                            |
| `shallow` | `getStaticProps`, `getServerSideProps`, `getInitialProps`를 재실행하지 않고 현재 페이지의 경로를 업데이트합니다. 기본값은 `false`입니다. |
| `locale`  |                                                                                                                                          |

> 외부 URL에 대해서 `router.push`보다 `window.location`을 사용하세요.

# Usage

- 정적 라우트(predefined route): `pages/about.js`로 이동

```
import { useRouter } from 'next/router'

export default function Page() {
  const router = useRouter()

  return (
    <button type="button" onClick={() => router.push('/about')}>
      Click me
    </button>
  )
}

```

- 동적 라우트(dynamic route): `pages/post/[pid].js`로 이동

```
import { useRouter } from 'next/router'

export default function Page() {
  const router = useRouter()

  return (
    <button type="button" onClick={() => router.push('/post/abc')}>
      Click me
    </button>
  )
}
```

- 리다이렉션(Redirection): `pages/login.js`로 이동

```
import { useEffect } from 'react'
import { useRouter } from 'next/router'

// Here you would fetch and return the user
const useUser = () => ({ user: null, loading: false })

export default function Page() {
  const { user, loading } = useUser()
  const router = useRouter()

  useEffect(() => {
    if (!(user || loading)) {
      router.push('/login')
    }
  }, [user, loading])

  return <p>Redirecting...</p>
}
```

# Resetting state after navigation

- Next.js 앱에서 동일한 페이지로 이동할 경우, 페이지의 상태값은 기본적으로 초기화되지 않습니다. 왜냐하면 리액트는 부모 컴포넌트가 바뀌지 않는 이상 언마운트되지 않기 때문입니다.

```
// pages/[slug].js
import Link from 'next/link'
import { useState } from 'react'
import { useRouter } from 'next/router'

export default function Page(props) {
  const router = useRouter()
  const [count, setCount] = useState(0)
  return (
    <div>
      <h1>Page: {router.query.slug}</h1>
      <p>Count: {count}</p>
      <button onClick={() => setCount(count + 1)}>Increase count</button>
      <Link href="/one">
        <a>one</a>
      </Link> <Link href="/two">
        <a>two</a>
      </Link>
    </div>
  )
}
```

- 위 예제에서 `/one`과 `/two` 사이에서 페이지를 이동하더라도 상태값(count)은 초기화되지 않습니다. 왜냐하면 상위 리액트 컴포넌트(Page)가 동일하기 때문입니다.

1. `useEffect` 사용하기

```
// page/a ↔ page/b : useEffect 콜백 함수 실행하여 상태값 초기화
useEffect(() => {
  setCount(0)
}, [router.query.slug])
```

2. `key` 사용하기

```
// pages/_app.js
import { useRouter } from 'next/router'

export default function MyApp({ Component, pageProps }) {
  const router = useRouter()
  return <Component key={router.asPath} {...pageProps} />
}
```

# With URL Object

```
import { useRouter } from 'next/router'

export default function ReadMore({ post }) {
  const router = useRouter()

  return (
    <button
      type="button"
      onClick={() => {
        router.push({
          pathname: '/post/[pid]',
          query: { pid: post.id },
        })
      }}
    >
      Click here to read more
    </button>
  )
}
```

# router.replace

- `next/link`의 `replace` 속성과 비슷합니다.
- `history` 스택에 새로운 URL 엔트리를 추가하는 것을 방지합니다.

```
import { useRouter } from 'next/router'

export default function Page() {
  const router = useRouter()

  return (
    <button type="button" onClick={() => router.replace('/home')}>
      Click me
    </button>
  )
}
```

# Usage

```
import { useRouter } from 'next/router'

export default function Page() {
  const router = useRouter()

  return (
    <button type="button" onClick={() => router.replace('/home')}>
      Click me
    </button>
  )
}
```

# router.prefetch

> 이 기능은 프로덕션 환경에서 동작합니다. `Next.js` 앱은 개발 환경에서 페이지를 미리 불러오지 않습니다.

```
router.prefetch(url, as, options)
```

| 파라미터  | 설명                     |
| --------- | ------------------------ |
| `url`     | 사전에 불러올 페이지 URL |
| `as`      |                          |
| `options` | 옵션 오브젝트            |

# Usage

- 로그인 페이지가 있고 로그인 후에 유저를 대쉬보드로 리다이렉트합니다.
- 이 경우 화면이 빠르게 전환되도록 대쉬보드 화면을 사전에 불러옵니다.

```
import { useCallback, useEffect } from 'react'
import { useRouter } from 'next/router'

export default function Login() {
  const router = useRouter()
  const handleSubmit = useCallback((e) => {
    e.preventDefault()

    fetch('/api/login', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({
        /* Form data */
      }),
    }).then((res) => {
      // Do a fast client-side transition to the already prefetched dashboard page
      if (res.ok) router.push('/dashboard')
    })
  }, [])

  useEffect(() => {
    // Prefetch the dashboard page
    router.prefetch('/dashboard')
  }, [])

  return (
    <form onSubmit={handleSubmit}>
      {/* Form fields */}
      <button type="submit">Login</button>
    </form>
  )
}
```

# router.beforePopState

```
router.beforePopState(cb)
```

| 파라미터 | 설명                                       |
| -------- | ------------------------------------------ |
| `cb`     | `popstate` 이벤트가 발생하면 실행되는 함수 |

이 함수는 다음과 같은 속성들로 구성된 오브젝트를 파라미터로 받습니다.

| 파라미터            | 설명                                                          |
| ------------------- | ------------------------------------------------------------- |
| `url`: `String`     | 새로운 상태를 위한 라우트입니다. 보통 페이지의 이름이 옵니다. |
| `as`: `String`      | 브라우저에서 보여질 URL입니다.                                |
| `options`: `Object` | `router.push` 의 추가적인 옵션                                |

`cb` 함수가 `false`를 반환하면 Next.js 라우터는 `popstate`를 처리하지 않습니다. 자세한 내용은 [Disabling file-system routing](https://nextjs.org/docs/advanced-features/custom-server#disabling-file-system-routing)을 참고하세요.

# Usage

```
import { useEffect } from 'react'
import { useRouter } from 'next/router'

export default function Page() {
  const router = useRouter()

  useEffect(() => {
    router.beforePopState(({ url, as, options }) => {
      // I only want to allow these two routes!
      if (as !== '/' && as !== '/other') {
        // Have SSR render bad routes as a 404.
        window.location.href = as
        return false
      }

      return true
    })
  }, [])

  return <p>Welcome to the page</p>
}
```

# router.back

- 브라우저의 뒤로가기 버튼을 누른 것과 동일한 기능을 제공합니다.
- `window.history.back()`

# Usage

```
import { useRouter } from 'next/router'

export default function Page() {
  const router = useRouter()

  return (
    <button type="button" onClick={() => router.back()}>
      Click here to go back
    </button>
  )
}
```

# router.reload

- 브라우저의 새로고침 버튼을 누른 것과 동일한 기능을 제공합니다.
- `window.location.reload()`

# Usage

```
import { useRouter } from 'next/router'

export default function Page() {
  const router = useRouter()

  return (
    <button type="button" onClick={() => router.reload()}>
      Click here to reload
    </button>
  )
}
```

# router.events

- Next.js 라우터에서 발생하는 다양한 이벤트를 리스닝할 수 있습니다.

| 파라미터                                  | 설명 |
| ----------------------------------------- | ---- |
| `routeChangeStart(url, { shallow })`      |      |
| `routeChangeComplete(url, { shallow })`   |      |
| `routeChangeError(err, url, { shallow })` |      |
| `beforeHistoryChange(url, { shallow })`   |      |
| `hashChangeStart(url, { shallow })`       |      |
| `hashChangeComplete(url, { shallow })`    |      |

> `url`는 `basePath`를 포함하여 브라우저에서 보여지는 `URL`을 의미합니다.

# Usage

# Reference

- [next/router](https://nextjs.org/docs/api-reference/next/router)
