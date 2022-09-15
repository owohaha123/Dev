import java.util.Scanner;

public class ExceptionHandling {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = null;
        int n1 = 0 , n2 = 0, result =0;

        try {
            System.out.print("Number1 : ");
            s = scan.nextLine();
            n1 = Integer.parseInt(s);
            System.out.print("Number2 : ");
            s = scan.nextLine();
            n2 = Integer.parseInt(s);

            result = n1 / n2;
        } catch (NumberFormatException nfe){
            System.out.println("예외사항이 발생되었습니다.");
        } catch (ArithmeticException ae){
            System.out.println("0으로 나눌 수 없습니다.");
        } catch (Exception e) {
            System.out.println("예외사항이 발생했습니다.");
        } finally {
            System.out.println("이 문장은 항상 나옵니다.");
        }


        System.out.println(result);
    }
}
