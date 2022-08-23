const isIterable = (v) =>
  v !== null && typeof v[Symbol.iterator] === "function";

isIterable([]);
isIterable("");
isIterable(new Map());
isIterable(new Set());
isIterable({});
