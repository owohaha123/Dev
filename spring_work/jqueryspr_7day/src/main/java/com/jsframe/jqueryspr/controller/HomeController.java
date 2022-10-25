package com.jsframe.jqueryspr.controller;

import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Log
public class HomeController {
    @GetMapping("/")
    public String home(){
        log.info("home()");
        return "home";
    }

    @GetMapping("jquery01")
    public String jquery01(){
        log.info("jquery01()");
        return "jquery01";
    }

    @GetMapping("event")
    public String event(){
        log.info("event()");
        return "event";
    }

    @GetMapping("hideshow")
    public String hideshow(){
        log.info("hideshow()");
        return "hideshow";
    }
}
