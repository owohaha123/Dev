public class PointTest {
    public static void main(String[] args) {
        Point p1 = new Point();
        Point3d p31 = new Point3d();
        p1.x = 10;
        p1.y = 20;
        p1.color = "red";
        p1.showPoint(); // x : 10, y : 20, color : red
        //p1.z = 22;

        p31.x = 30;
        p31.y = 50;
        p31.z = 25;
        p31.color = "blue";
        p31.showPoint(); // x : 30, y : 50, z : 25, color : blue
        System.out.println(p31); // x :30 y :50, z :25 (toString)

        System.out.println(p1.pattern); // 어떤 모양
        p1.pattern = "물결";
        System.out.println(p1.pattern);  // 물결
        System.out.println(p31.pattern); // null (p1의 변수와 이름은 같으나 다른 변수 취급)
        p31.pattern = "구름";
        System.out.println(p31.pattern); // 구름
        p31.showPattern(); // 부모의 pattern : 어떤 모양
                           // 자식의 pattern : 구름
    }
}

class Point { // 2D 그래프용 점 객체
    int x;
    int y;
    String color;
    String pattern = "어떤 모양";

    public Point(){}
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    void showPoint(){
        System.out.println("x : " + x + ", y : " + y + ", color : " + color);
    }
    @Override
    public String toString() {
        return "x :" + x + " y :" + y ;
    }
}

class Point3d extends Point{ // 3D 그래프용 점 객체
    int z;
    String pattern; // 부모클래스와 자식클래스에 있는 변수명이 동일해도 다른 변수로 취급!

    public Point3d(){
        //super(); // 생략 가능
    }

    public Point3d(int x, int y, int z){
        super(x, y); // x, y는 부모클래스에서 초기화 하고
        this.z = z;  // 부모클래스에 없는 변수만 처리
        // 이 때, super 는 맨 첫 줄에 사용 (뒤에 쓰이면 x)
    }

    @Override // Annotation (어노테이션)
    void showPoint(){
        System.out.println("x : " + x + ", y : " + y + ", z : " + z +", color : " + color);
    }

    @Override
    public String toString() {
        return super.toString() + ", z :" + z;
    }

    public void showPattern(){
        System.out.println("부모의 pattern : " + super.pattern); // 구분을 위해 super. 사용
        System.out.println("자식의 pattern : " + pattern);
    }
}

//class Point3d { // 3D 그래프용 점 객체
//    int x;
//    int y;
//    int z;
//    String color;
//}