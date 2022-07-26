async function foo(n) {
  return n; // 반환 값을 resolve한 프러미스를 반환한다.
}

foo(1).then((v) => console.log(v));

const bar = async function (n) {
  return n;
};
bar(2).then((v) => console.log(v));

const baz = async (n) => n;
baz(3).then((v) => console.log(v));

const obj = {
  async foo(n) {
    return n;
  },
};
obj.foo(4).then((v) => console.log(v));

class MyClass {
  async bar(n) {
    return n;
  }
}

const myClass = new MyClass();
myClass.bar(5).then((v) => console.log(v));
