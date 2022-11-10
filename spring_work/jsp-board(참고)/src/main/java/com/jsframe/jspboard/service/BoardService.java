package com.jsframe.jspboard.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsframe.jspboard.dao.BoardDao;
import com.jsframe.jspboard.dao.MemberDao;
import com.jsframe.jspboard.dto.*;
import com.jsframe.jspboard.util.PagingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.java.Log;

@Service
@Log
public class BoardService {
	@Autowired
	private BoardDao bDao;
	@Autowired
	private MemberDao mDao;
	//게시글 작성한 사용자의 point 증가 및 등급 변경 내용 출력 시 활용.
	//(세션에 다시 저장)
	
	private ModelAndView mv;
	
	private int listCnt = 5;//페이지 당 출력할 게시글 개수
	
	public ModelAndView getBoardList(ListDto list,
									 HttpSession session) {
		mv = new ModelAndView();
		
		//Dao에 보내는 데이터를 만들자.(검색 기능 추가로 코드 사용 안함)
		//Map<String, Integer> pmap = new HashMap<String, Integer>();
		//pmap.put("pnum", (pageNum - 1) * listCnt);
		//pmap.put("lcnt", listCnt);
		int num = list.getPageNum();
		list.setPageNum((num - 1) * listCnt);
		list.setListCnt(listCnt);
		
		List<BoardDto> bList = bDao.boardListSelect(list);
		
		mv.addObject("bList", bList);
		
		//페이징 처리
		list.setPageNum(num);
		String pageHtml = getPaging(list);
		mv.addObject("paging", pageHtml);
		
		//세션에 페이지번호 저장(글쓰기 또는 글 상세보기 화면에서 목록 화면으로
		//돌아 갈 때 사용할 페이지 번호를 저장)
		session.setAttribute("pageNum", list.getPageNum());
		if(list.getColname() != null) {
			session.setAttribute("list", list);
		}
		else {//검색이 아닐 경우는 세션의 ListDto를 제거.
			session.removeAttribute("list");
		}
		
		mv.setViewName("boardList");
		
		return mv;
	}

	private String getPaging(ListDto list) {
		String pageHtml = null;
		
		//전체 글개수 구하기
		int maxNum = bDao.bcntSelect(list);
		//한 페이지 당 보여질 페이지 번호의 개수
		int pageCnt = 5;
		String listName = "list?";
		
		//검색 용 컬럼명과 검색어를 추가
		if(list.getColname() != null) {
			listName += "colname="+ list.getColname()
				+ "&keyword=" + list.getKeyword() + "&";
		}
		
		PagingUtil paging = new PagingUtil(maxNum,
				list.getPageNum(),
				listCnt, pageCnt, listName);
		
		pageHtml = paging.makePaging();
		
		return pageHtml;
	}
	
	@Transactional
	public String boardWrite(List<MultipartFile> files,
							 BoardDto board, HttpSession session,
							 RedirectAttributes rttr) {
		String view = null;
		String msg = null;

		try {
			//1. 게시글을 DB에 저장
			bDao.boardInsert(board);//이 문장 실행 후 b_num 필드에 
									//입력한 게시글의 번호가 저장.
			log.info("삽입 후 b_num : " + board.getB_num());
			
			//2. 업로드 파일이 있을 경우 파일 저장 및 DB에 정보 저장
			fileUpload(files, session, board);
			
			//3. 회원의 포인트 정보 변경 및 세션 데이터 변경
			MemberDto member = (MemberDto) session.getAttribute("mb");
			int point = member.getM_point() + 10;
			if(point > 100){//100 초과하지 않도록.
				point = 100;
			}
			member.setM_point(point);
			mDao.memberPtUpdate(member);
			member = mDao.memberSelect(member.getM_id());
			session.setAttribute("mb", member);

			view = "redirect:list?pageNum=1";//목록의 첫페이지로 이동
			msg = "글 작성 성공";
		} catch (Exception e) {
			e.printStackTrace();
			
			view = "redirect:writeFrm";
			msg = "글 작성 실패";
		}
		
		rttr.addFlashAttribute("msg", msg);
		
		return view;
	}

	private void fileUpload(List<MultipartFile> files,
							HttpSession session, BoardDto board)
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

