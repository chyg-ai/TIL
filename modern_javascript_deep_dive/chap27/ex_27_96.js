const numbers = [1, 2, 3];
const pows = [];

numbers.forEach((item) => pows.push(item ** 2));
console.log(pows);

numbers.forEach((item, index, thisArg) => console.log(item, index, thisArg));
