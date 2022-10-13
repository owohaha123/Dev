package com.view;

import com.dao.DataDao;
import com.dto.ClubDto;
import com.dto.JoinDto;
import com.dto.MemberDto;

import java.util.List;

// 프로그램의 입출력을 담당하는 클래스
public class DataView {
    private InOutClass ioc = new InOutClass();
    private DataDao dDao = new DataDao();


    // 메인 화면(로그인 및 회원가입)
    public int showMain() {
        int main = -1;
        // 타이틀 출력
        ioc.twoPrint("");
        ioc.twoPrint("<<동호회 관리 프로그램>>");
        ioc.twoPrint("------------------------------");
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
        ioc.twoPrint("6. 동호회 탈퇴");
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
        ioc.twoPrint("------------------------------");
    }

    // ---------------------------------------------------------------------------은서-----------------------

    public void JoinView2(MemberDto data) {
        subTitle("회원가입");

        data.setM_id(ioc.inStr("ID : "));
        String mid = data.getM_id();
        boolean checkId = dDao.idCheck2(mid);


        if (!checkId) {
            data.setM_pwd(ioc.inStr("PWD : "));
            data.setM_name(ioc.inStr("NAME : "));
            data.setM_phone(ioc.inStr("PHONE : "));
            data.setM_birth(ioc.inStr("BIRTH(yyyy-mm-dd) : "));

            int res = dDao.JoinDao(data);

            if (res == 0) {
                ioc.twoPrint("회원가입 실패");
            } else {
                ioc.twoPrint("회원가입 성공");
            }
        } else {
            ioc.twoPrint("ID가 중복되었습니다.");
        }
    }

//    public String searchId2(String str) {
//        String id;
//
//        subTitle(str);
//
//        id = ioc.inStr("ID : ");
//
//        return id;
//    }

    public void updateMember(MemberDto data) {
        subTitle("Update Data");

        //변경을 하는 값만 받아서 저장.
        String pwd, name, phone, birth;

        pwd = ioc.inStr("PWD : ");
        if(!pwd.equals("")) { // 변경할 값을 입력한 상태
            data.setM_pwd(pwd);
        }

        name = ioc.inStr("NAME : ");
        if(!name.equals("")) {
            data.setM_name(name);
        }

        phone = ioc.inStr("PHONE : ");
        if(!phone.equals("")) {
            data.setM_phone(phone);
        }

        birth = ioc.inStr("BIRTH(yyyy-mm-dd) : ");
        if(!birth.equals("")) {
            data.setM_birth(birth);
        }
    }

    public void outMember(MemberDto data) {
        ioc.twoPrint("------------------------------");

        if(data == null){
            printMsg("No Data.");
            return;
        }

        ioc.onePrint(data.toString());
        ioc.twoPrint("------------------------------");
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
            ioc.twoPrint("------------------------------");
            index++;
        }

        int deleteNo = ioc.inNum("번호입력 > ");

        return data.get(deleteNo-1);
    }

    public String isDelete() {
        String yn = ioc.inStr("탈퇴하시겠습니까? (Y/N)");
        return yn;
    }


    // ---------------------------------------------------------------------------동수-----------------------

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
    }

    public void clubEnter(JoinDto data) {
        // 서브 타이틀 출력
        ioc.twoPrint("가입을 환영합니다.");
        ioc.twoPrint("--------------");

        // 데이터 입력
        data.setJm_id(ioc.inStr("가입할 회원의 ID : "));
        data.setJcb_no(ioc.inNum("가입할 동호회 번호 : "));
        data.setJ_date(ioc.inStr("가입 날짜 : "));
    }

}// class end
