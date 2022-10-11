package com.controller;

import com.dto.ClubDto;
import com.dto.MemberDto;
import com.service.DataService;
import com.view.DataView;

public class DataController {
    private DataView dView = new DataView();
    private DataService dServ = new DataService();
    private MemberDto userData;
    private boolean loginStatus = false;
    // 프로그램 전체 제어 메소드
    public void run(){
        int main = -1;

        while(!loginStatus) {
            // 타이틀 및 메뉴 출력, 메뉴번호 입력 -> view
            main = dView.showMain();

            // 종료처리
            if (main == 0) {
                // 종료 메시지 출력 -> view
                dView.printMsg("종료");
                break;
            }
            switch (main){
                case 1:
                  loginData();
                    break;
                case 2:
                  //signUpData();
                    break;
                default:
                    dView.printMsg("0~2의 숫자만 입력하세요");
            }
        }

        int menu = -1;

        // 종료 명령이 있을 때까지 반복
        while(true){
            // 타이틀 및 메뉴 출력, 메뉴번호 입력 -> view
            menu = dView.showFirst();

            // 종료처리
            if(menu == 0){
                // 종료 메시지 출력 -> view
                dView.printMsg("종료");
                break;
            }

            // 나머지 메뉴 처리
            switch (menu){
                case 1:
                    //joinClub();
                    break;
                case 2:
                    insertClub();
                    break;
                case 3:
                    //clubList();
                    break;
                case 4:
                    //memberList();
                    break;
                case 5:
                    //updateMyData();
                    break;
                case 6:
                    //outClub();
                    break;
                default:
                    dView.printMsg("Input Error! select 0~6");
            }

        }// while end
    }// run end

    private void insertClub() {
        // 3가지 데이터를 입력 받는다 (str, int, date)
        // view 에서 입력처리
        ClubDto data = dView.insertClub();
        // DB 에저장 -> service 로 전달 (성공/실패에 대한 메시지를 줌)
        String msg = dServ.insertClub(data,userData.getM_id());
        // 메시지 출력 -> view
        dView.printMsg(msg);
    }

    private void loginData() {
        String id = dView.loginId("로그인");
        String pw = dView.loginPw();

        //검색 값 service로 전달하여 해당 데이터 가져오기. -> service

        if(dView.loginResult(dServ.login(id, pw))){
            userData = dServ.getMemberById(id);
            loginStatus = true;
        }
    }


}// class end
