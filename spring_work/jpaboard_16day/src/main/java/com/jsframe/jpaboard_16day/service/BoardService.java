package com.jsframe.jpaboard_16day.service;

import com.jsframe.jpaboard_16day.entity.Board;
import com.jsframe.jpaboard_16day.entity.BoardFile;
import com.jsframe.jpaboard_16day.repository.BoardFileRepository;
import com.jsframe.jpaboard_16day.repository.BoardRepository;
import com.jsframe.jpaboard_16day.util.PagingUtil;
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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

@Service
@Log
public class BoardService {
    @Autowired
    private BoardRepository bRepo; // 게시글 DB 처리용
    @Autowired
    private BoardFileRepository bfRepo;// 파일 DB 처리용

    private ModelAndView mv;

    //게시글 저장 메소드
    @Transactional //정상이면 commit, 에러발생 시 rollback 처리.
    public String insertBoard(List<MultipartFile> files, //업로드 파일 목록
                              Board board, HttpSession session,
                              RedirectAttributes rttr) {
        log.info("insertBoard()");
        String msg = null;
        String view = null;

        try {
            //insert 와 update 처리 메소드 save()
            bRepo.save(board);//저장과 동시에 select 도 처리
            log.info("bnum : " + board.getBnum());
            //파일 저장(외래키에 해당하는 게시글 번호가 필요함.)
            fileUpload(files, session, board);

            view = "redirect:/";//목록 화면으로 돌아가기.
            msg = "저장 성공";
        } catch (Exception e){

            e.printStackTrace();
            view = "redirect:writeFrm";
            msg = "저장 실패";
        }
        rttr.addFlashAttribute("msg", msg);

        return view;
    }

    private void fileUpload(List<MultipartFile> files, HttpSession session, Board board)
    throws Exception {
        log.info("fileUpload()");
        // 1. 파일 저장 위치 지정
        String realPath = session.getServletContext().getRealPath("/");
        log.info("realPath : " + realPath);
        // 업로드용 폴더: upload
        realPath += "upload/";
        File folder = new File(realPath);
        if(folder.isDirectory() == false){// 폴더가 없을 경우 실행(폴더가 있으면 생략)
            folder.mkdirs(); //폴더 생성 메소드
        }
        for(MultipartFile mf : files){
            String orname = mf.getOriginalFilename(); // 업로드 파일명 가져오기
            if(orname.equals("")){// 업로드할 파일이 없는 상태
                return; // 파일 저장 처리 중지
            }

            // 파일 정보 저장(to boardfiletbl)
            BoardFile bf = new BoardFile();
            bf.setBfbid(board);
            bf.setBforiname(orname);
            String sysname = System.currentTimeMillis() + orname.substring(orname.lastIndexOf("."));
            bf.setBfsysname(sysname);
            // 업로드하는 파일을 upload 폴더에 저장
            File file = new File(realPath + sysname);
            // 파일 저장 (upload 폴더)
            mf.transferTo(file);

            // 파일 정보를 DB에 저장
            bfRepo.save(bf);
        }// for end
    }// fileUpload end

    public ModelAndView getBoardList(Integer pageNum, HttpSession session){
        log.info("getBoardList()");
        mv = new ModelAndView();

        if(pageNum == null){// 처음에 접속했을 때는 pageNum 이 넘어오지 않는다
            pageNum = 1;
        }

        int listCnt = 5; //페이지 당 보여질 게시글의 개수
        // 페이징 조건 생성
        Pageable pb  = PageRequest.of((pageNum - 1), listCnt, Sort.Direction.DESC, "bnum");

        Page<Board> result = bRepo.findByBnumGreaterThan(0L, pb);
        List<Board> bList = result.getContent();
        int totalPage = result.getTotalPages();//전체 페이지 개수

        String paging = getPaging(pageNum, totalPage);

        mv.addObject("bList" , bList);
        mv.addObject("paging", paging);

        // 현재 보이는 페이지의 번호를 저장
        // 세션에 저장하는 이유?
        session.setAttribute("pageNum", pageNum);

        return mv;
    }

    // 페이징 처리 메소드
    private String getPaging(int pageNum, int totalPage) {
        String pageHtml = null;
        int pageCnt = 2;//보여질 페이지 번호 개수(조정)
        String listName = "?";//게시판 분류 이름(현재 없음)

        PagingUtil paging = new PagingUtil(totalPage, pageNum, pageCnt, listName);

        pageHtml = paging.makePaging();

        return pageHtml;
    }

    public ModelAndView getBoard(long bnum){
        log.info("getBoard()");
        mv = new ModelAndView();

        // 게시글 가져와서 담기
        Board board = bRepo.findById(bnum).get();
        mv.addObject("board" , board);

        // 첨부파일(목록) 가져와서 담기
        // 하나여도 목록으로 처리해야 함
        List<BoardFile> bfList = bfRepo.findByBfbid(board);//외래키 사용하여 작명
        mv.addObject("bfList" , bfList);

        return mv;
    }

    // 파일 다운로드 처리 메소드
    public ResponseEntity<Resource> fileDownload(BoardFile bfile, HttpSession session)throws IOException {
        log.info("fileDownload()");
        // 파일 저장 경로 구하기
        String realpath = session.getServletContext().getRealPath("/");
        realpath += "upload/" + bfile.getBfsysname();

        InputStreamResource fResource = new InputStreamResource(new FileInputStream(realpath));

        // 파일명이 한글인 경우의 처리(UTF-8 로 인코딩 처리)
        String fileName = URLEncoder.encode(bfile.getBforiname(), "UTF-8");

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .cacheControl(CacheControl.noCache())
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName)
                .body(fResource);
    }

    //게시글 수정
    @Transactional
    public String boardUpdate(List<MultipartFile> files, Board board, HttpSession session, RedirectAttributes rttr){
        log.info("boardUpdate()");
        String msg = null;
        String view = null;

        try {
            bRepo.save(board); // insert, update 겸용
            fileUpload(files, session, board);// 신규 파일 업로드 처리

            msg = "수정 성공";
            view = "redirect:detail?bnum=" + board.getBnum();
        }catch (Exception e){
            e.printStackTrace();
            msg = "수정 실패";
            view = "redirect:updatrFrm?bnum=" + board.getBnum();
        }
        rttr.addFlashAttribute("msg" , msg); // 메시지 전달.
        return view;
    }

    // 게시글 및 관련 파일 삭제
    @Transactional
    public String boardDelete(long bnum, HttpSession session, RedirectAttributes rttr){
        log.info("boardDelete()");
        String msg = null;
        String view = null;

        Board board = new Board();
        board.setBnum(bnum);

        String realPath = session.getServletContext().getRealPath("/");
        realPath += "upload/";

        List<BoardFile> bfList = bfRepo.findByBfbid(board);
        try {
            // 파일 삭제
            for (BoardFile bf : bfList){
                String delPath = realPath + bf.getBfsysname();
                File file = new File(delPath);

                if(file.exists()){
                    file.delete(); // 파일이 있으면 삭제
                }
            }
            // 파일 정보 삭제(DB)
            bfRepo.deleteByBfbid(board);
            // 게시글 삭제
            bRepo.deleteById(bnum);

            msg = "삭제 성공";
            view = "redirect:/";
        }catch (Exception e){
            e.printStackTrace();
            msg = "삭제 실패";
            view = "redirect:detail?bnum=" + bnum;
        }
        rttr.addFlashAttribute("msg" , msg);
        return view;
    }
}// class end
