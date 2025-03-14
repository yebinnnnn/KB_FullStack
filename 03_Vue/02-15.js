var obj = { result: 0 };
/*
 일반함수에서의 this :
 화살표 함수는 자기스코프의 this를 그대로 참조
 */
obj.add = function (x, y) {
  console.log(this); //2. 실행시 함수스코프의 객체인 obj객체로 결정, 출력

  function inner() {
    console.log(this); //4. 실행시 함수스코프의 객체인 window객체로 결정, 출력
    this.result = x + y;
  }
  inner(); //3.실행
};
obj.add(3, 4); //1.실행

console.log(obj); // { result: 0 }
console.log(result); // 7

/*
 화살표함수에서의 this :
 화살표 함수는 자신의 this를 가지지 않고, 상위스코프의 this를 그대로 참조
 */

// obj.add = function (x, y) {
//   console.log(this); //2. 실행시 객체인 obj객체로 결졍, this출력 { result: 0, add: [Function (anonymous)] }
//   const inner = () => {
//     console.log(this); //4.화살표 함수는 자신의 this를 가지지 않고, 상위함수스코프의 this를 그대로 참조.
//                            obj객체로 결졍, obj객체출력 { result: 0, add: [Function (anonymous)] }
//     this.result = x + y;
//   };
//   inner(); //3. 실행
// };
// obj.add(3, 4); //1.실행
// console.log(obj); // { result: 7, add: [Function (anonymous)] }
//--------------------------------

// obj.add = (x, y) => {
//   console.log(this); //2. 화살표 함수는 자신의 this를 가지지 않고, 상위함수스코프의 this를 그대로 참조
//                           window객체로 결정,  window객체출력
//   function inner() {
//     console.log(this); //4. 실행시 객체인 window객체로 결정, window객체출력
//     this.result = x + y;
//   }
//   inner(); //3.실행
// };
// obj.add(3, 4); //1.실행
// console.log(obj); // { result: 0, add: [Function (anonymous)] }
//--------------------------------

// obj.add = (x, y) => {
//   console.log(this); //2.화살표 함수는 자신의 this를 가지지 않고, 상위함수스코프의 this를 그대로 참조. window객체출력
//   const inner = () => {
//     console.log(this); //4. 화살표 함수는 자신의 this를 가지지 않고, 상위함수스코프의 this를 그대로 참조.window객체
//     this.result = x + y;
//   };
//   inner();//3.실행
// };
// obj.add(3, 4);//1.실행
// console.log(obj); // { result: 0, add: [Function (anonymous)] }
