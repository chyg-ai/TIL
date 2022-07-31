1 @ 1; // SyntaxError
foo(); // ReferenceError
null.foo; // TypeError
new Array(-1); // RangeError
decodeURIComponent('%'); // URIError