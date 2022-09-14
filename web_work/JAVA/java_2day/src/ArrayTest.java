import java.util.Scanner;

public class ArrayTest {
    public static void main(String[] args) {
        // 배열 선언
        int intArray[];
        // 배열 생성
        intArray = new int[10];

        // 배열 사용
        intArray[0] = 10;

        System.out.println(intArray[0]);

        intArray[9] = 200;

        String strArray[] = new String[5];
        strArray[0] = "abc";

        String fruits[] = {"apple","banana","pear"};
        System.out.println(fruits[1]);


        // 학생 수 만큼 성적을 저장하는 배열
        Scanner scan = new Scanner(System.in);
        System.out.println("학생 수  : ");
        int num = scan.nextInt();

        int score[] = new int[num];

        for(int i = 0; i < num; i++){ // num 대신 score.length 써도 가능
            System.out.print((i + 1) + "번 학생 점수 : ");
            score[i] = scan.nextInt();
        }
        int sum = 0;
        for(int j = 0; j < score.length; j++){
            sum += score[j];
        }
        System.out.println("총점 : " + sum);
    }
}
