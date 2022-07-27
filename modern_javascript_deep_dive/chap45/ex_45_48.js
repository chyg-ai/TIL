request
  .delete("https://jsonplaceholder.typicode.com/todos/1")
  .then((response) => {
    if (!response.ok) throw new Error(response.statusText);
    return response.json();
  });
