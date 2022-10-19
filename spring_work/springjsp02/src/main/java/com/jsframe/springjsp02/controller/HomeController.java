package com.jsframe.springjsp02.controller;

import com.jsframe.springjsp02.dto.CalDto;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@Log
//@RequestMapping("news")
public class HomeController {
    @GetMapping("/")
    public String home(){
        log.info("home()");
        return "index";
    }

    @GetMapping("calProc")
    public String calProc(CalDto cdata, Model model){ // model 은 뒤쪽에 써준다
        log.info("calProc()");
        log.info("num1 : " + cdata.getNum1());
        log.info("num2 : " + cdata.getNum2());
        log.info("op : " + cdata.getOp());

        int n1 = cdata.getNum1();
        int n2 = cdata.getNum2();
        int res = 0;

        switch (cdata.getOp()){
            case "+":
                res = n1 + n2;
                break;
            case "-":
                res = n1 - n2;
                break;
            case "*":
                res = n1 * n2;
                break;
            case "/":
                res = n1 / n2;
                break;
            case "%":
                res = n1 % n2;
                break;
        }

        cdata.setResult(res);
        //cdata.setResult(cdata.getNum1() + cdata.getNum2());

        // model 에 결과 담기
        model.addAttribute("result" , cdata);

        return "result";
    }

    //@RequestMapping(value = "dateProc" , method = RequestMethod.GET)
    @RequestMapping("dateProc")
    public ModelAndView dateProc(){ // Model 대신 ModelAndView 사용
        log.info("dateProc()");

        //
        ModelAndView mv = new ModelAndView();
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd (E)");
        String nowDate = sdf.format(now);
        log.info(nowDate);
        // ModelAndView 에 데이터 담기 : addObject ("이름표" , 데이터);
        mv.addObject("date" , nowDate);
        // view 를 지정
        mv.setViewName("nowdate");

        return mv;
    }

    @GetMapping("old")
    public String old(){
        log.info("old()");
        return "old";
    }

    @GetMapping("el_op")
    public ModelAndView el_op(){
        log.info("el_op()");
        ModelAndView mv = new ModelAndView();
        mv.addObject("d1", 10);
        mv.addObject("d2", 20);

        mv.addObject("id", "user01");
        mv.addObject("el_op");

        return mv;
    }
}
