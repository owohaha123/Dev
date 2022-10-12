package com.view;

import com.dto.ClubDto;
import com.dto.JoinDto;
import com.dto.MemberDto;

import java.util.List;

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
        ioc.twoPrint("0. 종료");
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
        ioc.twoPrint("0. 종료");
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

    // ---------------------------------------------------------------------------윤주-----------------------

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

    public void insertClub(ClubDto data) {
        // 기능 타이틀 출력
        subTitle("동호회 개설");
<<<<<<< Updated upstream
=======

>>>>>>> Stashed changes
        // 데이터 입력
        data.setCb_name(ioc.inStr("동호회 명 : "));
        data.setCb_content(ioc.inStr("소개 : "));
    }

    public ClubDto outData(List<ClubDto> data) {
        subTitle("가입한 동아리");
            if(data == null){
            printMsg("가입된 동아리가 없습니다");
            return null;
        }

        int index = 1;
        for(ClubDto item : data){
            ioc.twoPrint(String.valueOf(index));
            ioc.twoPrint(item.toString());
            ioc.twoPrint("----------------");
            index++;
        }

        int deleteNo = ioc.inNum("번호입력 > ");

<<<<<<< Updated upstream
        return data.get(deleteNo-1);
    }

    public String isDelete() {
        String yn = ioc.inStr("탈퇴하시겠습니까? (Y/N)");
        return yn;
    }

    // ---------------------------------------------------------------------------동수-----------------------
    public int clubMenu() {
        int submenu = -1;
        ioc.twoPrint("1. 야구 동호회");
        ioc.twoPrint("2. 독서 동호회");
        ioc.twoPrint("3. 고양이 동호회");
        ioc.twoPrint("0. 이전 화면으로");
        submenu = ioc.inNum("입력 > ");
        return submenu;
    }

    public void ballClub(JoinDto data) {
        // 기능 타이틀 출력
        subTitle("야구 동호회 가입");
        // 데이터 입력
        data.setJm_id(ioc.inStr("ID : "));
        data.setJcb_no(ioc.inNum("동호회 번호 : "));
        data.setJ_date(ioc.inStr("가입 날짜 : "));
    }

    public void bookClub(JoinDto data) {
        // 기능 타이틀 출력
        subTitle("독서 동호회 가입");
        // 데이터 입력
        data.setJm_id(ioc.inStr("ID : "));
        data.setJcb_no(ioc.inNum("동호회 번호 : "));
        data.setJ_date(ioc.inStr("가입 날짜 : "));
    }

    public void catClub(JoinDto data) {
        // 기능 타이틀 출력
        subTitle("고양이 동호회 가입");
        // 데이터 입력
        data.setJm_id(ioc.inStr("ID : "));
        data.setJcb_no(ioc.inNum("동호회 번호 : "));
        data.setJ_date(ioc.inStr("가입 날짜 : "));
    }

    public void clubList1(List<ClubDto> cList) {
        // 서브 타이틀 출력
        subTitle("동호회 목록");

        // 데이터의 유무를 확인
        if(cList == null){ // 빈 목록
            printMsg("Empty.");
            return;
        }
        for (ClubDto data : cList){
            ioc.onePrint(data.toString2());
            ioc.twoPrint("--------------");
        }
    }

    public void clubMemberList(List<JoinDto> jList) {
        // 서브 타이틀 출력
        subTitle("동호회에 가입되어 있는 회원 목록");

        // 데이터의 유무를 확인
        if(jList == null){ // 빈 목록
            printMsg("Empty.");
            return;
        }
        for (JoinDto data : jList){
            ioc.onePrint(data.toString());
            ioc.twoPrint("--------------");
        }
=======
    }
    public void joinClub(JoinDto data) {

>>>>>>> Stashed changes
    }
}// class end
