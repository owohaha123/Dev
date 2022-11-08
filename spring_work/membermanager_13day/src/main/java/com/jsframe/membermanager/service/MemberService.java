package com.jsframe.membermanager.service;

import com.jsframe.membermanager.dao.MemberDao;
import com.jsframe.membermanager.dto.MemberDto;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Service
@Log
public class MemberService {
    @Autowired
    private MemberDao mDao;

    // 비밀번호 암호화 및 확인 객체
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    // 회원가입 처리 메소드
    public String regMember(MemberDto member, RedirectAttributes rttr){
        log.info("regMember()");
        String msg = null;
        String view = null;

        // 비밀번호 암호화 처리
        String cPwd = encoder.encode(member.getM_pwd());
        log.info("암호화 된 비밀번호 : " + cPwd);
        log.info("비밀번호 길이 : " +cPwd.length());
        member.setM_pwd(cPwd); // 암호화된 비밀번호로 변경

        try{
            mDao.insertMember(member);
            msg = "가입 성공";
            view = "redirect:/"; //첫페이지(로그인)로 이동
        }catch (Exception e){
            e.printStackTrace();
            msg = "가입 실패";
            view = "redirect:register";
        }
        rttr.addFlashAttribute("msg" , msg);
        return view;
    }

    // 로그인 처리 메소드
    public String loginProc(MemberDto member, HttpSession session , RedirectAttributes rttr){
        log.info("loginProc");
        String msg = null;
        String view = null;

        String cPwd = mDao.selectPwd(member.getM_id());

        if(cPwd != null){//입력한 회원의 아이디가 있음
            if(encoder.matches(member.getM_pwd(), cPwd)){
                member = mDao.selectMember(member.getM_id());
                // 세션에 로그인 성공 정보 저장
                session.setAttribute("mem" , member);
                msg = "로그인 성공";
                view = "redirect:main";
            }else{// 비밀번호가 맞지 않는 경우
                msg = "비밀번호가 올바르지 않습니다.";
                view = "redirect:/";
            }
        }else{//잘못된 아이디 입력
            msg = "해당 아이디가 없습니다";
            view = "redirect:/";
        }
        rttr.addFlashAttribute("msg" , msg);
        return view;
    }

    public String updateMember(MemberDto member, HttpSession session , RedirectAttributes rttr){
        //회원정보를 수정하고, 세션에 로그인 정보 변경
        log.info("updateMember()");
        String msg = null;
        String view = null;

        try{
            mDao.updateMember(member);
            // 수정 시 세션에도 반영되어야 함
            session.setAttribute("mem", mDao.selectMember(member.getM_id()));
            msg = "수정 성공";
            view = "redirect:main";
        }catch (Exception e){
            //e.printStackTrace();
            msg = "수정 실패";
            view = "redirect:main";
        }
        rttr.addFlashAttribute("msg" , msg);
        return view;
    }

    // 회원 삭제용 메소드 (삭제+로그아웃)
    public String resignMember(HttpSession session, RedirectAttributes rttr){
        log.info("resignMember()");
        String msg = null;
        String view = null;
        // 세션에 저장된 로그인정보로부터 사용자의 id를 가져온다.
        MemberDto member = (MemberDto) session.getAttribute("mem");
        String mId = member.getM_id();

        try {
            mDao.deleteMember(mId);
            // 삭제 성공 후 로그아웃 처리
            session.invalidate();
            msg = "탈퇴 되었습니다";
            view = "redirect:/";
        }catch (Exception e){
            //e.printStackTrace();
            msg = "탈퇴 실패";
            view = "redirect:main";
        }
        rttr.addFlashAttribute("msg" , msg);
        return view;
    }
}