		for(MultipartFile mf : files){
			String orname = mf.getOriginalFilename();//업로드 파일명 가져오기
			if(orname.equals("")){
				//업로드하는 파일이 없는 상태.
				return;//파일 저장 처리 중지!
			}

			//파일 정보를 저장(to boardfiletbl)
			BfileDto bf = new BfileDto();
			bf.setBf_bnum(board.getB_num());
			bf.setBf_oriname(orname);
			String sysname = System.currentTimeMillis()
					+ orname.substring(orname.lastIndexOf("."));
			bf.setBf_sysname(sysname);
			//업로드하는 파일을 upload 폴더에 저장.
			File file = new File(realPath + sysname);
			//파일 저장(upload 폴더)
			mf.transferTo(file);

			//파일 정보를 DB에 저장
			bDao.fileInsert(bf);
		}//for end
	}//method end
	
	public ModelAndView getContent(Integer bnum) {
		mv = new ModelAndView();
		
		//글내용 가져오기
		BoardDto board = bDao.boardSelect(bnum);
		//파일 목록 가져오기
		List<BfileDto> fList = bDao.fileSelect(bnum);
		//댓글 목록 가져오기
		List<ReplyDto> rList = bDao.replySelect(bnum);
		//조회수 수정(1 증가)

		//가져온 데이터를 mv에 추가
		mv.addObject("board", board);
		mv.addObject("fList", fList);
		mv.addObject("rList", rList);
		//보여질 페이지(jsp) 이름 지정
		mv.setViewName("boardContents");
		
		return mv;
	}
	
	@Transactional
	public ReplyDto replyInsert(ReplyDto reply){
		try {
			//댓글 삽입
			bDao.replyInsert(reply);
			bDao.boardRpUpdate(reply.getR_bnum());
			reply = bDao.replySelectLast(reply.getR_num());
		} catch (Exception e) {
			e.printStackTrace();
			reply = null;
		}
		
		return reply;
	}

	public ResponseEntity<Resource> fileDownload(BfileDto bfile, HttpSession session)
			throws IOException {
		log.info("fileDownload()");
		//파일 저장 경로 구하기
		String realpath = session.getServletContext().getRealPath("/");
		realpath += "upload/" + bfile.getBf_sysname();

		InputStreamResource fResource =
				new InputStreamResource(new FileInputStream(realpath));

		//파일명이 한글인 경우의 처리(UTF-8로 인코딩 처리)
		String fileName = URLEncoder.encode(bfile.getBf_oriname(), "UTF-8");

		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_OCTET_STREAM)
				.cacheControl(CacheControl.noCache())
				.header(HttpHeaders.CONTENT_DISPOSITION,
						"attachment; filename=" + fileName)
				.body(fResource);
	}
	
	public ModelAndView updateFrm(int bnum) {
		mv = new ModelAndView();
		
		//게시글 내용 가져오기(DB)
		BoardDto board = bDao.boardSelect(bnum);
		
		//파일 목록 가져오기(DB)
		List<BfileDto> fList = bDao.fileSelect(bnum);
		
		//mv에 위 내용 추가
		mv.addObject("board", board);
		mv.addObject("fList", fList);
		
		//화면(jsp) 이름 지정
		mv.setViewName("updateFrm");
		
		return mv;
	}

	@Transactional
	public Map<String, List<BfileDto>> fileDelete(String sysname, 
			int bnum, HttpSession session) {
		Map<String, List<BfileDto>> fMap = null;
		
		//파일 삭제(실제 파일 + 파일 정보 DB 삭제)
		//실제 파일 경로
		String realPath = session.getServletContext().getRealPath("/");
		realPath += "resources/upload/" + sysname;
		log.info(realPath);
		
		try {
			bDao.fileDelete(sysname);
			
			File file = new File(realPath);
			
			if(file.exists()) {//파일이 있을 경우
				if(file.delete()) {//파일 삭제에 성공한 경우
					//파일 목록 다시 가져오기
					List<BfileDto> fList = bDao.fileSelect(bnum);
					fMap = new HashMap<String, List<BfileDto>>();
					//파일 목록 맵에 삽입
					fMap.put("fList", fList);
				}
				else {
					fMap = null;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			fMap = null;
		}

		return fMap;
	}
	
	@Transactional
	public String boardUpdate(List<MultipartFile> files,
							  BoardDto board,
							  HttpSession session,
							  RedirectAttributes rttr) {
		log.info("boardUpdate()");
		String view = null;
		String msg = null;
		
		try {
			bDao.boardUpdate(board);
			
			fileUpload(files, session, board);

			view = "redirect:contents?bnum=" + board.getB_num();
			msg = "수정 성공";
		} catch (Exception e) {
			e.printStackTrace();
			view = "redirect:updateFrm?bnum=" + board.getB_num();
			msg = "수정 실패";
		}
		
		rttr.addFlashAttribute("msg", msg);
		
		return view;
	}
	
	@Transactional
	public String boardDelete(int bnum, 
			RedirectAttributes rttr) {
		String view = null;
		String msg = null;
		
		try {
			//댓글 삭제
			bDao.replyDelete(bnum);
			//파일목록(정보) 삭제
			bDao.fListDelete(bnum);
			//파일(실제)들 삭제(file.delete)
			//게시글 삭제
			bDao.boardDelete(bnum);
			
			view = "redirect:list?pageNum=1";
			msg = "삭제 성공";
		} catch (Exception e) {
			e.printStackTrace();
			
			view = "redirect:contents?bnum=" + bnum;
			msg = "삭제 실패";
		}
		
		rttr.addFlashAttribute("msg", msg);
		
		return view;
	}
}//class end








