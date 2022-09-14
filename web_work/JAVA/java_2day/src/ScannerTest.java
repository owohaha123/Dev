import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        // Scanner class 로 만든 instance (scan)
        Scanner scan = new Scanner(System.in);

        // 정수 입력 int 값
        System.out.print("정수 입력 : ");
        int i = scan.nextInt();
        System.out.println("입력받은 정수 값 : " + i);

        // 실수 입력 float 값
        System.out.print("실수 입력 : ");
        float f = scan.nextFloat();
        System.out.println("입력받은 실수 값 : " + f);
        //scan.nextLine(); // 개행문자 처리 (아래 nextLine() 오류 방지를 위함)

        // 문자열 입력
        System.out.println("문자열 입력 : ");
        //String str = scan.nextLine();
        String str = scan.next(); // next 는 개행문자 처리 x
        System.out.println("입력받은 문자열 값 : " + str);


        // hello world 입력시
        System.out.print("next() 사용 시 문자열 : ");
        String str2 = scan.next();
        System.out.println("next() : " + str2); // hello (띄어쓰기 이후 처리x)
        scan.nextLine();// 개행문자 처리

        System.out.println("nextLine() 사용 시 문자열 : ");
        String str3 = scan.nextLine();
        System.out.println("nextLine() : " + str3); // hello world
    }
}
