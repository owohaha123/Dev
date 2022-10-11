package com.view;

import com.dto.ClubDto;
import com.dto.MemberDto;

// 프로그램의 입출력을 담당하는 클래스
public class DataView {
    private InOutClass ioc = new InOutClass();

    // 메인 화면(로그인 및 회원가입)
    public int showMain() {
        int main = -1;
        // 타이틀 출력
        ioc.twoPrint("");
        ioc.twoPrint("<<동호회 관리 프로그램>>");
        ioc.twoPrint("---------------------------");
        // 메뉴 출력
        ioc.twoPrint("1. 로그인");
        ioc.twoPrint("2. 회원가입");
        ioc.twoPrint("0. Quit");
        // 메뉴 번호 입력
        main = ioc.inNum("번호입력 > ");
        return main;
    }// main end

    // 타이틀 및 메뉴 출력, 메뉴 번호 입력 메소드
    public int showFirst(){
        int menu = -1;

        // 메뉴 출력
        ioc.twoPrint("Menu > ");
        ioc.twoPrint("1. 동호회 가입");
        ioc.twoPrint("2. 동호회 개설");
        ioc.twoPrint("3. 동호회 목록 보기");
        ioc.twoPrint("4. 동호회 멤버 보기");
        ioc.twoPrint("5. 내 정보 관리");
        ioc.twoPrint("6. 동아리 탈퇴");
        ioc.twoPrint("0. Quit");
        // 메뉴 번호 입력
        menu = ioc.inNum("번호입력 > ");

        // 입력받은 메뉴번호를 controller 에 전달
        return menu;
    }// showFirst end

    // 메시지 출력용 메소드
    public void printMsg(String str){
        ioc.twoPrint(str);
    }

    public void subTitle(String str){
        ioc.twoPrint("<" + str + ">");
        ioc.twoPrint("----------------");
    }

    public String loginId(String str) {
        String id = null;
        //서브 타이틀 출력
        subTitle(str);

        id = ioc.inStr("ID : ");

        return id;
    }// loginId end


    public String loginPw() {
        String pw = null;

        pw = ioc.inStr("PW : ");

        return pw;
    }

    public boolean loginResult(String result){
        ioc.twoPrint(result);

        if(result == "로그인 성공") {
            return true;
        }else{
            showMain();
            return false;
        }
    }

    public ClubDto insertClub() {
        // 기능 타이틀 출력
        subTitle("동호회 개설");

        ClubDto data = new ClubDto();
        // 데이터 입력
        data.setCb_name(ioc.inStr("동호회 명 : "));
        data.setCb_content(ioc.inStr("소개 : "));

        return data;
    }
}// class end
