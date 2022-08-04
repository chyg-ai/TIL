const strObj = new String("Lee");

console.log(Object.getPrototypeOf(strObj) === String.prototype); // 생성자 함수로 생성한 인스턴스의 프로토타입 === 생성자 함수의 프로토타입 프로퍼티 객체
