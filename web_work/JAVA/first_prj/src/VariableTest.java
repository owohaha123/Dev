public class VariableTest {
    public static void main(String[] args) {
        // 문자형(Character)
        char ch;
        ch = 'A'; // 반드시''사용 ! 1글자만 가능
        char aaaaaa;
        char Aaaaaa;
        char zzzzz;
        // 작명법: 대소문자 구분. a~z, A~Z, 0~9, _, $만 사용가능
        //        (숫자는 첫글자 사용x. 글자사이 공백x)
        // 권장사항 : 첫글자는 반드시 소문자로 작성할 것

        // 정수형 변수
        byte numByte;
        short numShort;
        int numInt; // 가장 많이 사용하는 형태
        // long zzzzz; // 타입이 달라도 같은 변수명을 쓸 수 없다.
        long numLong = 100L; // 접미사 'L'(생략o). long 타입의 값을 표시

        // 실수형 변수
        float f = 0.0f;  // 접미사 'f'(생략x). 이 두 경우만 표시
        double du = 0.0;

        float f2; // 이 땐 f 안 붙여도 작동가능
        int iva = 10;
        f2 = iva;
        //System.out.println(f2);

        boolean b = true;
        boolean bb = false;

        // 참조형 String
        String str = "이건 문장입니다.";

        int n1 = 100;
        int n2 = 200;

        boolean res = (n1 == n2);
        //System.out.println(res);

        String sb1 = "abc";
        String sb2 = "abc";
        res = (sb1 == sb2); // true
        System.out.println(res);

        String s1 = new String("abc");
        String s2 = new String("abc");
        res = (s1 == s2); // false (★저장위치가 다름!)
        System.out.println(res);
        res = (s1.equals(s2)); // true (문자열 비교는 'equals' 사용)
        System.out.println(res);

    }
}
