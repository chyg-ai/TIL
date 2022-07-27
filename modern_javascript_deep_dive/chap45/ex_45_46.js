request
  .post("https://jsonplaceholder.typicode.com/todos", {
    userId: 1,
    title: "Javascript",
    completed: false,
  })
  .then((response) => {
    if (!response.ok) throw new Error(response.statusText);
    return response.json();
  })
  .then((todos) => console.log(todos))
  .catch((err) => console.error(err));
