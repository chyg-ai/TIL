# Image Component and Image Optimization

- `next/image`: HTML `img`의 확장형으로 Next.js Image 컴포넌트입니다.

- Improved Performance
- Visual Stability
- Faster Page Loads
- Asset Flexibility

# Using the Image Component

- 애플리케이션에 이미지를 추가하기 위해서 `next/image` 컴포넌트를 임포트합니다.

```
import Image from 'next/image
```

- 네이티브 `img` 태그에 가까운 컴포넌트를 사용하고 싶으면 `next/future/image` 컴포넌트를 임포트합니다.

```
import Image from 'next/future/image'
```

# Local Images

- 로컬 이미지를 사용하기 위해서 로컬 이미지 파일을 임포트합니다.

```
import profilePic from '../public/me.png'
```

- `await import()` 또는 `require()`는 지원되지 않습니다.
- `import`는 정적이며 빌드 타임때 분석됩니다.
- Next는 임포트된 파일을 기반으로 이미지 파일의 `너비(width)`와 `높이(height)` 값을 자동으로 계산합니다.

```
import Image from 'next/image'
import profilePic from '../public/me.png'

function Home() {
  return (
    <>
      <h1>My Homepage</h1>
      <Image
        src={profilePic}
        alt="Picture of the author"
        // width={500} automatically provided
        // height={500} automatically provided
        // blurDataURL="data:..." automatically provided
        // placeholder="blur" // Optional blur-up while loading
      />
      <p>Welcome to my homepage!</p>
    </>
  )
}
```

# Remote Images

- 외부 이미지 파일을 사용하는 경우 `src` 프로퍼티의 값은 URL 문자열(상대경로 or 절대경로)입니다.
- Next는 빌드 시간 동안에 외부 파일에 액세스 할 수 없기 때문에, `너비(width)`와 `높이(height)` 그리고 선택적으로 `blurDataURL` 속성을 제공해야합니다.

```
import Image from 'next/image'

export default function Home() {
  return (
    <>
      <h1>My Homepage</h1>
      <Image
        src="/me.png"
        alt="Picture of the author"
        width={500}
        height={500}
      />
      <p>Welcome to my homepage!</p>
    </>
  )
}
```

# Domains

- 외부 이미지 파일을 최적화하고 싶다면 Next에 내장된 이미지 최적화 API를 사용할 수 있습니다.
- API를 사용하기 위해서 기본 설정으로 `loader`를 남겨두고 `Image`의 `src` 속성을 절대 경로 URL로 입력합니다.
- 악의적인 사용자들로부터 애플리케이션을 보호하기 위해서 `next/image` 컴포넌트를 사용할 외부 호스트명을 리스트로 작성합니다.
- 자세한 내용은 [remotePatterns](https://nextjs.org/docs/api-reference/next/image#remote-patterns) 설정을 참고하세요.

# Loaders

- Next 애플리케이션의 디폴트 로더는 내장된 이미지 최적화 API를 사용합니다.

# Priority

- 페이지에서 `LCP(Largest Contentful Paint)` 요소인 이미지에 `priority` 속성을 추가합니다.
- `LCP 요소`는 보통 뷰포트 안에서 보여지는 텍스트 블록이나 대용량 이미지입니다.
- LCP 요소인 `Image` 컴포넌트에 `priority` 속성이 없으면 `next dev` 명령어를 실행시켰을 때 콘솔 창에서 `경고(warning)` 메시지가 표시됩니다.

```
import Image from 'next/image'

export default function Home() {
  return (
    <>
      <h1>My Homepage</h1>
      <Image
        src="/me.png"
        alt="Picture of the author"
        width={500}
        height={500}
        priority
      />
      <p>Welcome to my homepage!</p>
    </>
  )
}
```

# Image Sizing

# Reference

- [Image Component and Image Optimization](https://nextjs.org/docs/basic-features/image-optimization)
- [Cumulative Layout Shift(누적 레이아웃 이동, CLS)
  ](https://web.dev/cls/)
