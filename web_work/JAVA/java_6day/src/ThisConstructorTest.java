import com.dto.PhoneInfo;

public class ThisConstructorTest    {
    public static void main(String[] args) {
        Car c1 = new Car("white");

        String str = "홍길동";

        PhoneInfo p = new PhoneInfo(str, "010-1234-5678","12-12",12);
    }
}

class Car {
    private String color;
    private String gearType;
    private int door;

    // 기본 생성자
    public Car(){}

    public Car(String color){
        //this.color = color;
        this(color, null);
    }

    public Car(String color, String gearType){
        this(color, gearType, 0);
    }

    public Car(String color, String gearType, int door){
        this.color = color;
        this.gearType = gearType;
        this.door = door;
    }

    public void constrCall(){
        // 인스턴스가 생성되고 난 후엔 생성자인 this()는 호출할 수 없음 (시점이 안 맞음)
        //this("white");

    }
}
