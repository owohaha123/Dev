package com.controller;

import com.dto.PhoneInfo;
import com.view.InOutClass;

import java.util.ArrayList;

public class PhoneController {
    // 입출력 장치 객체
    private InOutClass io = new InOutClass();
    // 연락처 저장 공간
    ArrayList<PhoneInfo> book = new ArrayList<>();

    // 전체 제어 메소드
    public void run(){
        // 메뉴 번호 저장 변수
        int menu = -1;
        // 타이틀 출력
        io.twoPrint("연락처 관리 프로그램");
        io.twoPrint("=================");

        while (true){
            // 메뉴 출력
            menuShow();

            menu = io.inNum("입력 > ");

            if(menu == 0){
                io.twoPrint("프로그램 종료");
                break;
            }
            // 메뉴 번호에 따라 기능 처리
            switch (menu){
                case 1: // 입력 메소드 실행
                    inputData();
                    break;
                case 2: // 출력 메소드 실행
                    outputData();
                    break;
                case 3: // 검색 메소드 실행
                    searchData();
                    break;
                case 4: // 수정 메소드 실행
                    break;
                case 5: // 삭제 메소드 실행
                    break;
                default:
                    io.twoPrint("0~5번까지 입력하세요");
            }
        }// while end
    }// run end


    // 메뉴 출력 메소드
    private void menuShow(){
        io.twoPrint("1. 연락처 입력");
        io.twoPrint("2. 연락처 출력");
        io.twoPrint("3. 연락처 검색");
        io.twoPrint("4. 연락처 수정");
        io.twoPrint("5. 연락처 삭제");
        io.twoPrint("0. 종료");
    }

    // 1. 입력 메소드
    private void inputData(){
        io.twoPrint("---연락처 입력---");
        io.twoPrint("----------------");
        // 한명분의 연락처 생성
        PhoneInfo pInfo = new PhoneInfo();
        pInfo.setName(io.inStr("이름 : "));
        pInfo.setPhone(io.inStr("연락처 : "));
        pInfo.setBirth(io.inStr("생일(mm-dd) : "));
        pInfo.setAge(io.inNum("나이 : "));

        // 연락처 목록에 연락처 추가
        book.add(pInfo);
        io.twoPrint("입력 완료 \n");
    }

    // 2. 출력 메소드
    private void outputData(){
        // 저장된 정보가 있는지 확인
        if(book.size() == 0){
            io.twoPrint("정보가 없습니다 \n");
            return; // 메소드 종료
        }
        io.twoPrint("--- 연락처 출력 ---");
        io.twoPrint("------------------");
        for(PhoneInfo p : book){
            io.twoPrint("이름 : " + p.getName());
            io.twoPrint("연락처 : " + p.getPhone());
            io.twoPrint("생일 : " + p.getBirth());
            io.twoPrint("나이 : " + p.getAge());
            io.twoPrint("------------------------");
        }
        io.twoPrint("출력 완료 \n");
    }

    // 3. 검색 메소드
    private void searchData() {
        if(book.size() == 0){
            io.twoPrint("정보가 없습니다 \n");
            return; // 메소드 종료
        }
        io.twoPrint("--- 연락처 검색 ---");
        io.twoPrint("------------------");        // 1. 검색 키워드(이름)을 입력 받는다
        String sname = io.inStr("검색할 이름 : ");
        // 2. 목록에서 입력받은 키워드와 같은 데이터를 비교
        for(PhoneInfo p : book){
            if(sname.equals(p.getName())){
                io.twoPrint("이름 : " + p.getName());
                io.twoPrint("연락처 : " + p.getPhone());
                io.twoPrint("생일 : " + p.getBirth());
                io.twoPrint("나이 : " + p.getAge());
                io.twoPrint("검색 완료 \n");
                return;
            }
        }
        // 다음 문장은 검색결과가 없을 경우에만 실행
        io.twoPrint("찾는 이름이 없습니다 \n");
    }

    // 4. 수정 메소드

    // 5. 삭제 메소드
}
