package com.jsframe.jpaboard_15day.service;

import com.jsframe.jpaboard_15day.entity.Board;
import com.jsframe.jpaboard_15day.repository.BoardRepository;
import com.jsframe.jpaboard_15day.entity.Board;
import com.jsframe.jpaboard_15day.repository.BoardRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
@Log
public class BoardService {
    @Autowired
    private BoardRepository bRepo;

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
}
