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
//익명함수가 아닌 async function(){} 으로 써도 된다.
const runTimer = async () => {
  // 처음 시간 출력
  showTime('<<시작>>');

  await delay(3000); // 3초 대기
  showTime('1 : 3초후');

  await delay(5000); // 5초 대기
  showTime('2 : 5초후');

  await delay(1000); // 1초 대기
  showTime('3 : 1초후');
};

// runTimer 함수 실행
runTimer();
