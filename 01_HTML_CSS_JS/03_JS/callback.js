//  매개변수로 함수 전달하는 형태
function callTentimes(callback) {
  for (let i = 0; i < 10; i++) {
    callback();
    // alert이 10번 실행
  }
}
// callTentimes 함수가 전달한 function 실행
callTentimes(function () {
  alert('콜백 호출');
});
