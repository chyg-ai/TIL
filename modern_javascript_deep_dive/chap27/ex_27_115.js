const values = [1, 2, 3, 4, 5];

const max = values.reduce((acc, cur) => (acc < cur ? cur : acc), 0);

console.log(max);
