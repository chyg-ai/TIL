console.log([5, 10, 15].some((item) => item > 10)); // true
console.log([5, 10, 15].some((item) => item < 0)); // false
console.log(["apple", "banana", "mango"].some((item) => item === "banana")); // true
console.log([].some((item) => item > 3)); // false
