package com.jsframe.spr_jdbc.controller;

import com.jsframe.spr_jdbc.dto.DataDto;
import com.jsframe.spr_jdbc.service.DataService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Log
public class DataController {
    @Autowired
    private DataService dServ;

    @GetMapping("/")
    public String home(){
        log.info("home()");
        return "home";
    }

    @GetMapping("inputFrm")
    public String inputFrm(){
        log.info("inputFrm()");
        return "inputFrm";
    }

    // 입력된 데이터를 DB에 저장(insert)
    @GetMapping("inputProc")
    public String inputProc(DataDto data, RedirectAttributes rttr){
        log.info("inputProc()");

        // 서비스 -> dao -> DB 저장
        String msg = dServ.inputData(data);

        return "redirect:/"; // 입력 완료 후 첫 페이지로 이동
    }

    @GetMapping("dataList")
    public ModelAndView dataList(){
        log.info("dataList()");
        ModelAndView mv = dServ.outputList();
        return mv;
    }


}// class end
