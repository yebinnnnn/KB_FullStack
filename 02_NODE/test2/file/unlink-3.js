const fs = require('fs');

//파일이 존재하지 않을때 처리
if (!fs.existsSync('./text-2.txt')) {
  console.log('file does not exist');
} else {
  fs.unlinkSync('./text-2.txt', (err) => {
    if (err) {
      return console.log(err);
    }
    console.log('file deleted');
  });
}
