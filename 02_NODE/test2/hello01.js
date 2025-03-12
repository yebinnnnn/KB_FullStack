const c = require('ansi-colors');
// 함수를 써서 모듈명 요청

function hello(name) {
  console.log(c.green(name) + '님 안녕하세요');
}

hello('홍길동');
