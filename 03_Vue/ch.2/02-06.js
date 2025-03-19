function foodReport(name, age, ...favoriteFoods) {
  console.log(name + ', ' + age);
  console.log(favoriteFoods);
}
//나머지 값들이 favortieFoods 에 배열형태로 저장됨.
foodReport('이몽룡', 20, '짜장면', '냉면', '불고기');
foodReport('홍길동', 16, '초밥');
