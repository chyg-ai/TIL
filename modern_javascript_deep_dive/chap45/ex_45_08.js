get("/step1", (a) => {
  get(`/step2/${a}`, (b) => {
    // a로 콜백 함수 호출
    get(`/step3/${b}`, (c) => {
      // b로 콜백 함수 호출
      get(`/step4/${c}`, (d) => {
        // c로 콜백 함수 호출
        console.log(d);
      });
    });
  });
});
