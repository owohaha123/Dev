package com.service;

import com.dao.DataDao;
import com.dto.ClubDto;
import com.dto.JoinDto;
import com.dto.MemberDto;

import java.util.List;

public class DataService {
    // dao 를 사용하여 DB 에 data 를 저장하고 결과를 controller 에게 알림
    private DataDao dDao = new DataDao();

    // ---------------------------------------------------------------------------윤주-----------------------
    public String login(String id, String pw) {
        MemberDto data = getMemberById(id);

        if(data == null){
            return "아이디 없음";
        }else {
            if (data.getM_id().equals(id)) {
                //아이디 있음
                if (data.getM_pwd().equals(pw)) {
                    return "로그인 성공";
                } else {
                    return "비밀번호 불일치";
                }
            } else {
                return "아이디 없음";
            }
        }
    }

    public MemberDto getMemberById(String id){
        return dDao.selectId(id);
    }

    public String insertClub(ClubDto data, String m_id){
        String msg = null;

        // Dao 를 사용하여 저장
        int res = dDao.insertClub(data);

        if(res == 0){
            msg = "Insert Failed";
        }else{
            int club_no = dDao.getClubByName(data.getCb_name());
            dDao.insertUserToClub(m_id,club_no);
            msg = "Insert Success";
        }

        return msg;
    }


    public List<ClubDto> getData(String m_id) {
        List<ClubDto> data = null;
        //전달 받은 검색값을 사용하여 DB select 작업을 수행 -> Dao
        data = dDao.selectData(m_id);
        //검색 결과 데이터를 controller  에 전달(반환)
        return data;
    }

    public String DeleteData(ClubDto data, String id) {
        String msg = null;

        int res = dDao.deleteData(data, id);

        if(res > 0){
            msg = "탈퇴되었습니다.";
        }else {
            msg = "탈퇴에 실패했습니다.";
        }

        return msg;
    }

    // ---------------------------------------------------------------------------동수-----------------------
    public String insertClub2(JoinDto data) { // 야구 동호회 가입
        String msg = null;

        // Dao를 사용하여 저장
        int res = dDao.insertClub2(data);

        if(res == 0){
            msg = "Insert Failed";
        }else{
            msg = "Insert Success";
        }

        return msg;
    }

    public String insertClub3(JoinDto data) { // 독서 동호회 가입
        String msg = null;

        // Dao를 사용하여 저장
        int res = dDao.insertClub3(data);

        if(res == 0){
            msg = "Insert Failed";
        }else{
            msg = "Insert Success";
        }

        return msg;
    }

    public String insertClub4(JoinDto data) { // 고양이 동호회 가입
        String msg = null;

        // Dao를 사용하여 저장
        int res = dDao.insertClub4(data);

        if(res == 0){
            msg = "Insert Failed";
        }else{
            msg = "Insert Success";
        }

        return msg;
    }

    public List<ClubDto> getList() { // case 3 method
        // Dao에게 DB로부터 데이터를 검색하여 목록을 가져오게 시킴.
        List<ClubDto> gList = dDao.selectClubList();

        // 받은 목록을 controller에게 전달.
        return gList;
    }


    public List<JoinDto> getList1() { // case 4 method
        // Dao에게 DB로부터 데이터를 검색하여 목록을 가져오게 시킴.
        List<JoinDto> jList = dDao.selectMemberList();

        // 받은 목록을 controller에게 전달.
        return jList;
    }
}



