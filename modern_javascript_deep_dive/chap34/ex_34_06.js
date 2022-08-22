const array = [1, 2, 3];

const iterator = array[Symbol.iterator]();

// iterator result obj
console.log(iterator.next());
console.log(iterator.next());
console.log(iterator.next());
console.log(iterator.next());
console.log(iterator.next());
console.log(iterator.next());
