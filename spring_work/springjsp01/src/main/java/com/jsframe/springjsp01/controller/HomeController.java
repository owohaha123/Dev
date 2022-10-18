package com.jsframe.springjsp01.controller;

import com.jsframe.springjsp01.dto.MemberDto;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Log
public class HomeController {
    // 사용자 요청 url 과 메소드 매핑
    @GetMapping("/")
    public String start(){
        log.info("start()");
        //System.out.printf("start()"); // 안 씀!
        String viewName = "index"; // jsp 파일의 이름
        return viewName; // 두 줄 대신 return "index"; 도 가능
    }

    @GetMapping("mp")
    public String mypageMethod(){
        log.info("mypageMethod()");
        return "mypage"; // jsp 이름과만 같으면 된다!!
    }

    @GetMapping("hobby")
    public String Hobby(){
        log.info("hobby()");
        return "hobby";
    }

    @GetMapping("heart")
    public String heart(){
        log.info("heart()");
        return "heart";
    }

    @GetMapping("inputForm")
    public String inputForm(){
        log.info("inputForm()");
        return "inputForm";
    }

    @GetMapping("inputProc")
    public String inputProc(String str, String num){ // jsp 에서 전송하는 모든 데이터는 문자열이다
                                                     // from 태그로 보내는 건 무조건 String!
        //log.info("inputProc() - str : " + str + "num : " + num);
        log.info("inputProc()");
        log.info("str : " + str);
        log.info("num : " + num);
        int n = Integer.parseInt(num); // 문자열 -> 정수변환
        int data = n + 30; // 이런 저런 산술 연산 처리
        return "index";
    }

    @GetMapping("joinForm")
    public String joinForm(){
        log.info("joinForm()");
        return "joinForm";
    }

    @PostMapping("joinProc")
    public String joinProc(MemberDto member){
        log.info("joinProc()");
        log.info("id : " + member.getId());
        log.info("pwd : " + member.getPwd());
        log.info("name : " + member.getName());
        log.info("age : " + member.getAge());

        return "index";
    }

    @GetMapping("output")
    public String output(Model model){
        log.info("output()");
        model.addAttribute("data1" , "첫번째 데이터");
        model.addAttribute("data2" , 1000);
        String m = "보내는 메시지";
        model.addAttribute("msg" , m);

        // Dto 를 활용한 데이터 묶음 전달
        MemberDto member = new MemberDto();
        member.setId("test");
        member.setPwd("1234");
        member.setName("고길동");
        member.setAge(62);

        model.addAttribute("mem" , member);

        return "output"; // 데이터가 가야할 목적지
    }
}// class end
