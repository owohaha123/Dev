public class TypeCast {
    public static void main(String[] args) {
        byte b = 10;
        int ivalue = b; // 자동형변환
        //int ivalue = (int)b; 가 정석이나 적어주지 않아도 자동으로 처리

        short sh = (short)ivalue; // 강제형변환(형변환 연산자 사용)

        System.out.println(sh); // 10

        int i2 = 100000;
        sh = (short)i2;
        System.out.println(sh); // -31072

        float pi = 3.14f;
        long i3 =(long)pi;
        System.out.println(i3); // 3

        // 사칙연산이 형변환에 영향을 주기도 함
        String str = "" + pi; // 문자열이 가장 큰 데이터 타입
                              // 연산 내부에서 pi 가 String 으로 자동형변환

        // 연산식에서 자동형변환 : 연산순서에 따라 자동형변환
        float rs = pi * 5; // 5(int)가 float 로 변환!
        System.out.println(rs); // 15.700001

        // 형변환 시점에 따른 차이 (연산 먼저 실행하는 것이 좋음)
        float ff = 5.89f;
        int rsi = (int)ff * 6; // ff의 형변환이 먼저 진행
        System.out.println(rsi); // 30
        int rsi2 = (int)(ff * 6); // 계산 후 형변환 (좀 더 근접)
        System.out.println(rsi2); // 35

        String rsi3 = 5 + 4 + "";
        System.out.println(rsi3); // "9"(문자열)
        rsi3 = "" + 5 + 4;
        System.out.println(rsi3); // 54("5""4" , 문자열)
        // rsi3 = "" + (5 + 4);
        // System.out.println(rsi3); // "9"(문자열)
        rsi3 = 5 + "" + 4;
        System.out.println(rsi3); // 54(상동)

        // 숫자 -> 문자열 변환 메소드 : String.valueOf(숫자);
        String sss = String.valueOf(5);

        //★형변환은 데이터가 대상 (변수는 대상이 아니기에 변경x)

        // Wrapper Class
        String numStr = "1000";
        // 정수문자열 -> 정수
        int numInt = Integer.parseInt(numStr);
        // 실수문자열 -> 실수
        numStr = "3.14";
        float numFloat = Float.parseFloat(numStr);

        float dres = (float)(5 / 3);
        //float dres = (float)5 / 3; // 1.66666....
        //float dres = 5.0f / 3; // 1.66666....
        System.out.println(dres); // 1.0 (몫만)

        int ires = 5 / 3;
        System.out.println("몫 : " + ires);
        int r = 5 % 3;
        System.out.println("나머지 :" + r);
    }
}
