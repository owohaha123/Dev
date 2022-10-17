package com.jsframe.jsp02.controller;

import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Log
public class HomeController {
    @GetMapping("/")
    public String home (Model model){
        log.info("home()");

        // jsp 로 데이터 전달(model 을 사용)
        model.addAttribute("d", "서버에서 보내는 데이터");
        // 화면에 보여질 페이지
        String viewName = "home";

        return viewName;
    }

    @GetMapping("second")
    public String second(){
        log.info("second");
        return "second";
    }
}
