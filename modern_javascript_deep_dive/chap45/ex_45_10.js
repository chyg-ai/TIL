const promise = new Promise((resolve, reject) => {
    if(/* 비동기 처리 성공 */){
        resolve('result');
    }else {
        /* 비동기 처리 실패  */
        reject('failure reason');
    }
})

