const fibonacciFunc = function (max) {
  let [pre, cur] = [0, 1];

  return {
    // iterable obj
    [Symbol.iterator]() {
      return {
        next() {
          [pre, cur] = [cur, pre + cur];
          return { value: cur, done: cur >= max };
        },
      };
    },
  };
};

for (const num of fibonacciFunc(10)) {
  console.log(num);
}
