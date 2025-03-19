//Spread 연산자 관련
//객체의 내용을 펼쳐서 새로운 객체에 넣는다는 의미가 있음 = Spread

let obj1 = { name: '박문수', age: 29 };
let obj2 = obj1; //obj1, obj2 는 동일한 객체를 참조.
//위의 두개가 같은 메모리를 참고하게 하는 대입 연산자다.
//이 뒤에 obj2.age를 99로 변경하고 obj1.age 를 출력하면 99로 바뀌어있다~~~

let obj3 = { ...obj1 }; //객체 내부의 값은 복사하지만 obj3, obj1은 다른 객체
let obj4 = { ...obj1, email: 'mspark@gmail.com' }; //새로운 속성 추가
obj2.age = 19;
console.log(obj1); //{ name:"박문수", age:19 }
console.log(obj2); //{ name:"박문수", age:19 } obj1과 동일!!
console.log(obj3); //{ name:"박문수", age:29 } age가 바뀌지 않음
console.log(obj1 == obj2); //true
console.log(obj1 == obj3); //false

let arr1 = [100, 200, 300];
let arr2 = ['hello', ...arr1, 'world'];
let arr3 = ['hello', arr1, 'world'];
console.log(arr1); // [ 100, 200, 300 ]
console.log(arr2); // [ "hello", 100, 200, 300, "world" ]
console.log(arr3); //배열 자체가 안에 삽입됨.
console.log(arr1 + [, 400, 500, 600]);
