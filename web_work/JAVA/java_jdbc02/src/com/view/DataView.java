package com.view;

import com.dto.DataDto;

import java.awt.*;
import java.util.List;

public class DataView {
    // 입출력을 위한 부품 (InOutClass)
    private InOutClass ioc = new InOutClass();

    // 타이틀, 메뉴 출력, 메뉴번호 입력
    public int showFirst(){
        int m = -1;

        ioc.twoPrint("");//첫줄 띄기
        ioc.twoPrint("<<DB 연동 데이터 관리 프로그램>>");
        ioc.twoPrint("-----------------------------");
        ioc.twoPrint("메뉴 > ");
        ioc.twoPrint("1. Data input");
        ioc.twoPrint("2. Data output"); // 전체 출력
        ioc.twoPrint("3. Data search"); // 개별 출력
        ioc.twoPrint("4. Data update");
        ioc.twoPrint("5. Data delete");
        ioc.twoPrint("0. Quit");
        m = ioc.inNum("Select > ");

        return m;
    }// showFirst end

    // 메시지 출력용 메소드
    public void printMsg(String msg){
        ioc.twoPrint(msg);
    }

    // 데이터 입력 메소드
    public void inputData(DataDto data){
        ioc.twoPrint("<Data input>");
        ioc.twoPrint("----------------");
        data.setM_str(ioc.inStr("STRING : "));
        data.setM_int(ioc.inNum("INTEGER : "));
        data.setM_date(ioc.inStr("DATE(yyyy-mm-dd) : "));
    }// inputData end

    // 전체 데이터 출력용 메소드
    public void outputList(List<DataDto> dList){
        ioc.twoPrint("<Data output>");
        ioc.twoPrint("---------------");
        if(dList == null){
            ioc.twoPrint("데이터가 없습니다");
        }

        // 목록 출력(반복)
        for(DataDto d : dList){
            ioc.twoPrint("code : " + d.getM_code()); // String.valueOf(d.getM_code()) = d.getM_code()+""
            ioc.twoPrint("string : " + d.getM_str());
            ioc.twoPrint("integer : " + d.getM_int());
            ioc.twoPrint("date : " + d.getM_date());
            ioc.twoPrint("-------------------");
        }
    } // outputList end

    // 검색코드 입력 메소드
    public int searchCode(String str){
        int code = 0;

        ioc.twoPrint("<Data search>");
        ioc.twoPrint("-----------------");
        code = ioc.inNum(str);

        return code;
    } // searchCode end

    // 개별 데이터 출력용 메소드
    public void outputData(DataDto data){
        ioc.twoPrint("<검색 결과>");
        ioc.twoPrint("---------------");

        if (data == null){
          ioc.twoPrint("검색 결과 없음");
        } else {
                ioc.twoPrint("code : " + data.getM_code()); // String.valueOf(d.getM_code()) = d.getM_code()+""
                ioc.twoPrint("string : " + data.getM_str());
                ioc.twoPrint("integer : " + data.getM_int());
                ioc.twoPrint("date : " + data.getM_date());
                ioc.twoPrint("-------------------");
        }

    }
}
