package com.jsframe.bserver.service;

import com.jsframe.bserver.entity.Board;
import com.jsframe.bserver.entity.BoardFile;
import com.jsframe.bserver.repository.BoardFileRepository;
import com.jsframe.bserver.repository.BoardRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Log
public class BoardService {
    @Autowired
    private BoardRepository bRepo;//게시글 DB 처리용
    @Autowired
    private BoardFileRepository bfRepo;//파일 DB 처리용

    public Map<String, Object> getBoardList(Integer pageNum){
        log.info("getBoardList()");

        if(pageNum == null){//처음에 접속했을 때는 pageNum이 넘어오지 않는다.
            pageNum = 1;
        }

        int listCnt = 10;//페이지 당 보여질 게시글의 개수.
        //페이징 조건 생성
        Pageable pb = PageRequest.of((pageNum - 1), listCnt,
                Sort.Direction.DESC, "bnum");

        Page<Board> result = bRepo.findByBnumGreaterThan(0L, pb);
        List<Board> bList = result.getContent();
        int totalPage = result.getTotalPages();

        Map<String, Object> res = new HashMap<>();
        res.put("totalPage", totalPage);
        res.put("pageNum", pageNum);
        res.put("bList", bList);

        return res;
    }


    public Board getBoard(long bnum){
        log.info("getBoard()");

        //게시글 가져와서 담기
        Board board = bRepo.findById(bnum).get();
        //첨부파일(목록) 가져와서 담기
        List<BoardFile> bfList = bfRepo.findByBfbid(board.getBnum());

        board.setBfList(bfList);

        return board;
    }

    //@Transactional
    public String insertBoard(Board board, List<MultipartFile> files, HttpSession session) {
        log.info("insertBoard()");
        try {
            bRepo.save(board);
            log.info("bnum : " + board.getBnum());
            if(files != null) {
                fileUpload(files, session, board.getBnum());
            }
            return "ok";
        } catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }

    private void fileUpload(List<MultipartFile> files,
                            HttpSession session, long bnum)
            throws Exception {
        log.info("fileUpload()");
        //파일 저장 위치 지정. session을 활용
        String realPath = session.getServletContext().getRealPath("/");
        log.info("realPath : " + realPath);
        //파일 업로드용 폴더를 자동으로 생성하도록 처리
        //업로드용 폴더 : upload
        realPath += "upload/";
        File folder = new File(realPath);
        if(folder.isDirectory() == false){//폴더가 없을 경우 실행.
            folder.mkdir();//폴더 생성 메소드
        }
        for(MultipartFile mf : files) {
            String orname = mf.getOriginalFilename();//업로드 파일명 가져오기
            if (orname.equals("")) {
                //업로드하는 파일이 없는 상태.
                return;//파일 저장 처리 중지!
            }

            //파일 정보를 저장(to boardfiletbl)
            BoardFile bf = new BoardFile();
            bf.setBfbid(bnum);
            bf.setBforiname(orname);
            String sysname = System.currentTimeMillis()
                    + orname.substring(orname.lastIndexOf("."));
            bf.setBfsysname(sysname);
            //업로드하는 파일을 upload 폴더에 저장.
            File file = new File(realPath + sysname);
            //파일 저장(upload 폴더)
            mf.transferTo(file);

            //파일 정보를 DB에 저장
            bfRepo.save(bf);
        }
    }//method end

    //파일다운로드 처리 메소드
    public ResponseEntity<Resource> fileDownload(BoardFile bfile,
                                                 HttpSession session)
            throws IOException {
        log.info("fileDownload()");
        //파일 저장 경로 구하기
        String realpath = session.getServletContext().getRealPath("/");
        realpath += "upload/" + bfile.getBfsysname();

        InputStreamResource fResource =
                new InputStreamResource(new FileInputStream(realpath));

        //파일명이 한글인 경우의 처리(UTF-8로 인코딩 처리)
        String fileName = URLEncoder.encode(bfile.getBforiname(), "UTF-8");

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .cacheControl(CacheControl.noCache())
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=" + fileName)
                .body(fResource);
    }
}//class end
