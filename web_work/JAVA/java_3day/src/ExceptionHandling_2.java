import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionHandling_2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n1 = 0, n2 = 0, result = 0;
        try{
            System.out.print("N1 : ");
            n1 = scan.nextInt();
            System.out.print("N2 : ");
            n2 = scan.nextInt();

            result = div(n1, n2);
        } catch (InputMismatchException ie){
            System.out.println("입력 미스!");
            return;
        } catch (ArithmeticException ae){
            System.out.println("0으로 나눌 수 없습니다.");
            return;
        }

        System.out.println("나눗셈 결과 : " + result);
    }

    static int div(int n1, int n2) throws ArithmeticException{
        int result = 0;

        result = n1 / n2;

        return result;
    }
}
