const arr = [1, 2, 3];

console.log(arr.constructor === Array);
console.log(Object.getPrototypeOf(arr) === Array.prototype);
