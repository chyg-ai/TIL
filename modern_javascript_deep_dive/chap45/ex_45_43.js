const wrongUrl = "https://jsonplaceholder.typicode.com/XXX/1";

fetch(wrongUrl)
  .then((response) => {
    if (!response.ok) throw new Error(response.statusText);
    return response.json();
  })
  .then((todo) => console.log(todo))
  .catch((err) => console.err(err));
