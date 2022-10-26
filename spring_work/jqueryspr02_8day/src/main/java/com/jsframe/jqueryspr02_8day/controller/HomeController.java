package com.jsframe.jqueryspr02_8day.controller;

import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Log
public class HomeController {
    @GetMapping("/")
    public String home(){
        log.info("home()");
        return "effect02";
    }

    @GetMapping("attr")
    public String attr(){
        log.info("attr()");
        return "attr";
    }
}
