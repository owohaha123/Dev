package com.jsframe.jspboard.service;

import javax.servlet.http.HttpSession;

import com.jsframe.jspboard.dao.MemberDao;
import com.jsframe.jspboard.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.java.Log;

@Service
@Log
public class MemberService {
	@Autowired
	private MemberDao mDao;

	private BCryptPasswordEncoder pwdEncoder = new BCryptPasswordEncoder();
	
	private ModelAndView mv;
	
	//로그인 처리 서비스 메소드
	public String loginProc(MemberDto mem, HttpSession session,
							RedirectAttributes rttr) {
		String view = null;
		String msg = null;
		
		//회원의 비밀번호 구하기
		String encPwd = mDao.pwdSelect(mem.getM_id());
		
		if(encPwd != null) {
			//존재하는 아이디
			//나중에 변경하겠음.(암호화 처리로 변경할 예정임)
			if(pwdEncoder.matches(mem.getM_pwd(), encPwd)) {
				//로그인 성공 -> 세션에 로그인 정보를 저장
				//회원 정보(이름, 포인트, 등급이름) : mem 재활용
				mem = mDao.memberSelect(mem.getM_id());
				//세션에 DTO 저장.
				session.setAttribute("mb", mem);
				
				//로그인 성공 후 게시판의 목록 페이지로 이동.
				view = "redirect:list?pageNum=1";
			}
			else {
				//로그인 실패(비번 오류)
				view = "redirect:loginFrm";
				msg = "비밀번호 오류";
			}
		}
		else {
			//아이디가 존재하지 않는 경우(회원이 아닌 경우)
			view = "redirect:loginFrm";
			msg = "없는 아이디";
		}
		
		rttr.addFlashAttribute("msg", msg);
		
		return view;
	}//method end
	
	public String idCheck(String id) {
		String res = null;
		
		//아이디가 중복이면 1, 아니면 0.
		int cnt = mDao.idCheck(id);
		
		if(cnt == 0) {
			res = "ok";
		}
		else {
			res = "not";
		}
		
		return res;
	}
	
	public String memberInsert(MemberDto member,
			RedirectAttributes rttr) {
		String view = null;
		String msg = null;
		
		String encpwd = pwdEncoder.encode(member.getM_pwd());
		log.info("encpwd : " + encpwd);
		member.setM_pwd(encpwd);
		
		try {
			mDao.memberInsert(member);
			
			view = "redirect:/";
			msg = "가입 성공";
		} catch (Exception e) {
			e.printStackTrace();
			
			view = "redirect:joinFrm";
			msg = "가입 실패";
		}
		
		rttr.addFlashAttribute("msg", msg);
		
		return view;
	}
	
	//로그아웃 처리 메소드
	public String logout(HttpSession session) {
		String view = "redirect:/";
		
		session.invalidate();
		
		return view;
	}
	
}//class end




