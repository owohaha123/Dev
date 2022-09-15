public class SelfInstanceClass {
    // 인스턴스 멤버
    int a;
    float b;
    String c;

    public static void main(String[] args) {
        // main 안에서 자신을 인스턴스 화
        // sfc : 인스턴스 참조변수
        SelfInstanceClass sfc = new SelfInstanceClass();
        sfc.a = 100;
        sfc.b = 50.0f;
        sfc.c = "1000";
        sfc.add();
    }
    void add(){
        System.out.println(a + b + c);
    }
}
