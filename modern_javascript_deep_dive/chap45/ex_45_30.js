const requestData1 = () =>
  new Promise((resolve) => setTimeout(() => resolve(1), 3000));
const requestData2 = () =>
  new Promise((resolve) => setTimeout(() => resolve(2), 2000));
const requestData3 = () =>
  new Promise((resolve) => setTimeout(() => resolve(1), 1000));

const res = [];
requestData1()
  .then((data) => {
    res.push(data); // 1
    return requestData2();
  })
  .then((data) => {
    res.push(data); // 1, 2
    return requestData3();
  })
  .then((data) => {
    res.push(data);
    console.log(res); // 1, 2, 3
  })
  .catch(console.error);
