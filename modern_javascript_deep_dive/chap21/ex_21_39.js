var x = 10;

function foo() {
  y = 20;
  console.log(x + y);
}

foo();

console.log(globalThis.x);
console.log(globalThis.y);

delete x;
delete y;

console.log(globalThis.x);
console.log(globalThis.y);
