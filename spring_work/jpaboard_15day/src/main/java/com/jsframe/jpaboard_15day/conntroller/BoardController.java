package com.jsframe.jpaboard_15day.conntroller;

import com.jsframe.jpaboard_15day.entity.Board;
import com.jsframe.jpaboard_15day.service.BoardService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@Log
public class BoardController {
    ModelAndView mv;

    @Autowired
    private BoardService bSev;

    @GetMapping("/")
    public ModelAndView getList(Integer pageNum){
        log.warning("getList()");
        mv = new ModelAndView();
        mv.setViewName("list");
        return mv;
    }

    @GetMapping("writeFrm")
    public String writeFrm(){
        log.info("writeFrm()");
        return "writeFrm";
    }

    @PostMapping("writeProc")
    public String writeProc(@RequestPart List<MultipartFile> files,
                            Board board, HttpSession session,
                            RedirectAttributes rttr) {
        log.info("writeProc()");
        String view = bSev.insertBoard(files, board, session, rttr);

        return view;
    }
}
