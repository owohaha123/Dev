import java.util.Scanner;

public class TwoDimensionArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int stNum = 0;
        System.out.print("학생 수 : ");
        stNum = scan.nextInt();

        // 공간의 개수 = 학생수 * 3(과목수)
        int score[][] = new int[stNum][3];

        // 학생수 별 3과목 성적입력
        for(int i = 0; i < score.length; i++){  // score.length 대신 stNum 도 가능
            for(int j = 0; j < score[i].length; j++){ // score[i].length 대신 3 도 가능
                System.out.print(i + "번 학생의 " + j + "번째 성적 : ");
                score[i][j] = scan.nextInt();
            }
        }
    } // main end
} // class end
