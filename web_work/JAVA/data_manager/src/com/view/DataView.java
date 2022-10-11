package com.view;

import com.dto.DataDto;

import java.util.List;

// 프로그램의 입출력을 담당하는 클래스
public class DataView {
    private InOutClass ioc = new InOutClass();

    // 타이틀 및 메뉴 출력, 메뉴 번호 입력 메소드
    public int showFirst(){
        int menu = -1;

        // 타이틀 출력
        ioc.twoPrint("");
        ioc.twoPrint("<<Data Management Program>>");
        ioc.twoPrint("---------------------------");
        // 메뉴 출력
        ioc.twoPrint("Menu > ");
        ioc.twoPrint("1. Data Input");
        ioc.twoPrint("2. Data Output");
        ioc.twoPrint("3. Data Search");
        ioc.twoPrint("4. Data Update");
        ioc.twoPrint("5. Data Delete");
        ioc.twoPrint("0. Quit");
        // 메뉴 번호 입력
        menu = ioc.inNum("Select > ");

        // 입력받은 메뉴번호를 controller 에 전달
        return menu;
    }// showFirst end

    // 메시지 출력용 메소드
    public void printMsg(String str){
        ioc.twoPrint(str);
    }

    public void inputData(DataDto data) {
        // 기능 타이틀 출력
        subTitle("Data Input");
        // 데이터 입력
        data.setM_str(ioc.inStr("STR : "));
        data.setM_int(ioc.inNum("INT : "));
        data.setM_date(ioc.inStr("DATE(yyyy-mm-dd) : "));
    }

    public void subTitle(String str){
        ioc.twoPrint("<" + str + ">");
        ioc.twoPrint("----------------");
    }

    public void outputList(List<DataDto> dList) {
        // 서브타이틀 출력
        subTitle("Data Output");
        // 목록 내의 데이터 유무 확인
        if(dList == null){// 빈 목록
            printMsg("No Data");
            return; // 메소드 종료
        }

        for(DataDto data : dList){
            ioc.twoPrint(data.toString());
            ioc.twoPrint("----------------");
        }
    }

    public int searchCode(String str) {
        int code = 0;
        //서브 타이틀 출력
        subTitle(str);

        code = ioc.inNum("CODE : ");

        return code;
    }

    public void outData(DataDto data) {
        subTitle("Select Data");

        if(data == null){
            printMsg("No Data.");
            return;
        }

        ioc.twoPrint(data.toString());
        ioc.twoPrint("------------------");
    }

    public void updateInput(DataDto data) {
        subTitle("Update Data");

        //변경을 하는 값만 받아서 저장.
        String str = null;
        int num = 0;

        str = ioc.inStr("STR : ");
        if(!str.equals("")){//변경할 값을 입력한 상태
            data.setM_str(str);
        }
        num = ioc.inNum("INT : ");
        if(num != -1){//변경할 숫자가 입력된 경우
            data.setM_int(num);
        }
        str = ioc.inStr("DATE(yyyy-mm-dd) : ");
        if(!str.equals("")){//변경할 날짜가 입력된 경우
            data.setM_date(str);
        }
    }

    public String isDelete() {
        String yn = ioc.inStr("Delete Ok? (Y/N)");
        return yn;
    }
}// class end
