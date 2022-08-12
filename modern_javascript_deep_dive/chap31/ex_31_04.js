const count = (str, char) => (str.match(new RegExp(char, "gi")) ?? []).length;

count("Is this all there is?", "is");
count("Is this all there is?", "xx");
