package com.jsframe.interceptor.util;

import lombok.extern.java.Log;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
@Log
public class SessionInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler)throws Exception {
        log.info("preHandle()");

        HttpSession session = request.getSession();

        String mid = (String) session.getAttribute("mb");

        //if(session.getAttribute("mb") == null){
        // id가 없거나 id가 admin 이 아니라면
        if(mid == null || !mid.equals("admin")){
            // 로그인을 안 한 상태라면
            log.info("인터셉트 발생!!!");
            // 처음 페이지로 이동
            response.sendRedirect("/");
            return false;
        }

        return true;
    }//preHandle end

    // 브라우저의 back(뒤로가기 버튼("<")) 막기(main 접근 안 되게)
    // why? 페이지의 cash 가 남기 때문
    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                           ModelAndView modelAndView) throws Exception {
        log.info("postHandle");

        // 브라우저에 저장된 페이지(cash)를 삭제하도록 명령
        // 현재 웹 프로토콜 버전 (1.0 과 1.1 혼용)
        if(request.getProtocol().equals("HTTP/1.1")){
            response.setHeader("Cache-Control",
                    "no-cache, no-store, must-revalidate");
        }
        else{//1.0
            response.setHeader("Pragma", "no-cache");
        }

        response.setDateHeader("Expires", 0);
    }

}
