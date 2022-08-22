const array = [1, 2, 3];

// iterable protocol : Symbol.iterator
// array iterable obj
// iterator call → iterator obj → iterator obj next call → iterator result obj
const iterator = array[Symbol.iterator]();

console.log("next" in iterator);
