const arr = ["hello", "world"];

console.log(arr.flatMap((str, index) => [index, [str, str.length]]));
console.log(arr.map((str, index) => [index, [str, str.length]]).flat(2));
