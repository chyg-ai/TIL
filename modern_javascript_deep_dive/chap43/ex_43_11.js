const xhr = new XMLHttpRequest();

xhr.open("GET", "https://jsonplaceholder.typicode.com/todos/1");

xhr.send();

xhr.onreadystatechange = () => {
  if (xhr.readyState !== XMLHttpRequest.DONE) return;

  if (xhr.status === 200) {
    console.log(xhr.status);
    console.log(xhr.statusText);
    console.log(xhr.responseType);
    console.log(JSON.parse(xhr.response));
    console.log(JSON.parse(xhr.responseText));
  } else {
    console.error("Error", xhr.status, xhr.statusText);
  }
};
