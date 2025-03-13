//모듈을 사용하고 만드는것에 집중하기
const express = require('express');
const app = express();
const port = 3000;

//get 요청이 되었을때 할 일을 적어주는 공간
//슬래시 안에 루트URL, req res 로 콜백함수 실행
app.get('/', (req, res) => {
  res.send('WELCOME');
});
//app.post()
