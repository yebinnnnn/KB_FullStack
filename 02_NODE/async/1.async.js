let showTime = (msg) => {
  let dt = new Date(); //날짜 dt객체에 담음
  console.log(
    `${msg} 현재시간:${dt.getHours()}시 ${dt.getMinutes()}분 ${dt.getSeconds()}초`
  );
};

// 처음 시간 출력
showTime('');

// 3초 후 실행
//setTimeout 함수는 비동기 함수임. 그 간극동안 다음 작업을 하러간다.
setTimeout(() => {
  showTime('1 : 3초후');
}, 3000);

// 5초 후 실행
setTimeout(() => {
  //앞의 3초동안 두번째 작업인 여기로 와서 실행하려함
  showTime('2 : 5초후');
}, 5000);

// 1초 후 실행
setTimeout(() => {
  //그럼 5초사이 이 작업을 하러 도착.
  showTime('3 : 1초후');
}, 1000);
