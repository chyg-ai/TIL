const fibonacci = {
  [Symbol.iterator]() {
    let [pre, cur] = [0, 1];
    const max = 10;

    return {
      // iterator
      next() {
        [pre, cur] = [cur, pre + cur];

        return { value: cur, done: cur >= max }; // iterator result obj
      },
    };
  },
};

for (const num of fibonacci) {
  console.log(num);
}
