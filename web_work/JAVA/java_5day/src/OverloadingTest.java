public class OverloadingTest {
    public static void main(String[] args) {
        System.out.println(); // println : 대표적인 오버로딩 메소드

        simpleCal sc = new simpleCal();
        int result = sc.add(10,20);
        result = sc.add(1, 3.14f);
        float rf = sc.add(5.4f, 3.7f);
        result = sc.add(10, 20, 30);
    }
}

class simpleCal {
    public int add(int a, int b){ // 정수만 덧셈
        int r = a + b;
        return r;
    }

    public int add(int a, float b){ // 메소드 오버로딩
        float r = a + b;
        return (int)r;
    }

    public int add(int a, int b, int c){
        int r = a + b + c;
        return r;
    }

// 오버로딩이 안되는 경우
//    public float add(int x, int y){
//        float r = x + y;
//        return r;
//    }

    public float add(float a, float b){
        float r = a + b;
        return r;
    }
}
