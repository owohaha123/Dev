package subpackage;

public class UseClass2 {
    void method1(){
        UseClass uc = new UseClass();
        uc.ccc = 100; // public
        uc.bbb = 200; // default (같은 패키지 사용 가능)
        // uc.aaa = 300; // private (다른 클래스 사용 불가)

    }
}
