package com.jsframe.bserver.controller;

import com.jsframe.bserver.entity.Board;
import com.jsframe.bserver.entity.BoardFile;
import com.jsframe.bserver.service.BoardService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@Log
public class BoardController {
    @Autowired
    private BoardService bServ;

    @GetMapping("list")
    public Map<String, Object> getList(@RequestParam Integer pageNum, HttpSession session){
        log.info("getList()");
        return bServ.getBoardList(pageNum);
    }

    @PostMapping("writeProc")
    public String writeProc(@RequestPart(value = "data", required = true) Board board,
                            @RequestPart(value = "files", required = false) List<MultipartFile> files,
                            HttpSession session){
        log.info("writeProc()");
        log.info(board.getBtitle()+", "+board.getBcontent());
        return bServ.insertBoard(board, files, session);
    }

    @GetMapping("getBoard")
    public Board getBoard(@RequestParam long bnum){
        log.info("getBoard() bnum : " + bnum);
        return bServ.getBoard(bnum);
    }

    @GetMapping("download")
    public ResponseEntity<Resource> fileDownload(BoardFile bfile,
                                                 HttpSession session)
            throws IOException {
        ResponseEntity<Resource> resp = bServ.fileDownload(bfile, session);
        return resp;
    }
}
