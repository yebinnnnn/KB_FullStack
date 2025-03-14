var obj = { result: 0 };
/*
 일반함수(이름 있는 함수, 이름 없는 함수)에서의 this :
 화살표 함수는 자기스코프의 this를 그대로 참조
 */
obj.add = function (x, y) {
  //일반함수의 this -> 이 함수를 포함하고 있는 객체
  //이 this 는 obj 가 됨.
  console.log(this); //2. 실행시 함수스코프의 객체인 obj객체로 결정, 출력

  function inner() {
    //이 this 는 최상위 객체인 window 반환(inner가 포함되어 있는 객체가 없는거임)
    console.log(this); //4. 실행시 함수스코프의 객체인 window객체로 결정, 출력
    this.result = x + y;
  }
  //this.inner()로 실행한게 아님. 만약 this.inner 였으면 obj 지만
  //일반 inner()로 호출할때는 개별적으로 호출-> window 에서 실행
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
//   console.log(this); //2. 실행시 객체인 obj객체로 결정, this출력 { result: 0, add: [Function (anonymous)] }
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
