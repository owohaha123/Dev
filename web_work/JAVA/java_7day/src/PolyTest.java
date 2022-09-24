public class PolyTest {
    public static void main(String[] args) {
        Child5 ch5 = new Child5();
        Child6 ch6 = new Child6();

        // up casting
        Parent5 p5 = ch5;
        Parent5 p6 = ch6;
        Parent5 p7 = new Parent5();

        p5.a = 10;
        p5.b = 20;
        //p5.c = 30; // 부모로 형변환 됐기에 사용 불가

        // down casting
        //Child5 cc5 = (Child5)p5; // O. 강제형변환
        //Child5 cc6 = (Child5)p7; // X. 부모클래스로 만든 인스턴스(p7)는 자식 클래스로 만든 참조변수(cc6)에 저장할 수 없다
        //Child6 cc7 = (Child6)p6; // O. 강제형변환

        Parent5 p = new Child6(); // 상속받은 관계라서 가능
        if(p instanceof Child5){
            Child5 cc5 = (Child5)p;
            System.out.println("Child5로 만든 인스턴스!");// X
            cc5.c = 300;
        }else{
            Child6 cc7 = (Child6)p;
            System.out.println("Child6로 만든 인스턴스!");
            cc7.d = 400;
        }
    } // 결과 : Child6로 만든 인스턴스!
}

class Parent5 {
    int a;
    int b;
}

class Child5 extends Parent5 {
    int c;
}

class Child6 extends Parent5 {
    int d;
}
