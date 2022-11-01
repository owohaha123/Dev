package com.jsframe.spr_jdbc2_12day.service;

import com.jsframe.spr_jdbc2_12day.dao.DataDao;
import com.jsframe.spr_jdbc2_12day.dto.DataDto;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Service
@Log
public class DataService {
    // Dao 사용 : Autowired 로 자동처리
    @Autowired // 거의 private
    private DataDao dDao;

    public String inputData(DataDto data, RedirectAttributes rttr){
        log.info("inputData()");
        String msg = null;
        String view = null;

        try{
            dDao.insertData(data);
            msg = "입력 성공"; // 사용자 화면에 출력할 메시지
            view = "redirect:/"; //입력 성공 시 첫 화면으로 이동
        }catch (Exception e){
            //e.printStackTrace();// 에러 문구를 콘솔창에 출력
            msg = "입력 실패";
            view = "redirect:inputFrm"; //입력 실패 시 화면 다시 보이게!
        }
        rttr.addFlashAttribute("msg", msg); // "이름표" , 데이터
        return view; //이동할 화면
    }

    public ModelAndView outputList(){
        log.info("outputList()");
        List<DataDto> dList = dDao.selectList();
        ModelAndView mv = new ModelAndView();
        mv.addObject("dList", dList);
        mv.setViewName("dataList");//출력할 jsp 페이지 이름

        return mv;
    }

    public ModelAndView outputData(int code){
        log.info("outputData()");
        DataDto data = dDao.selectData(code);
        ModelAndView mv = new ModelAndView();
        mv.addObject("data" , data);
        mv.setViewName("detail");
        return mv;
    }

    public String updateData(DataDto data, RedirectAttributes rttr){
        log.info("updateData()");
        String msg = null;
        String view = null;

        try{
            dDao.updateData(data);
            msg = "수정 성공";
            //view = "redirect:detail?code"+data.getM_code();
            view = "redirect:detail?code=";
        }catch (Exception e){
            //e.printStackTrace();
            msg = "수정 실패";
            //view = "redirect:updateFrm?code="data.getM_code();
            view = "redirect:updateFrm?code=";
        }finally {
            view += data.getM_code();
        }
        rttr.addFlashAttribute("msg", msg);
        return view;
    }

    public String deleteData(int code, RedirectAttributes rttr){
        log.info("deleteData()");
        String msg = null;
        String view = null;

        try{
            dDao.deleteData(code);
            msg = "삭제 성공";
            view = "redirect:dataList";
        }catch (Exception e){
            //e.printStackTrace();
            msg = "삭제 실패";
            view = "redirect:detail?code="+code;
        }
        rttr.addFlashAttribute("msg", msg);
        return view;
    }
}
