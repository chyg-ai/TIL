const express = require("express");
const app = express();
const port = 4000;

app.listen(port, () => {
  console.log(`서버가 실행됩니다. http://localhost:${port}`);
});

app.get("/contact", function (req, res) {
  res.send("contact");
});

app.get(
  "/example",
  function (req, res, next) {
    console.log("첫 번째 콜백 함수");
    next();
  },
  function (req, res) {
    res.send("두 번째 콜백 함수");
  }
);

const ex0 = function (req, res, next) {
  console.log("첫 번째 콜백 함수");
  next();
};

const ex1 = function (req, res, next) {
  console.log("두 번째 콜백 함수");
  next();
};

const ex2 = function (req, res) {
  res.send("세 번째 콜백 함수");
};

app.get("/examples", [ex0, ex1, ex2]);
