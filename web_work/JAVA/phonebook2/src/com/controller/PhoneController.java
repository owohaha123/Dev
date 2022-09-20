package com.controller;

import com.dao.PhoneDao;
import com.dto.PhoneInfo;
import com.view.InOutClass;

public class PhoneController {
    private InOutClass io = new InOutClass();
    private PhoneDao pDao = new PhoneDao();

    // 전체 제어 메소드
    public void run(){
        int menu = -1;
        // 타이틀 출력
        io.twoPrint("연락처 관리 프로그램 v2");
        io.twoPrint("====================");

        while (true){
            menuShow();
            menu = io.inNum("입력 > ");

            if(menu == 0){
                io.twoPrint("프로그램 종료");
                break;
            }
            switch (menu){
                case 1:
                    inputData();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                default:
                    io.twoPrint("0~5번까지 입력하세요");
            }
        }
    }

    private void inputData() {
        int submenu = -1;
        // 서브타이틀 출력
        io.twoPrint("<< 연락처 입력 >>");
        io.twoPrint("----------------");

        while (true){
            subMenuShow();
            submenu = io.inNum("입력 > ");

            if(submenu == 0){
                io.twoPrint("메인메뉴로 돌아갑니다. \n");
                break;
            }
            switch (submenu) {
                case 1:
                    inputNormal();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:
                    io.twoPrint("0~3번까지 입력하세요");
            }

        }// while end
    }// inputData end

    private void inputNormal() {
        // 각 연락처(일반, 학교, 회사)별 일련번호
        int no = 0;
        if(pDao.pListSize(1) == 0){
            no = 1;
        }else{
            // 마지막 데이터의 번호를 구하고 +1 한다
            no++; // 임시로 처리 (삭제 예정)
        }

        PhoneInfo pInfo = new PhoneInfo();
        pInfo.setNo(no); // 일련번호 저장
        pInfo.setName(io.inStr("이름 : "));
        pInfo.setPhone(io.inStr("연락처 : "));
        pInfo.setBirth(io.inStr("생일 : "));
        pInfo.setAge(io.inNum("나이 : "));

        pDao.inputData(pInfo);
    }

    // 서브메뉴 출력 메소드
    public void subMenuShow(){
        io.twoPrint("1. 일반 연락처");
        io.twoPrint("2. 학교 연락처");
        io.twoPrint("3. 회사 연락처");
        io.twoPrint("0. 돌아가기");
    }


    // 메뉴출력 메소드
    private void menuShow(){
        io.twoPrint("1. 연락처 입력");
        io.twoPrint("2. 연락처 출력");
        io.twoPrint("3. 연락처 검색");
        io.twoPrint("4. 연락처 수정");
        io.twoPrint("5. 연락처 삭제");
        io.twoPrint("0. 종료");
    }
}
