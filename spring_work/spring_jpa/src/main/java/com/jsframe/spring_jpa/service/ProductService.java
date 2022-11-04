package com.jsframe.spring_jpa.service;

import com.jsframe.spring_jpa.entity.Product;
import com.jsframe.spring_jpa.repository.ProductRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Service
@Log
public class ProductService {
    @Autowired
    ProductRepository pRepo;

    ModelAndView mv;

    public String inputProduct(Product pd){
        log.info("inputProduct()");
        String view = null;

        try{
            log.info("1. pnum : " + pd.getPnum());
            pRepo.save(pd); //insert DB
            log.info("2. pnum : " + pd.getPnum());
            view = "redirect:/";
        }catch (Exception e){
            //e.printStackTrace();
            view = "redirect:/";
        }
        return view;
    }

    // 제품 목록 가져오기
    public ModelAndView getList(){
        log.info("getList()");
        mv = new ModelAndView();
        mv.setViewName("home");

        List<Product> pList = new ArrayList<>(); //순차적 데이터 저장
        Iterable<Product> pIter = pRepo.findAll();

        for(Product p : pIter){
            pList.add(p);
        }

        mv.addObject("pList", pList);

        return mv;
    }
}// class end
