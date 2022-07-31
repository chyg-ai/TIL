console.log("[Start]");

try {
  foo();
} catch (err) {
  console.error(err);
} finally {
  console.log("finally");
}

console.log("[End]");
