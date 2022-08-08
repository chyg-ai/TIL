console.log(Array.isArray([]));
console.log(Array.isArray([1, 2]));
console.log(Array.isArray([new Array()]));

console.log(Array.isArray([]));
console.log(Array.isArray({}));
console.log(Array.isArray(null));
console.log(Array.isArray(undefined));
console.log(Array.isArray(1));
console.log(Array.isArray(["Array"]));
console.log(Array.isArray([true]));
console.log(Array.isArray([false]));
console.log(Array.isArray({ 0: 1, length: 1 }));
console.log(Array.isArray(Array.from({ 0: 1, length: 1 })));
