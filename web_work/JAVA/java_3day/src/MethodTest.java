public class MethodTest {
    // 인스턴스 멤버 변수
    static int a; // static 멤버변수(클래스 변수) - 전역변수
    float b;
    String c;

    public static void main(String[] args) {
        // 자바 프로그램 실행 시작 메소드
        // public : 접근제어자 (<-> private)
        // static : 인스턴스 생성없이 사용 가능
        // void : 반환값이 없다. (return 사용 안 함)
        // main : 고정된 이름
        // String[] args : 프로그램 시작 시 옵션값 저장 배열
        //System.out.println(args[0]);
        //System.out.println(args[1]);
        //System.out.println(args[2]);

        // main 안에서 메소드 사용을 위해 메소드 앞에 static 적어줌
        // why? static 이 붙는 멤버(변수, 메소드 모두)는 static 이 붙은 멤버만 사용 가능
        //      (아니면 인스턴스를 만들어 줘야 함 (ex. new 키워드))
        method1();
        a = 10000; // 사용하려면 전역변수에 static 을 붙여줘야 함
    }// main end

    // void 를 사용하는 메소드 작성
    static void method1(){
        System.out.println("return 없는 메소드 실행");
        add(); // 메소드 호출
    }
    static int add(){
        System.out.println("return 있는 메소드 실행");
        return 100;
    }
}// class end
