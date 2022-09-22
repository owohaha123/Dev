public class AbstractTest {
    public static void main(String[] args) {
        //Animal a = new Animal();
        Cat c = new Cat(); // 정상적으로 인스턴스 생성 가능
        // TestInterface.d = 1000; // 상수의 초기값 변경 불가
        System.out.println(TestInterface.d); // 출력은 가능 (static 이기에)
        InterClass ic = new InterClass();
        TestInterface tf = ic; // 다형성 취급 가능
    }
}

abstract class Animal {
    String name;
    int age;
    String gender;

    abstract void howl(); // 반드시 재정의(오버라이드) 필요

    void eat(){
        System.out.println("먹는다");
    }
}

class Cat extends Animal{

    @Override
    void howl() {
        System.out.println("미야오옹~~");
    }
}

interface TestInterface{
    // 모두 상수! 변수 없음!
    public static final int a = 10 ; // 초기화가 필요
    final int b = 20; // public static 생략 가능
    static int c = 30; // public final 생략 가능
    int d = 40; // 사실 public static final 전부 생략 가능

    //public abstract void method1(){} // abstract 는 바디를 가질 수 없음
    public abstract void method1();
    public void method2(); // abstract 생략 가능
    void method3(); // public 생략 가능
}

// Override(재정의)를 통해 인터페이스 implements(구현)
class InterClass implements TestInterface{

    @Override
    public void method1() {

    }

    @Override
    public void method2() {

    }

    @Override
    public void method3() {

    }
}
