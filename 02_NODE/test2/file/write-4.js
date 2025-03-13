fs = require('fs');

let content = `새로운 내용 추가하기`;
fs.writeFileSync('./text-1.txt', content, { flag: 'a' });
