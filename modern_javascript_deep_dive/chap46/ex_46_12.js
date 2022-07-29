const fetch = require("node-fetch");

const async = (generatorFunc) => {
  const generator = generatorFunc(); // generator object

  const onResolved = (arg) => {
    const result = generator.next(arg);

    return result.done
      ? result.value
      : result.value.then((res) => onResolved(res));
  };

  return onResolved; // closer
};

async(function* fetchTodo() {
  const url = "https://jsonplaceholder.typicode.com/todos/1";

  const response = yield fetch(url); // { value: promise, done: false }
  const todo = yield response.json(); // { value: response.json, done: false }
  console.log(todo);
})();
