// 라이브러리
import java.util.Scanner;

public class Hello {
    // 메인 메소드
    // 한 program 에는 반드시 1개의 main 이 있어야 함
    public static void main(String[] args) {
        // 화면에 문장을 출력 :
        System.out.println("hello world!");
        System.out.println("안녕하세요~");
        // 키보드로 값 입력 :
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        System.out.println("입력받은 값 : " + num);

        Car mycar = new Car(); // 인스턴스 생성
        mycar.model = "소나타";
        mycar.company = "현대";
        mycar.tier = 4;
        mycar.color = "검정색";
        mycar.exel(100);
        mycar.stop();
    } // main end
} // class end
