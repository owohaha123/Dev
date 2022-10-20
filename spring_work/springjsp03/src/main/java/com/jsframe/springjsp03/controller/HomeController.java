package com.jsframe.springjsp03.controller;

import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.ArrayList;

@Controller
@Log
public class HomeController {
    @GetMapping("/")
    public String home(){
        log.info("home()");
        return "index";
    }

    @GetMapping("include")
    public String includePage(Model model){
        log.info("includePage()");
        ArrayList<String> mList = new ArrayList<>();
        mList.add("갈비탕");
        mList.add("짬뽕");
        mList.add("돈까스");
        mList.add("뼈해장국");

        model.addAttribute("menu" , mList);

        return "actionInclude";
    }

}
