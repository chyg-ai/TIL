request
  .patch("https://jsonplaceholder.typicode.com/todos/1", {
    completed: true,
  })
  .then((response) => {
    if (!response.ok) throw new Error(response.statusText);
    return response.json();
  })
  .then((todos) => console.log(todos))
  .catch((err) => console.error(err));
