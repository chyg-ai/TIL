
// 배열 프로토타입이 forEach 메서드를 지원하지 않는 경우
if(!Array.prototype.forEach){
    // forEach 메서드 추가
    Array.prototype.forEach=funtcion(callback, thisArg){
        if(typeof callback !== 'function'){
            throw new TypeError(callback + ' is not a function');
        }

        thisArg = thisArg || window;
        
        for(var i = 0; i < this.length; i++){
            callback.call(thisArg, this[i], i, this);
        }
    }
}