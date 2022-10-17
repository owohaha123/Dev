package com.jsframe.jsp01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; // 택배 회사 (전달하는 역할)
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("data",  "서버에서 보낸 데이터");
        return "home";
    }
}
