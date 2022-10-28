package com.jsframe.springajax_10day.controller;

import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Log
public class HomeController {
    @GetMapping("/")
    public String home(){
        log.info("home()");
        return "home";
    }

    @GetMapping("idcheck")
    @ResponseBody
    public String idcheck(String data){ //컨트롤러 매개변수 = sendObj 변수명
        log.info("idcheck()");
        String res = "ok"; // 중복확인 처리는 생략
        return res;
    }
}
