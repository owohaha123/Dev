package sub;

import basic.Parent1;

public class Child1 extends Parent1 {
    void someMethod(){
        a = 10000;
        b = 20000; // 다른 패키지여도 상속받았다면 o
        //c = 30000;
        //d = 40000;
    }
}
