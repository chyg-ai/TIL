const target = "AA BB 12,345";

let regExp = /[\d,]+/g;

console.log(target.match(regExp));

regExp = /[\D,]+/g;

console.log(target.match(regExp));
