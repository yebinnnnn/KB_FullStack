fs = require('fs');
// import fs from 'node:fs/promises';

if (fs.existsSync('./test2/test3/test4')) {
  console.log('folder already exists');
} else {
  fs.mkdir('./test2/test3/test4', { recursive: true }, (err) => {
    if (err) {
      return console.log(err);
    }
    console.log('folder created');
  });
}
//recursive 는 중간 경로가 존재하지 않으면 생성할지 여부.
//삭제할때 recursive 는 하위 파일 다 삭제할지 여부를 결정함.
//mode 는 사용자 권한, 기본값 0o777
