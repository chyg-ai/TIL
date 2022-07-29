const fetch = require("node-fetch");

const co = require("co");

co(function* fetchTodo() {
  const url = "https://jsonplaceholder.typicode.com/todos/1";

  const response = yield fetch(url);
  const todo = yield response.json();
  console.log(todo);
});
