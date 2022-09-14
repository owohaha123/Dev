import java.util.Scanner;

public class ControllerClass {
    // 프로그램의 모든 부분을 처리하는 인스턴스를 설계해 놓은 클래스
    // title : 관리프로그램
    // menu : 1. 입력 / 2. 출력 / 0. 종료

    public void run(){
        String menu; // 메뉴번호 저장 변수
        // 입력 객체(Scanner) 준비
        Scanner scan = new Scanner(System.in);

        System.out.println("⭐관리 프로그램⭐");
        System.out.println("================");

        // 메뉴출력 ~ 종료 (무한반복)
        while(true){
            System.out.println("1. 입력");
            System.out.println("2. 출력");
            System.out.println("0. 종료");
            System.out.print("입력> ");
            // 메뉴 번호 받기
            menu = scan.nextLine();

            // 종료 처리
            if(menu.equals("0")){ // 사용자가 "0"을 입력함
                System.out.println("프로그램 종료");
                break; // while 문 종료
                // return; // run 종료
            }

            // 나머지 메뉴 및 잘못 입력한 값 처리
            switch (menu){
                case "1":
                    System.out.println("입력을 실행합니다");
                    break;
                case "2":
                    System.out.println("출력을 실행합니다");
                    break;
                default:
                    System.out.println("잘못 입력하였습니다");
                    break;
            }
        } // while end
    }// run end
}// class end
