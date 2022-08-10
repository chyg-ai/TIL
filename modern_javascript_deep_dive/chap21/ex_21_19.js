const x = 1;

function foo() {
  eval("var x=2; console.log(x);");
  eval("const x=3; console.log(x);");
  console.log(x);
}

foo();
console.log(x);
