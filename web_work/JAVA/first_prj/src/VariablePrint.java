import java.util.Scanner;

public class VariablePrint {
    public static void main(String[] args) {
        // 변수에 데이터 대입
        int number1 = 0; // 변수의 선언 및 초기화
        // 메소드 내부에 변수를 만들 경우 초기화를 하는 것이 좋다.
        number1 = 350; // 임의의 값을 대입
        // '=' : 대입연산자. 우변의 값(또는 변수, 수식의 결과)을 좌변의 변수에 입력
        int number2 = number1;

        number2 = number1 + 250;

        boolean b = (number1 == number2);
        boolean b2 = b;
        // b2 = number1; // 다른 타입의 변수로 대입 불가
        // 형변환(Type Casting , 다른 타입으로 변환)

// ------------------------------------------------------------

        System.out.println(number1); // 350
        System.out.println("안녕하세요~");
        System.out.println(b); // false
        System.out.println('a');

// ------------------------------------------------------------
        // 출력문 3가지 형태

        // 1. println : 출력 후 다음 라인으로 커서 이동
        // 2. print :
        System.out.print("첫 번째 print 출력.");
        System.out.print("두 번째 print 출력.");
        System.out.println(); // 라인만 바꿔줌
        System.out.println();
        System.out.println();
        System.out.println();
        Scanner scan = new Scanner(System.in);
        //System.out.print("입력> ");
        //String input = scan.nextLine();

        for(int i = 1; i <= 31; i++){
            System.out.print("\t" + i); // \t : tab 키
            if (i % 7 == 0){
                System.out.println();
            }
        }
        System.out.println(); // 줄바꿈

        // 3. printf("형식지정", 변수들); <- 잘 안 씀
        System.out.printf("number2의 값은 %d 입니다.\n", number2);
        // \n : 줄바꿈 강제 , %d : 정수변수의 값 출력 시
        // print 처럼 줄바꿈을 하지 않는다.

        float fnum = 3.14f;
        System.out.printf("파이는 %f이다.\n" , fnum);
        // %ㄹ : 실수변수의 값 출력 시
        char ch = 'A';
        String str = "Hello";
        System.out.printf("문자는 %c 이고, 문자열은 %s 입니다.\n" , ch , str);
        // %c : 문자변수의 값 출력 시 , %s : 문자열변수의 값 출력 시
        System.out.println("문자는 " + ch + "이고, 문자열은 " + str + "입니다.");
    }
}
