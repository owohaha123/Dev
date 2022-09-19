public class CardTest {
    public static void main(String[] args) {
        Etc.cv = 100;
        // Etc.iv = 200;
        Etc e1 = new Etc();
        e1.iv = 200;
        Etc e2 = new Etc();
        e2.iv = 300;

        e1.cv = 500;
        e2.cv = 1000;

        System.out.println(Etc.cv);
        System.out.println(e1.iv);
        System.out.println(e2.iv);

        // -----------------------
        Card c1 = new Card();
        c1.kind = "하트";
        c1.number = 7;
        Card c2 = new Card();
        c2.kind = "스페이드";
        c2.number = 3;

        Card.width = 50;
        c2.height = 80;
        System.out.println("c1은 " + c1.kind + ", "  + c1.number + "이며, 크기는 ("
                            + c1.width + ", " + c1.height + ")");
        System.out.println("c2은 " + c2.kind + ", "  + c2.number + "이며, 크기는 ("
                + c1.width + ", " + c2.height + ")");

    }
}

class Etc {
    int iv; // 인스턴스 변수
    static int cv; // 스태틱 변수, 클래스 변수

    final int MAX = 100; // 상수 (상수일 땐 보통 변수명을 대문자로 작성)

    static void method1(){
        //iv = 10000; // 인스턴스 변수는 static 안에서 사용 x
        cv = 50000;// static 안에선 static 붙은 변수만 사용가능
        //method2(); // 인스턴스 메소드도 static 안에서 사용 x
    }

    void method2(){
        iv = 20000;
        cv = 70000;
        // max = 200; // final 변수는 재할당 불가
    }
}

class Card {
    // 카드의 모양 : 하트, 다이아, 클로버, 스페이드
    // 카드별 숫자 : 1~13
    // 인스턴스 변수
    String kind;
    int number;

    // 카드의 크기(가로/세로)는 모두 동일해야 한다
    // static(class)변수 (초기화도 함께 처리)
    static int width = 100;
    static int height = 250;
}
