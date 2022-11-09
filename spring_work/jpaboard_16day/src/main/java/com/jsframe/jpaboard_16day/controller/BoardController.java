package com.jsframe.jpaboard_16day.controller;

import com.jsframe.jpaboard_16day.entity.Board;
import com.jsframe.jpaboard_16day.entity.BoardFile;
import com.jsframe.jpaboard_16day.service.BoardService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@Log
public class BoardController {
    ModelAndView mv;

    @Autowired
    private BoardService bSev;

    @GetMapping  ("/")
    public ModelAndView getList(Integer pageNum, HttpSession session){
        log.warning("getList()");
        mv = bSev.getBoardList(pageNum, session);
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

    // 500 에러 페이지 확인용 메소드 (기능과 무관)
    @GetMapping("error500")
    public String error500() throws Exception{
        log.info("error500()");
        throw new Exception("강제로 발생시킨 예외!");
        //return null;
    }

    @GetMapping("detail")
    public ModelAndView detail(long bnum){
        log.info("detail()");
        mv = bSev.getBoard(bnum);
        mv.setViewName("detail");

        return mv;
    }

    @GetMapping("download")
    public ResponseEntity<Resource> fileDownload(BoardFile bfile, HttpSession session) throws IOException {
        ResponseEntity<Resource> resp = bSev.fileDownload(bfile, session);
        return resp;
    }

    // 수정 페이지로 전환
    @GetMapping("updateFrm")
    public ModelAndView updateFrm(long bnum){
        log.info("updateFrm()");
        mv = bSev.getBoard(bnum);
        mv.setViewName("updateFrm");

        return mv;
    }

    @PostMapping("updateProc")
    public String updateProc(List<MultipartFile> files, Board board,HttpSession session, RedirectAttributes rttr){
        log.info("updateProc()");
        String view = bSev.boardUpdate(files, board, session, rttr);

        return view;
    }

    @GetMapping("delete")
    public String deleteBoard(long bnum, HttpSession session, RedirectAttributes rttr){
        log.info("deleteBoard()");
        String view = bSev.boardDelete(bnum, session, rttr);
        return view;
    }
}
