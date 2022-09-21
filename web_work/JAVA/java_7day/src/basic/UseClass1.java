package basic;

public class UseClass1 {
    Parent1 p = new Parent1();
    void method2(){
        p.a = 100; // public
        p.b = 200; // protected
        p.c = 300; // default
        //p.d = 400; // private
    }
}
