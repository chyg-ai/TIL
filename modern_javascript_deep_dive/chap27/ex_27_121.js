const values = [1, 2, 1, 3, 5, 4, 5, 3, 4, 4];

const result = values.filter((val, i, _values) => _values.indexOf(val) === i);
console.log(result);
