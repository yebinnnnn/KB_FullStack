let showTime = (msg) => {
  let dt = new Date();
  console.log(
    `${msg} 현재시간:${dt.getHours()}시 ${dt.getMinutes()}분 ${dt.getSeconds()}초`
  );
};

// 처음 시간 출력
//순서를 정하기 위한 콜백의 형태
showTime('<<시작>>');

// 3초 후 실행
setTimeout(() => {
  //첫번째 콜백 내용
  showTime('1 : 3초후');

  // 5초 후 실행
  setTimeout(() => {
    //두번째 콜백 내용 -> 앞선 3초가 끝나야 호출이 된다.
    showTime('2 : 2초후');

    // 3초 후 실행
    setTimeout(() => {
      //세번째 콜백내용 => 앞선 2초가 끝나야 호출이된다.
      showTime('3 : 1초후');
    }, 1000);
  }, 2000);
}, 3000);
//이렇게 콜백이 복잡해서 Promise 로 대체하게 됨.
