function* genFunc() {
  yield 1;
  yield 2;
  yield 3;
}

const generator = genFunc();

console.log(Symbol.iterator in generator);
console.log("next" in generator);
