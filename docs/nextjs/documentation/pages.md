# Pages

- `Page`는 `pages` 디렉터리 안에 export된 리액트 컴포넌트입니다.
- 각 Page는 파일 이름을 기반으로 라우팅 됩니다.

```
// pages/about.js

function About() {
  return <div>About</div>
}

export default About
```

# Pages with Dynamic Routes

- Next.js는 각 페이지에 대해서 `Dynamic Routes` 기능을 제공합니다.
- 예를 들어 `pages/posts/[id].js` 파일을 생성하면, `posts/1`, `posts/2`로 접근할 수 있습니다.
- 더 자세한 내용은 [Dynamic Routing Documentation](https://nextjs.org/docs/routing/dynamic-routes)을 참고하세요.

# Pre-rendering

- `Next.js`는 기본적으로 모든 페이지를 사전 렌더링합니다.
- 이 말은 각 페이지의 HTML을 미리 생성하는 것을 의미합니다.
- 자바스크립트로 클라이언트 사이드에서 HTML을 생성하는 것과 대조적입니다.
- 이러한 `Pre-rendering` 기능은 더 나은 성능과 `SEO`를 보장합니다.

# Two forms of Pre-rendering

- `Next.js`는 두 가지 형태의 `Pre-rendering`을 제공합니다.
- `Static Generation` : HTML이 빌드 타임때 생성되고 각 요청에서 재사용됩니다.
- `Server-side Rendering` : 각 요청이 들어올 때 HTML이 생성됩니다.
- 이 둘의 차이점은 페이지의 HTML이 생성되는 시기입니다.
- 두 가지 방법을 모두 사용하는 `hybrid` Next.js 앱을 생성할 수 있습니다.
- 두 가지 방법을 모두 사용하면서 클라이언트 사이드에서 데이터를 불러올 수 있습니다.
- 즉, 클라이언트 사이드에서 자바스크립트로 페이지의 부분을 렌더링 할 수 있습니다.
- 이에 대한 자세한 내용은 [Data Fetching Documentation](https://nextjs.org/docs/basic-features/data-fetching/client-side)을 참고하세요.

# Static Generation

- Static Generation을 사용하면 페이지의 HTML은 빌드 타임때 생성됩니다.
- 이는 `Production` 환경에서 `next build` 명령어를 실행하면 페이지의 HTML이 생성되는 것을 의미합니다.
- 생성된 HTML은 요청이 들어올 때마다 재사용됩니다.
- 데이터의 유무에 따라 `Static Generation`으로 페이지를 생성하는 방법을 알아보겠습니다.

## Static Generation without data

- Next.js는 기본적으로 데이터를 불러오지 않고 `Static Generation`을 사용하여 페이지를 사전 렌더링합니다.

```
function About() {
  return <div>About</div>
}

export default About
```

## Static Generation with data

- 사전 렌더링을 수행하기 전에 외부에서 데이터를 불러올 필요가 있습니다.
- `Next.js` 에서 제공하는 두 개의 함수를 사용하면 됩니다.
- `getStaticProps` : 페이지의 내용이 외부 데이터에 의존하는 경우 사용합니다.
- `getStaticPaths` : 페이지의 라우팅 경로가 외부 데이터에 의존하는 경우 사용합니다.

### Scenario 1 : Your page content depends on external data

- 예시: 블로그 페이지에서 블로그 포스트 목록을 CMS로부터 불러옵니다.

```
// TODO: Need to fetch `posts` (by calling some API endpoint)
//       before this page can be pre-rendered.
function Blog({ posts }) {
  return (
    <ul>
      {posts.map((post) => (
        <li>{post.title}</li>
      ))}
    </ul>
  )
}

export default Blog
```

- 사전 렌더링을 수행하기 위해 데이터를 불러올려면 Blog 페이지에 `getStaticProps` 함수를 작성합니다.
- 이 함수는 빌드 타임때 호출되며 불러온 데이터를 페이지의 `props`로 전달합니다.
- 자세한 내용은 [Data Fetching Documentation](https://nextjs.org/docs/basic-features/data-fetching/client-side)을 참고하세요.

```
function Blog({ posts }) {
  // Render posts...
}

// This function gets called at build time
export async function getStaticProps() {
  // Call an external API endpoint to get posts
  const res = await fetch('https://.../posts')
  const posts = await res.json()

  // By returning { props: { posts } }, the Blog component
  // will receive `posts` as a prop at build time
  return {
    props: {
      posts,
    },
  }
}

export default Blog
```

### Scenario 2 : Your page content depends on external data

- Next.js는 각 페이지에 대해서 `Dynamic Routes` 기능을 제공합니다.
- 예를 들어 `pages/posts/[id].js` 파일을 생성하면, `posts/1`, `posts/2`로 접근할 수 있습니다.
- 하지만 빌드 타임때 사전 렌더링을 수행하기 위해서 id 값을 외부 데이터에 의존하게 될 수 있습니다.
- 예를 들어 { id: 1 }, { id: 2} 포스트를 두 개를 등록하고 posts/1, posts/2로 접근하고 싶은 경우입니다.
- id 값은 데이터베이스에 등록되어 있어서 사전 렌더링을 수행하기 위해서는 id 값을 불러와야 합니다.
- 이를 위해서 `Next.js`는 `dynamic page`에서 `getStaticPaths` 함수를 export 합니다.
- 이 함수는 빌드 타임때 호출되며 사전 렌더링을 수행하기 위한 경로를 지정할 수 있습니다.

```
// This function gets called at build time
export async function getStaticPaths() {
  // Call an external API endpoint to get posts
  const res = await fetch('https://.../posts')
  const posts = await res.json()

  // Get the paths we want to pre-render based on posts
  const paths = posts.map((post) => ({
    params: { id: post.id },
  }))

  // We'll pre-render only these paths at build time.
  // { fallback: false } means other routes should 404.
  return { paths, fallback: false }
}
```

- 또한 `dynamic page`에서 `getStaticProps` 함수를 export 합니다.
- getStaticProps 함수에서 id 값으로 데이터를 불러와 사전 렌더링을 수행합니다.

```
function Post({ post }) {
  // Render post...
}

export async function getStaticPaths() {
  // ...
}

// This also gets called at build time
export async function getStaticProps({ params }) {
  // params contains the post `id`.
  // If the route is like /posts/1, then params.id is 1
  const res = await fetch(`https://.../posts/${params.id}`)
  const post = await res.json()

  // Pass post data to the page via props
  return { props: { post } }
}

export default Post
```

- 동작 원리에 대한 자세한 내용은 [getStaticPaths Documentation](https://nextjs.org/docs/basic-features/data-fetching/get-static-paths)을 참고하세요.

# When should I use Static Generation?

- 가능하면 Static Generation 방법을 사용하세요.
- 왜냐하면 빌드할 때 한 번 생성되고 CDN으로 서비스 하는 것이 매번 요청이 들어올 때마다 서버가 페이지를 렌더링하는 것보다 빠르기 때문입니다.
- 대표적으로 마켓팅 화면, 블로그 포스트나 포트폴리오 화면, 이커머스 제품 목록 화면 등이 있습니다.

스스로에게 질문 해 보세요.

> 사용자의 요청이 오기 전에 미리 페이지를 생성해야 합니까?

이 질문에 대한 대답이 Yes라면 `Static Generation` 방식을 사용해야합니다.

반면에 다음과 같은 질문을 하게 된다면 `Static Generation`보다 `Server-side Rendering` 방식이나 `Client-side data fetching` 방식을 고려해야 합니다.

> 페이지의 데이터가 자주 업데이트되고 매번 요청이 들어올 때마다 달라지는가?

# Server-side Rendering

- `Server-side Rendering`은 `SSR` 또는 `Dynamic Rendering`으로 불립니다.
- 매번 요청이 들어올 때 마다 page의 HTML이 생성됩니다.
- 페이지에 대한 `Server-side Rendering`을 사용할려면 `getServerSideProps` 함수를 export 합니다.
- 이 함수는 매번 요청이 들어올 때 마다 서버에 의해서 호출됩니다.
- 매번 요청이 들어올 때 마다 외부 데이터를 불러와서 화면을 업데이트를 하는 경우 `Server-side Rendering`을 고려해야 합니다.

```
function Page({ data }) {
  // Render data...
}

// This gets called on every request
export async function getServerSideProps() {
  // Fetch data from external API
  const res = await fetch(`https://.../data`)
  const data = await res.json()

  // Pass data to the page via props
  return { props: { data } }
}

export default Page
```

- `getServerSideProps`는 `getStaticProps`랑 비슷합니다.
- 하지만 `getServerSideProps`는 빌드 타임때 동작하는 `getStaticProps`와 달리 매번 요청이 들어올 때 마다 동작합니다.

# Reference

- [Next.js Pages](https://nextjs.org/docs/basic-features/pages)
