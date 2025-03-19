let p = new Promise((resolve, reject) => {
  resolve('First!');
});
//resolve 객체 순차적으로 받아서 msg
p.then((msg) => {
  console.log(msg);
  //throw new Error
  console.log('second');
})
  .then((msg) => {
    console.log('third');
  })
  .catch((err) => {
    console.log('오류발생==>' + err);
  });
