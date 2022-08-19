const todos = [
  { id: 4, content: "JavaScript" },
  { id: 1, content: "HTML" },
  { id: 2, content: "CSS" },
];

// key : 비교 대상
function compare(key) {
  // 오름차순 정렬
  return (a, b) => (a[key] < b[key] ? -1 : a[key] > b[key] ? 1 : 0);

  // 내림차순 정렬
  //   return (a, b) => (a[key] < b[key] ? 1 : a[key] < b[key] ? -1 : 0);
}

todos.sort(compare("id"));
console.log(todos);

todos.sort(compare("content"));
console.log(todos);
