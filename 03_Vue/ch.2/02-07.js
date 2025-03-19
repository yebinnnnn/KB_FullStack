//구조체 분해 할당... 개헷갈
let arr = [10, 20, 30, 40];
let [a1, a2, a3] = arr;
console.log(a1, a2, a3);
//{}사용해서 할당하기
let p1 = { name: '홍길동', age: 20, gender: 'M' };
let { name: n, age: a, gender } = p1;
//name 을 n에, age를 a 에, gender는 gender property 에 넣어라.
console.log(n, a, gender);
