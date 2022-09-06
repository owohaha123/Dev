/* 쇼핑몰(상품)
자동차
  1) 정보(변수)
     모델명 : 소나타, 아반떼
     색상 : 빨간색, 회색, 백색, 검정색
     문개수 : 2, 3, 5
     제조사 : 현대, 기아, BMW, 벤츠, 아우디
     카테고리 : 소형, 준중형, 중형, 대형, SUV
     속도 : 0

  2) 기능(함수)
     가속(속도) : 주어진 속도만큼 차를 가속
     멈춤() : 즉시 속도 0으로 만듦
     조향(방향) : 주어진 방향에 따라 차의 경로를 변경
*/



let car = {
    model : "소나타" ,
    color : "블랙" ,
    speed : 0,
    accel : function(sp){
        this.speed = sp;
    }
};

console.log(car);
console.log(car.color);

car.speed = 100;

console.log(car);

car.accel(200);
console.log(car.speed);

// 문의 개수 저장 변수를 추가
car.door = 4;
console.log(car);

car.break = function(){
    this.speed = 0;
}
car.break();
console.log(car);


let person = {
    name : "홍길동" ,
    age : "29" ,
    address : "서울" ,
    birth : "19900000"
};
console.log(person);

// JSON(JavaScript Object Notation) : 자바스크립트 객체 표기법
// 화면에서 입력받은 데이터를 서버프로그램 쪽으로 전달 시 사용

// js 의 객체는 주로 html 요소를 객체화하여 제어 시 사용

const img = document.getElementsByTagName("img"); // getElementsByTagName은 배열로 찍힘
console.log(img);

img[0].width = 400;
img[0].setAttribute("height", "500");