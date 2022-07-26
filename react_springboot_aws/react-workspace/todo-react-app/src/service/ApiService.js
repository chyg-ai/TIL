import { API_BASE_URL } from "../app-config";

export function call(api, method, request) {
  let options = {
    headers: new Headers({
      "Content-Type": "application/json",
    }),
    url: API_BASE_URL + api,
    method: method,
  };

  if (request) {
    // 요청 정보 몸체에 데이터 추가
    options.body = JSON.stringify(request);
  }

  return fetch(options.url, options).then((response) => {
    response.json().then((json) => {
      if (!response.ok) {
        return Promise.reject(json);
      }
      return json;
    });
  });
}
