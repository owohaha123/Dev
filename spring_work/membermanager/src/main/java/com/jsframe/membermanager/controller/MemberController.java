package com.jsframe.membermanager.controller;

import com.jsframe.membermanager.dto.MemberDto;
import com.jsframe.membermanager.service.MemberService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
}
