let msg = 'GLOBAL';
//변수가 let 으로 선언되었을때는  block 영역의 scope 를 갖게 된다.
function outer() {
  //따라서 여기 msg 는 함수 블럭 안에서만 사용이 가능하다.
  let msg = 'OUTER';
  console.log(msg);
  if (true) {
    let msg = 'BLOCK';
    console.log(msg);
  }
}
outer();
