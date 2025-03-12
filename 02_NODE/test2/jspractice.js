function getTriangle(base, height) {
  return (base * height) / 2;
}

//() =>{} 부터 익명함수로 보면 됨
//함수 리턴과 콜백에서 사용
let getTri = (base, height) => {
  return (base * height) / 2;
};
console.log('면적:' + getTriangle(5, 2));
console.log('면적:' + getTri(5, 2));

function displayA() {
  console.log('A');
}

function displayB(callback) {
  setTimeout(() => {
    console.log('B');
    callback();
  }, 2000);
}

function displayC() {
  console.log('C');
}

displayA();
displayB(displayC);
