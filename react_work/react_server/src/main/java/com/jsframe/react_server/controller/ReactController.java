package com.jsframe.react_server.controller;

import com.jsframe.react_server.dto.DataDto;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController //controller 사용해도 무방하나 그럼 @ResponseBody 를 사용해줘야 함
@Log
public class ReactController {
    @GetMapping("getData")
    public String getData(){
        log.info("getData()");
        return "서버로부터의 메시지 : 잘 된다~";
    }

    @GetMapping("getObject")
    public DataDto getObject(){
        log.info("getObject()");
        DataDto d = new DataDto();
        d.setStr("메시지");
        d.setNumber(100);

        return d;
    }

    @GetMapping("getList")
    public List<DataDto> getList(){
        log.info("getList()");
        List<DataDto> dList = new ArrayList<>();
        for(int i = 1; i <= 5; i++){
            DataDto data = new DataDto();
            data.setStr("문자열" + i);
            data.setNumber(10 * i);
            dList.add(data);
        }
        return dList;
    }

    @GetMapping("sendData")
    public String sendData(@RequestParam String data,
                           @RequestParam String second) {
        log.info("sendData()");
        log.info("data: "  + data);
        log.info("second: " + second);

        return "문자열 전송 ok";
    }

    @PostMapping("sendObject")
    public String sendObject(@RequestBody DataDto data){
        log.info("sendObject()");
        log.info(data.getStr() + ", " + data.getNumber());

        return "객체 전송 ok";
    }
}// class end
