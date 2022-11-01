package com.jsframe.spr_jdbc2_12day.controller;

import com.jsframe.spr_jdbc2_12day.dto.DataDto;
import com.jsframe.spr_jdbc2_12day.service.DataService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Calendar;
import java.util.GregorianCalendar;

@Controller
@Log
@Service
public class DataController {
    @Autowired
    private DataService dServ;

    @GetMapping("/")
    public String home(Model model){
        log.info("home()");
        GregorianCalendar cal = new GregorianCalendar(); //2022-11-01
        String nowDate = cal.get(Calendar.YEAR) + "-"
                        + (cal.get(Calendar.MONTH)+1) + "-"
                        + cal.get(Calendar.DATE) + "-"
                        + cal.get(Calendar.HOUR) + ":"
                        + cal.get(Calendar.MINUTE) + ":"
                        + cal.get(Calendar.SECOND);
        model.addAttribute("nowtime" , nowDate);
        return "home";
    }

    @GetMapping("inputFrm") //화면 전환용 메소드
    public String inputFrm(){
        log.info("inputFrm()");
        return "inputFrm";
    }

    @GetMapping("inputProc")
    // Model 이나 RedirectAttributes 는 받지 않아도 보낼 수 있음
    public String inputProc(DataDto data, RedirectAttributes rttr){
        log.info("inputProc()");
        String view = dServ.inputData(data, rttr);
        return view;
    }

    @GetMapping("dataList")
    public ModelAndView dataList(){
        log.info("dataList()");
        ModelAndView mv = dServ.outputList();
        return mv;
    }

    @GetMapping("detail")
    public ModelAndView detail(int code){
        log.info("detail()");
        ModelAndView mv = dServ.outputData(code);
        return mv;
    }

    @GetMapping("updateFrm")
    public ModelAndView updateFrm(int code){
        log.info("updateFrm()");
        ModelAndView mv = dServ.outputData(code);
        mv.setViewName("updateFrm");
        return mv;
    }

    @GetMapping("updateProc")
    public String updateProc(DataDto data, RedirectAttributes rttr){
        log.info("updateProc()");
        String view = dServ.updateData(data, rttr);
        return view;
    }

    @GetMapping("deleteProc")
    public String deleteProc(int code, RedirectAttributes rttr){
        log.info("deleteProc()");
        String view = dServ.deleteData(code, rttr);
        return view;
    }
}//class end
