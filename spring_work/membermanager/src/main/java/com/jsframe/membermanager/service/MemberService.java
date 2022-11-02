package com.jsframe.membermanager.service;

import com.jsframe.membermanager.dao.MemberDao;
import com.jsframe.membermanager.dto.MemberDto;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Service
@Log
public class MemberService {
    @Autowired
    private MemberDao mDao;

    // 회원가입 처리 메소드
    public String regMember(MemberDto member, RedirectAttributes rttr){
        log.info("regMember()");
        String msg = null;
        String view = null;

        try{
            mDao.insertMember(member);
            msg = "가입 성공";
            view = "redirect:/"; //첫페이지(로그인)로 이동
        }catch (Exception e){
            //e.printStackTrace();
            msg = "가입 실패";
            view = "redirect:register";
        }
        rttr.addFlashAttribute("msg" , msg);
        return "view";
    }
}
