package com.view;

import java.util.Scanner;

public class InOutClass {
    // 1. 키보드로부터 데이터의 입력
    private Scanner scan = new Scanner(System.in);

    // 문자열 입력 메소드
    public String inStr(String str){
        // 입력 유도용 안내문구(str)를 출력하고 입력값을 받아서 넘김
        onePrint(str);
        String s = scan.nextLine();

        return s;
    }

    // 정수 입력용 메소드
    public int inNum(String str){
        onePrint(str);
        String s = scan.nextLine();
        int num = -1;

        // 미입력 시 처리
        if(s.equals("")){
            num = -1;
            return num; // 메소드 종료
        }
        // 숫자가 아닌 문자 입력 시 처리
        try{
            num = Integer.parseInt(s);
        }catch (Exception e){
            twoPrint("잘못된 입력!");
            num = -1;
        }
        return num;
    }

    // 2. 모니터로 데이터 출력
    // 줄바꿈 안하는 출력 메소드
    public void onePrint(String str){
        System.out.print(str);
    }

    // 줄바꿈 하는 출력 메소드
    public void twoPrint(String str){
        System.out.println(str);
    }
}
