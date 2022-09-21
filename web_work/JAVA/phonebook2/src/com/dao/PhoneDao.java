package com.dao;

import com.dto.PhoneComInfo;
import com.dto.PhoneInfo;
import com.dto.PhoneSchInfo;

import java.util.ArrayList;

public class PhoneDao {
    // DAO : Data Access Object (원래는 Database 와 연동하여 처리하는 객체)
    // Database 가 없으므로 여기에 저장 관련 작업을 처리

    // 일반 정보 저장용
    private ArrayList<PhoneInfo> pList = new ArrayList<>();
    // 학교 연락처 저장용
    private ArrayList<PhoneSchInfo> pSchList = new ArrayList<>();
    // 회사 연락처 저장용
    private ArrayList<PhoneComInfo> pComList = new ArrayList<>();

    // 메소드 오버로딩
    public void inputData(PhoneInfo phone){
        pList.add(phone);
    }
    public void inputData(PhoneSchInfo phone){
        pSchList.add(phone);
    }
    public void inputData(PhoneComInfo phone){
        pComList.add(phone);
    }

    // 각 연락처 목록의 크기를 구하는 메소드
    public int pListSize(int cate){
        int size = 0;
        switch (cate){
            case 1:
                size = pList.size();
                break;
            case 2:
                size = pSchList.size();
                break;
            case 3:
                size = pComList.size();
                break;
        }
        return size; // 중요!
    }// pListSize end

    // 각 list 의 마지막 번호를 구하는 메소드
    public int getLastNum(int cate){
        int lno = 0;
        switch (cate) {
            case 1:
                // 마지막 연락처의 일련번호(no) 구하기
                // 0번 부터 시작하기에 -1
                int n = pList.size();
                PhoneInfo p = pList.get(n-1);
                lno = p.getNo();
                //lno = pList.get(pList.size() -1).getNo();
                break;
            case 2:
                lno = pSchList.get(pSchList.size() -1).getNo();
                break;
            case 3:
                lno = pComList.get(pComList.size() -1).getNo();
                break;
        }
        return lno;
    } // getLastNum end

    public PhoneInfo getPhoneInfo(int idx){
        return pList.get(idx);
    }
    public PhoneSchInfo getSchInfo(int idx){
        return pSchList.get(idx);
    }
    public PhoneComInfo getComInfo(int idx){
        return pComList.get(idx);
    }

}// dao class end
