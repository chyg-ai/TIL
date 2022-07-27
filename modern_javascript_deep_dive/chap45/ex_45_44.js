const request = {
  get(url) {
    return fetch(url);
  },
  post(url, payload) {
    return fetch(url, {
      method: "POST",
      headers: { "content-type": "application/json" },
      body: JSON.stringify(payload), // 직렬화
    });
  },
  patch(url, payload) {
    return fetch(url, {
      method: "PATCH",
      headers: { "content-type": "application/json" },
      body: JSON.stringify(payload),
    });
  },
  delete(url) {
    return fetch(url, { method: "DELETE" });
  },
};
