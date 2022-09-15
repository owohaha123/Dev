package controller;

import dto.DataDto;

import java.util.ArrayList;
import java.util.Scanner;

public class ControllerClass {
    // 멤버로 Scanner 작성
    Scanner scan = new Scanner(System.in);
    // 데이터 저장 공간 (ArrayList) - 정수배열
    ArrayList<Integer> nums = new ArrayList<>();

    public void run(){
        DataDto dd = new DataDto();
        // dd.number = 100; // private
        dd.setNumber(100);

        // 지역변수는 초기화를 가급적 하자!
        // String(객체)은 null 로 처리
        String menu = null;

        System.out.println("⭐⭐관리 프로그램⭐⭐");
        System.out.println("=====================");

        while(true){
            System.out.println("1. 입력");
            System.out.println("2. 출력");
            System.out.println("0. 종료");
            System.out.print("입력> ");
            menu = scan.nextLine();

            if(menu.equals("0")){
                System.out.println("프로그램 종료");
                break; // 또는 return;
            }

            switch (menu){ // 정수변수, 문자열변수 (문자변수)
                case "1":
                    inputData();
                    break;
                case "2":
                    outputData();
                    break;
                default: // 잘못된 입력처리
                    System.out.println("0~1번 중에 하나를 입력하세요");
            }
        }
    }// run end

    // 입력 처리용 메소드
    void inputData(){
        System.out.println("⭐ 입력(숫자 입력) ⭐");
        System.out.println("--------------------");
        System.out.print("값 입력: ");
        String inValue = scan.nextLine();
        int num = 0;

        // 사용자가 숫자가 아닌 값을 입력한다면?
        // try - catch 로 오류 처리
        try{
            num = Integer.parseInt(inValue);
        }catch (NumberFormatException nfe){
            System.out.println("숫자를 입력하세요.");
            return;
        }

        // ArrayList 에 값 추가 : add()
        nums.add(num); // push 와 같은 일을 하는 메소드
        System.out.println("입력 완료. 이전 메뉴로 돌아갑니다.");
    }
    void outputData(){
        System.out.println("⭐ 전체 출력 ⭐");
        System.out.println("---------------");

        // 데이터의 유무 확인하여 없을 경우 메소드를 종료한다
        if(nums.size() == 0){
            System.out.println("데이터가 없습니다.");
            return;
        }
        int sum = 0;
        for(int n : nums){
            System.out.println(n);
            sum += n;
        }
        System.out.println("총합 : " + sum);
        System.out.println("출력 완료. 이전 메뉴로 돌아갑니다");
    }
}// class end
