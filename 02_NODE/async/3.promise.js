let showTime = (msg) => {
  let dt = new Date();
  console.log(
    `${msg} 현재시간:${dt.getHours()}시 ${dt.getMinutes()}분 ${dt.getSeconds()}초`
  );
};

// setTimeout을 Promise로 감싸는 함수
const delay = (ms) =>
  new Promise((resolve, reject) => {
    setTimeout(() => {
      resolve(); // setTimeout이 완료된 후 resolve 호출
    }, ms);
  });
// const delay = (ms) => new Promise((resolve) => setTimeout(resolve, ms));

// 처음 시간 출력
showTime('<<시작>>');
// Promise 체이닝으로 로직 처리
//동기 처럼 순서 처리가 가능해짐
delay(3000) // 3초 후
  .then(() => {
    showTime('1 : 3초후');
    return delay(5000); // 5초 후
  })
  .then(() => {
    showTime('2 : 5초후');
    return delay(1000); // 1초 후
  })
  .then(() => {
    showTime('3 : 1초후');
  });
