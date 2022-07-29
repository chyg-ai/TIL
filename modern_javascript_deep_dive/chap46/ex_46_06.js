function* genFunc() {
  try {
    yield 1;
    yield 2;
    yield 3;
  } catch (e) {
    console.error(e);
  }
}

const generator = genFunc();

console.log(generator.next()); // iterator result obj { value: 1, done: false }
console.log(generator.return("End!")); // iterator result obj { value: "End!", done: true }
