package com.controller;

import com.dao.PhoneDao;
import com.dto.PhoneComInfo;
import com.dto.PhoneInfo;
import com.dto.PhoneSchInfo;
import com.view.InOutClass;

public class PhoneController {
    private InOutClass io = new InOutClass();
    private PhoneDao pDao = new PhoneDao();

// --------------------------- 전체 제어 메소드 run() --------------------------------
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
                    outputData();
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

// ----------------------- 출력 메소드 outputData() -----------------------
    private void outputData() {
        // 연락처가 모두 비어있는 경우
        if(pDao.pListSize(1) == 0
            && pDao.pListSize(2) == 0
            && pDao.pListSize(3) == 0){
            io.twoPrint("저장된 연락처가 없습니다 \n");
            return;
        }

        int submenu = -1;
        // 서브타이틀 출력
        io.twoPrint("<< 연락처 출력 >>");
        io.twoPrint("----------------");

        while (true) {
            // 출력 하위 메뉴
            io.twoPrint("1. 전체 출력");
            io.twoPrint("2. 구분 출력");
            io.twoPrint("0. 돌아가기");
            submenu = io.inNum("입력 > ");

            if(submenu == 0){
                io.twoPrint("메인메뉴로 돌아갑니다. \n");
                break;
            }
            switch (submenu){
                case 1: // 1. 전체 출력
                    outputTotal();
                    break;
                case 2: // 2. 구분 출력 (일반, 학교, 회사)

                    break;
                default:
                    io.twoPrint("0~2번까지 입력하세요");
            }
        }
    }

// ----------------------- 전체출력 메소드 outputTotal()
    private void outputTotal() {
        // 전체 출력 메소드
        io.twoPrint("< 전체출력 >");
        io.twoPrint("-----------");
        // 일반 출력 > 학교 출력 > 회사 출력
        for(int i = 0; i < pDao.pListSize(1); i++){
            io.twoPrint("<<<일반 연락처>>>");
            io.twoPrint(pDao.getPhoneInfo(i).toString());
            io.twoPrint("----------------");
        }
        for(int j = 0; j < pDao.pListSize(2); j++){
            io.twoPrint("<<<학교 연락처>>>");
            io.twoPrint(pDao.getSchInfo(j).toString());
            io.twoPrint("----------------");
        }
        for(int k = 0; k < pDao.pListSize(3); k++){
            io.twoPrint("<<<회사 연락처>>>");
            io.twoPrint(pDao.getComInfo(k).toString());
            io.twoPrint("----------------");
        }
        io.twoPrint("출력 완료!!! \n");
    }

// ----------------------- 입력 메소드 inputData() -----------------------
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
                    inputSchool();
                    break;
                case 3:
                    inputCompany();
                    break;
                default:
                    io.twoPrint("0~3번까지 입력하세요");
            }

        }// while end
    }// inputData end

// ----------------------- 회사입력 메소드 inputCompany()
    private void inputCompany() {
        int no = 0;
        if(pDao.pListSize(3) == 0){
            no = 1;
        }else{
            no = pDao.getLastNum(3) + 1;
        }
        PhoneComInfo pInfo = new PhoneComInfo();
//        pInfo.setNo(no); // 일련번호 저장
//        pInfo.setName(io.inStr("이름 : "));
//        pInfo.setPhone(io.inStr("연락처 : "));
//        pInfo.setBirth(io.inStr("생일 : "));
//        pInfo.setAge(io.inNum("나이 : "));

        pInfo.setCompany (io.inStr("회사 : "));
        pInfo.setDept(io.inStr("부서 : "));
        pInfo.setLevel(io.inStr("직급 : "));

        pDao.inputData(pInfo);
    }

// ----------------------- 학교입력 메소드 inputSchool()
    private void inputSchool() {
        int no = 0;
        if(pDao.pListSize(2) == 0){
            no = 1;
        }else{
            no = pDao.getLastNum(2) + 1;
        }
        PhoneSchInfo pInfo = new PhoneSchInfo();
//        pInfo.setNo(no); // 일련번호 저장
//        pInfo.setName(io.inStr("이름 : "));
//        pInfo.setPhone(io.inStr("연락처 : "));
//        pInfo.setBirth(io.inStr("생일 : "));
//        pInfo.setAge(io.inNum("나이 : "));

        pInfo.setSname(io.inStr("학교 : "));
        pInfo.setMajor(io.inStr("전공 : "));
        pInfo.setYear(io.inNum("학년 : "));

        pDao.inputData(pInfo);
    }

// ----------------------- 일반입력 메소드 inputNormal()
    private void inputNormal() {
        // 각 연락처(일반, 학교, 회사)별 일련번호
        int no = 0;
        if(pDao.pListSize(1) == 0){
            no = 1;
        }else{
            // 마지막 데이터의 번호를 구하고 +1 한다
            no = pDao.getLastNum(1) + 1;
        }

        PhoneInfo pInfo = new PhoneInfo();
//        pInfo.setNo(no); // 일련번호 저장
//        pInfo.setName(io.inStr("이름 : "));
//        pInfo.setPhone(io.inStr("연락처 : "));
//        pInfo.setBirth(io.inStr("생일 : "));
//        pInfo.setAge(io.inNum("나이 : "));

        pDao.inputData(pInfo);
    }

// -------------------------- 메뉴 출력 메소드  -------------------------------
// ----------------------- 서브메뉴 출력 메소드 subMenuShow()
    public void subMenuShow(){
        io.twoPrint("1. 일반 연락처");
        io.twoPrint("2. 학교 연락처");
        io.twoPrint("3. 회사 연락처");
        io.twoPrint("0. 돌아가기");
    }


// ----------------------- 메뉴출력 메소드 menuShow()
    private void menuShow(){
        io.twoPrint("1. 연락처 입력");
        io.twoPrint("2. 연락처 출력");
        io.twoPrint("3. 연락처 검색");
        io.twoPrint("4. 연락처 수정");
        io.twoPrint("5. 연락처 삭제");
        io.twoPrint("0. 종료");
    }
}
