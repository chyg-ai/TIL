const numObj = new Number(1.5);

console.log(numObj.toFixed()); // numObj의 프로토타입 객체인 Number.prototype이 상속한 toFixed 메서드를 호출한다.

console.log(Number.isInteger(0.5)); // 표준 객체의 정적 메서드는 생성자 함수의 프로토타입 프로퍼티 객체가 직접 소유하지 않는다.
