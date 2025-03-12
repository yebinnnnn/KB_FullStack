const order = (coffee, callback) => {
  console.log(`${coffee} 주문접수`);
  setTimeout(() => {
    callback(coffee);
  }, 3000);
};

const display = (result) => {
  console.log(`${result} 완료!`);
};

//JS 에서는 함수가 끝났다고 변수가 사라지지 않고, Scope 에 남아있으면 접근이 가능하다.
order('아메리카노', display);
