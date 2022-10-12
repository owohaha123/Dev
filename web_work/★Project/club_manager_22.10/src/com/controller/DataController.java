package com.controller;

import com.dto.ClubDto;
import com.dto.JoinDto;
import com.dto.MemberDto;
import com.service.DataService;
import com.view.DataView;

import java.util.List;

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
                    joinClub();
                    break;
                case 2:
                    insertClub();
                    break;
                case 3:
                    clubList();
                    break;
                case 4:
                    memberList();
                    break;
                case 5:
                    //updateMyData();
                    break;
                case 6:
                    outClub();
                    break;
                default:
                    dView.printMsg("Input Error! select 0~6");
            }

        }// while end
    }// run end

    // ---------------------------------------------------------------------------동수-----------------------
    private void joinClub() { // case 1 -> 동호회 가입 하기
        int submenu = -1;
        // 서브타이틀 출력
        dView.printMsg("<< 동호회 선택 >>");

        while (true) {
            submenu = dView.clubMenu();

            if (submenu == 0){
                dView.printMsg("이전 화면으로 돌아갑니다.");
                break;
            }

            switch (submenu){
                case 1:
                    ballClub();
                    break;
                case 2:
                    bookClub();
                    break;
                case 3:
                    catClub();
                    break;
                default:
                    dView.printMsg("0~3번까지만 입력하세요.");
            }
        }
    }
    private void ballClub() {
        // 데이터를 입력 받는다.
        JoinDto data = new JoinDto();
        // view에서 입력 처리.
        dView.ballClub(data);
        // DB에 저장 -> service로 전달
        String msg = dServ.insertClub2(data);
        // 메세지 출력 -> view
        dView.printMsg(msg);
    }

    private void bookClub() {
        // 데이터를 입력 받는다.
        JoinDto data = new JoinDto();
        // view에서 입력 처리.
        dView.bookClub(data);
        // DB에 저장 -> service로 전달
        String msg = dServ.insertClub3(data);
        // 메세지 출력 -> view
        dView.printMsg(msg);
    }

    private void catClub() {
        // 데이터를 입력 받는다.
        JoinDto data = new JoinDto();
        // view에서 입력 처리.
        dView.catClub(data);
        // DB에 저장 -> service로 전달
        String msg = dServ.insertClub4(data);
        // 메세지 출력 -> view
        dView.printMsg(msg);
    }
    private void clubList() { // case 3 -> 동호희 목록 보기
        // service에게 전체 목록을 가져오도록 위임.
        List<ClubDto> cList = dServ.getList();
        // 목록을 view가 출력하도록 넘김.
        dView.clubList1(cList);
    }

    private void memberList() { // case 4 -> 동호회에 가입된 회원 보기
        // service에게 전체 목록을 가져오도록 위임.
        List<JoinDto> jList = dServ.getList1();
        // 목록을 view가 출력하도록 넘김.
        dView.clubMemberList(jList);
    }

    // ---------------------------------------------------------------------------윤주-----------------------
    private void outClub() {
        List<ClubDto> data = dServ.getData(userData.getM_id());
        ClubDto deleteData = dView.outData(data);

        if(data != null){
            String yn = dView.isDelete();
            if(yn.equals("y")){
                String msg = dServ.DeleteData(deleteData, userData.getM_id());
                dView.printMsg(msg);
            }
        }
    }

    private void insertClub() {
        // 3가지 데이터를 입력 받는다 (str, int, date)
        // view 에서 입력처리
        ClubDto data = new ClubDto();
        dView.insertClub(data);
        // DB 에저장 -> service 로 전달 (성공/실패에 대한 메시지를 줌)
        String msg = dServ.insertClub(data,userData.getM_id());
        // 메시지 출력 -> view
        dView.printMsg(msg);
    }

    private void loginData() {
        String id = dView.loginId("로그인");
        String pw = dView.loginPw();

        if(dView.loginResult(dServ.login(id, pw))){// true 면 실행
            userData = dServ.getMemberById(id);
            loginStatus = true;
        }
    }


}// class end
