fetch('https://jsonplaceholder.typicode.com/users')
  .then((response) => response.json())
  .then((data) => console.log(data))
  .catch((err) => console.log(err));

//위는 top level 이기 때문에 async 쓸 수 없음.
//async await 스타일로 바꾼 경우

async function init() {
  try {
    const response = await fetch('https://jsonplaceholder.typicode.com/users');
    //비동기 함수에 동기 스타일
    const users = await response.json(); //비동기 함수에 동기 스타일
    console.log(users);
  } catch (err) {
    //비동기 작업때 에러가 발생하면 try-catch로 에러 탐지. 에러 객체로 결과 나옴
    console.error(err);
  }
}

init();
