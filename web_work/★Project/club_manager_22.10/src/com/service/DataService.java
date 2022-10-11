package com.service;

import com.dao.DataDao;
import com.dto.ClubDto;
import com.dto.MemberDto;

public class DataService {
    // dao 를 사용하여 DB 에 data 를 저장하고 결과를 controller 에게 알림
    private DataDao dDao = new DataDao();

    public MemberDto getid(String id) {
        MemberDto data = null;
        //전달 받은 검색값을 사용하여 DB select 작업을 수행 -> Dao
        data = dDao.selectId(id);
        //검색 결과 데이터를 controller  에 전달(반환)
        return data;
    }

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
}


