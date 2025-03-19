let obj = { result: 0 };

obj.add = function (x, y) {
  this.result = x + y;
};
let add2 = obj.add;

console.log(add2 === obj.add); //동일한 함순지 확인

add2(3, 4);
console.log(obj);
console.log(result);
//함수나 메서드를 호출할 때 this 를 변경할 수 있음
//bind() apply() call()
