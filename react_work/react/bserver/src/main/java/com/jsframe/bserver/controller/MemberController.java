package com.jsframe.bserver.controller;

import com.jsframe.bserver.entity.Member;
import com.jsframe.bserver.service.MemberService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log
public class MemberController {
    @Autowired
    private MemberService mServ;

    @PostMapping("joinProc")
    public String joinProc(@RequestBody Member member){
        log.info("joinProc");
        String res = mServ.joinMember(member);
        return res;
    }

    @PostMapping("loginProc")
    public String loginProc(@RequestBody Member member){
        log.info("loginProc()");

        return mServ.loginProc(member);
    }
}
