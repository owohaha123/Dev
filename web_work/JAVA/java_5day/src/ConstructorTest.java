public class ConstructorTest {
    public static void main(String[] args) {
        Car c1 = new Car();
        //c1.setColor("white");
        Car c2 = new Car("white");
        Car c3 = new Car("black","auto");
        Car c4 = new Car("white","auto",4);

        Car c5 = new Car(null,"manual");
        Car c6 = new Car(null,null,5);
        Car c7 = new Car(3);

        // 지역변수
        //int a;
        int a = 0; // 지역변수는 가급적 초기화를 해주자...!
        System.out.println(a);

        c1.printAll();
   }
}

class Car {
    private String color;
    private String gearType;
    private int door;
    // 필드에 값 입력 방법
    // 1) setter 사용
    public void setColor(String color){
        this.color = color;
    }
    // 2) 생성자 사용
    public Car(){} // 기본생성자 (원래는 new Car()작성 시 자동생성)
    // 생성자 오버로딩
    public Car(String color){
        this.color = color;
     }// 개발자가 어떤 생성자를 작성하는 순간
      // 컴파일러는 기본 생성자를 작성해주지 않는다
    public Car(String color, String gearType){
        this.color = color;
        this.gearType = gearType;
    }
    public Car(String color, String gearType, int door){
        this.color = color;
        this.gearType = gearType;
        this.door = door;
    }
    public Car(int door){
        this.door = door;
    }

    public void printAll(){
        System.out.println(color);
        System.out.println(gearType);
        System.out.println(door);
    }
//    public Car(String gearType){
//        this.gearType = gearType;
//    } // String color 와 구분 불가로 사용x
}