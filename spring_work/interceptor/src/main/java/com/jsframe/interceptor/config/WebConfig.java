package com.jsframe.interceptor.config;

import com.jsframe.interceptor.util.SessionInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    SessionInterceptor interceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 세션 인터셉터를 스프링 프레임워크에 등록
        registry.addInterceptor(interceptor)
                .addPathPatterns("/**") // 모든 url 인터셉트
                .excludePathPatterns("/", "/css/**" , "/js/**" , "/images/**") // 제외할 부분 지정
                .excludePathPatterns("/loginFrm","/loginProc" , "/error/**") // 제외 추가
        ;
    }
}
