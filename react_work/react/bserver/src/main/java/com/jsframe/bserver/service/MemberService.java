package com.jsframe.bserver.service;

import com.jsframe.bserver.entity.Member;
import com.jsframe.bserver.repository.MemberRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Log
public class MemberService {
    @Autowired
    MemberRepository mRepo;

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Transactional
    public String joinMember(Member member){
        log.info("joinMember()");
        String res = null;

        String epwd = encoder.encode(member.getMpwd());
        member.setMpwd(epwd);

        try {
            mRepo.save(member);
            res = "Ok";
        }catch (Exception e){
            e.printStackTrace();
            res = "Fail";
        }
        return res;
    }

    public String loginProc(Member member) {
        log.info("loginProc()");
        Member dbMember = null;

        try {
            dbMember = mRepo.findById(member.getMid()).get();
            if(encoder.matches(member.getMpwd(), dbMember.getMpwd())){
                dbMember.setMpwd("");
            }
            else {
                dbMember = null;
            }
        }catch (Exception e){
            e.printStackTrace();
            dbMember = null;
        }
        return dbMember.getMid();
    }
}
