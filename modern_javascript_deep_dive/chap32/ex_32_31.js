const str = "   foo   ";

console.log(str.replace(/\s/g, ""));
console.log(str.replace(/^\s+/g, ""));
console.log(str.replace(/\s+$/g, ""));
