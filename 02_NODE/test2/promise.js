let likePizza = true;
const pizza = new Promise((resolve, reject) => {
  if (likePizza) resolve('피자를 주문합니다.');
  else reject('피자를 주문하지 않습니다.');
});

//콜백 지옥이 아니라 then 의 나열로 작업 처리 가능
pizza.then((result) => console.log(result)).catch((err) => console.log(err));
