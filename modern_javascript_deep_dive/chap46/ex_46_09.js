function* genFunc() {
  const x = yield 1;

  const y = yield x + 10;

  return x + y;
}

const generator = genFunc(0);

let res = generator.next(); // { value: 1, done: false }
console.log(res);

res = generator.next(10); // x = 10, { value: 20, done: false }
console.log(res);

res = generator.next(20); // y = 20, { value: 30, done: true }
console.log(res);
