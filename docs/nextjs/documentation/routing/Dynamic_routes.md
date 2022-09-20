# Dynamic Routes

```
// pages/post/[pid].js

import { useRouter } from "next/router";

const Post = () => {
  const router = useRouter();
  const { pid } = router.query;
  return <p>Post: {pid}</p>;
};

export default Post;
```

- `/post/abc`: `query { "pid": "abc" }`
- `/post/abc?foo=bar`: `query { "foo": "bar" ,"pid": "abc"}`
- `/post/abc?pid=123`: `query { "pid": "abc" }`

```
// pages/post/[pid]/[comment].js
import { useRouter } from "next/router";

const Comment = () => {
  const router = useRouter();
  const { pid, comment } = router.query;

  return (
    <>
      <h1>Post: {pid}</h1>
      <p>Comment: {comment}</p>
    </>
  );
};

export default Comment;
```

- `/post/1/a-comment`: `query { "pid": "1", "comment": "a-comment" }`

## Catch all routes

- `pages/post/[...slug].js` matching `/post/a` or `post/a/b` or `/post/a/b/c`
- `/post/a`: `query { "slug": ["a"] }`
- `/post/a/b`: `query { "slug": ["a", "b"] }`
- `/post/a/b/c`: `query { "slug": ["a", "b", "c"] }`

## Optional catch all routes

- `pages/post/[[...slug]].js` matching `/post` or `/post/a`, or `/post/a/b`
- `/post`: `query { }`
- `/post/a`: `query { "slug": ["a"] }`
- `/post/a/b`: `query { "slug": ["a", "b"] }`

## Caveats

- `pages/post/create.js` matching `/post/create`
- `pages/post/[pid].js` matching `/post/1`, `/post/abc` but not `/post/create`
- `pages/post/[...slug].js` matching `/post/1/2`, `/post/a/b/c`, etc but not `/post/create`, `/post/abc`
