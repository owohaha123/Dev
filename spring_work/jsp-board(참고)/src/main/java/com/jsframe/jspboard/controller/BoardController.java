package com.jsframe.jspboard.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsframe.jspboard.dto.BfileDto;
import com.jsframe.jspboard.dto.BoardDto;
import com.jsframe.jspboard.dto.ListDto;
import com.jsframe.jspboard.dto.ReplyDto;
import com.jsframe.jspboard.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService bServ;
	
	private ModelAndView mv;
	
	@GetMapping("/list")
	public ModelAndView boardList(ListDto list,
								  HttpSession session) {
		logger.info("boardList()");
		
		//DB에서 게시글의 목록을 가져와서 페이지로 전달
		mv = bServ.getBoardList(list, session);
		
		return mv;
	}
	
	@GetMapping("/writeFrm")
	public String writeFrm() {
		logger.info("writeFrm()");
		
		return "writeFrm";
	}
	
	//멀티파트 데이터를 처리할 경우 첫번째 매개변수는
	//MulitpartHttpServletRequest여야 한다.(must)
	@PostMapping("/boardWrite")
	public String boardWrite(@RequestPart List<MultipartFile> files,
							 BoardDto board, HttpSession session,
							 RedirectAttributes rttr) {
		logger.info("boardWrite()");
		
		String view = bServ.boardWrite(files, board, session, rttr);
		
		return view;
	}
	
	@GetMapping("/contents")
	public ModelAndView boardContents(Integer bnum) {
		logger.info("boardContents() : bnum - " + bnum);
		
		mv = bServ.getContent(bnum);
		
		return mv;
	}
	
	@PostMapping("replyIns")
	@ResponseBody
	public ReplyDto replyInsert(ReplyDto reply){
		logger.info("replyInsert()");

		reply = bServ.replyInsert(reply);
		
		return reply;
	}
	
	@GetMapping("/download")
	public ResponseEntity<Resource> fileDownload(BfileDto bfile, HttpSession session)
			throws IOException {
		logger.info("fileDownload()");

		ResponseEntity<Resource> resp = bServ.fileDownload(bfile, session);
		return resp;
	}

	@GetMapping("/updateFrm")
	public ModelAndView updateFrm(int bnum) {
		logger.info("updateFrm() : bnum - " + bnum);

		mv = bServ.updateFrm(bnum);

		return mv;
	}

	@PostMapping(value = "/delFile", 
			produces = "application/json; charset=UTF-8")
	@ResponseBody
	public Map<String, List<BfileDto>> delFile(String sysname, int bnum,
			HttpSession session){
		logger.info("delFile() - sysname : " + sysname);
		
		Map<String, List<BfileDto>> fMap = 
				bServ.fileDelete(sysname, bnum, session);
		
		return fMap;//jackson 라이브러리의 객체가 json object로 변환.
	}
	
	@PostMapping("/boardUpdate")
	public String boardUpdate(List<MultipartFile> files,
							  BoardDto board,
							  HttpSession session,
							  RedirectAttributes rttr) {
		logger.info("boardUpdate()");
		
		String view = bServ.boardUpdate(files, board, session, rttr);
		
		return view;
	}
	
	@GetMapping("/delete")
	public String boardDelete(int bnum, 
			RedirectAttributes rttr) {
		logger.info("boardDelete() - bnum : " + bnum);
		
		String view = bServ.boardDelete(bnum, rttr);
		
		return view;
	}
}//class end





