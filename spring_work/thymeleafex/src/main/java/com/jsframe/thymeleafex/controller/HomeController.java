package com.jsframe.thymeleafex.controller;

import com.jsframe.thymeleafex.dto.PersonDto;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@Log
public class HomeController {
    @GetMapping("/")
    public String home(Model model) {
        log.info("home()");
        model.addAttribute("d1", "서버로부터 <b>전송</b>된 메시지");
        model.addAttribute("d2", 300);

        PersonDto person = new PersonDto();
        person.setP_name("홍길동");
        person.setP_age(20);
        person.setP_phone("010-1234-5678");

        model.addAttribute("pe", person);

        return "home";
    }
    @GetMapping("second")
    public ModelAndView second(HttpSession session){
        log.info("second()");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("second");

        session.setAttribute("id", "user01");

        List<PersonDto> pList = new ArrayList<>();
        for (int i = 0; i < 3; i++){
            PersonDto p = new PersonDto();
            p.setP_name("사람" + i);
            p.setP_age(20 + i);
            p.setP_phone("01012345678" + i);
            pList.add(p);
        }
        mv.addObject("pList" , pList);

        return mv;
    }

}//class end
