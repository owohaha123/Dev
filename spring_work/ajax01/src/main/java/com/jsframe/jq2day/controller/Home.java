package com.jsframe.jq2day.controller;

import com.jsframe.jq2day.dto.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class Home {
    @GetMapping("/")
    public String start(){
        return "index";
    }

    @GetMapping("/ajaxTest")
    // @ResponseBody :
    public @ResponseBody Member home(Member mb, Model model) { //반환값 String 에서 Member 로 변경(return이 mb)
        System.out.println("id : " + mb.getId());
        System.out.println("pw : " + mb.getPw());
        mb.setAge(20).setName("길동이");
        return mb; // java 객체 -> 메시지컨버터(jackson)-> json 형식의 문자열로 변환

        //model.addAttribute("id",mb.getId()); //request 영역에 저장
        //model.addAttribute("pw",mb.getPw());
        //return "main"; // 응답페이지에 출력 가능
    }

    @PostMapping("/ajaxTest2")
    // @ResponseBody :
    public @ResponseBody List<Member> home2(@RequestBody List<Member> mList) { //반환값 String 에서 Member 로 변경(return이 mb)
        System.out.println(mList);
        System.out.println(mList.size());
        Member mb = new Member();
        mb.setId("zzzz").setPw("1234").setAge(30).setName("제트");
        mList.add(mb);
        return mList; // java 객체 -> jackson -> json 변환
    }
}
