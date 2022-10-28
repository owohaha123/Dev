package com.jsframe.springajax_10day.controller;

import com.jsframe.springajax_10day.dto.MemberDto;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // view 안 거침
@Log
public class RestHomeController {
    @PostMapping("restcheck")
    public String restcheck(String idv){
        log.info("restcheck() - idv :" + idv);
        String res = "사용가능한 아이디입니다.";
        return res;
    }

    @PostMapping("joinProc")
    public String joinProc(MemberDto member){
        log.info("joinProc() - id :" + member.getM_id());
        log.info("joinProc() - pwd :" + member.getM_pwd());
        log.info("joinProc() - name :" + member.getM_name());

        return "가입 성공";
    }

}
