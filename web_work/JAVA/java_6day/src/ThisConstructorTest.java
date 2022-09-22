import com.dto.PhoneInfo;

public class ThisConstructorTest    {
    public static void main(String[] args) {
        // 매개변수 0개인 생성자 호출
        Car c1 = new Car();
        System.out.println(c1); // color='null', gearType='null', door=0

        // 매개변수 1개인 생성자 호출
        Car c2 = new Car("white");
        System.out.println(c2); // color='white', gearType='null', door=0

        // 매개변수 2개인 생성자 호출
        Car c3 = new Car("white","auto");
        System.out.println(c3); // color='white', gearType='auto', door=0

        // 매개변수 3개인 생성자 호출
        Car c4 = new Car("white","auto",2);
        System.out.println(c4); // color='white', gearType='auto', door=2

        Car c5 = c2.constrCall(); // c1 ~ c4 뭐든 상관 없음
                                  // why? 다 constrCall() 갖고 있다ㅠ
        System.out.println(c5); // constrCall() 주석 확인하셈
        //---------------------------

        String str = "홍길동";

        PhoneInfo p = new PhoneInfo(str, "010-1234-5678","12-12",12);
    }
}

class Car {
    private String color;
    private String gearType;
    private int door;

    // 1) 기본 생성자(매개변수 0개)
    public Car(){}

    // 2) 매개변수가 1개인 생성자
    public Car(String color){
        //this.color = color;
        this(color, null); // 인자 2개짜리 생성자 호출
    }

    // 3) 매개변수가 2개인 생성자
    public Car(String color, String gearType){ // 인자 3개짜리 생성자 호출
        this(color, gearType, 0);
    }

    // 4) 매개변수가 3개인 생성자
    // 매개변수로 받은 값들을 초기화
    public Car(String color, String gearType, int door){
        this.color = color;
        this.gearType = gearType;
        this.door = door;
    }

    public Car constrCall(){
        // 인스턴스(new)가 생성되고 난 후엔 생성자인 this()는 호출할 수 없음 (시점이 안 맞음)
        // 그렇다고 이 메소드(constrCall)를 사용하지 못하는 것은 아님 (생성자 호출만 불가)
        //this("white");

        //return new Car(); // color='null', gearType='null', door=0
        return new Car("white","auto"); // color='white', gearType='auto', door=0
    }

    // 콘솔 로그 확인을 위한 toString()
    // 안 쓰면 주소값만 나옴 ㅠㅠ
    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", gearType='" + gearType + '\'' +
                ", door=" + door +
                '}';
    }
}
