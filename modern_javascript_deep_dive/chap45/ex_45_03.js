const get = (url) => {
  const xhr = new XMLHttpRequest();
  xhr.open("GET", url);
  xhr.send();

  // 비동기 코드
  xhr.onload = () => {
    if (xhr.status === 200) {
      return JSON.parse(xhr.response);
    }
    console.error(`${xhr.status} ${xhr.statusText}`);
  };
};

const response = get("https://jsonplaceholder.typicode.com/posts/1");
console.log(response);
