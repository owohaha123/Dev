package com.jsframe.membermanager.controller;

import com.jsframe.membermanager.dto.MemberDto;
import com.jsframe.membermanager.service.MemberService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@Log
public class MemberController {
    //service 자동처리
    @Autowired
    private MemberService mServ;

    // url 매핑된 메소드들
    @GetMapping("/")
    public String home(){
        log.info("home()");
        return "home";
    }

    @GetMapping("register")
    public String register(){
        log.info("register()");
        return "register";
    }

    @PostMapping("regProc")
    public String regProc(MemberDto member , RedirectAttributes rttr){
        log.info("regProc()");
        String view = mServ.regMember(member, rttr);
        return view;
    }

    @PostMapping("loginProc")
    public String loginProc(MemberDto member , HttpSession session , RedirectAttributes rttr){
        log.info("loginProc()");
        String view = mServ.loginProc(member, session, rttr);
        return view;
    }

    @GetMapping("main")
    public ModelAndView main(){
        log.info("main()");
        ModelAndView mv = new ModelAndView();
        // 여기에 데이터를 담아준다...
        mv.setViewName("main");
        return mv;
    }

    @GetMapping("logoutProc")
    public String logoutProc(HttpSession session){
        log.info("logoutProc()");
        //session.removeAttribute("mem");
        session.invalidate();
        // 세션 제거 후 첫 페이지로
        return "redirect:/";
    }

    @PostMapping("updateProc")
    public String updateProc(MemberDto member, HttpSession session, RedirectAttributes rttr){
        log.info("updateProc()");
        String view = mServ.updateMember(member, session, rttr);
        return view;
    }
    @GetMapping("resignProc")
    public String resignProc(HttpSession session, RedirectAttributes rttr){
        log.info("resignProc()");
        String view = mServ.resignMember(session, rttr);
        return view;
    }

}
