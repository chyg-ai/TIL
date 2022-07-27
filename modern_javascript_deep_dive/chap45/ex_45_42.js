const wrongUrl = "https://jsonplaceholder.typicode.com/XXX/1";

fetch(wrongUrl)
  .then(() => console.log("ok"))
  .catch(() => console.log("error"));
