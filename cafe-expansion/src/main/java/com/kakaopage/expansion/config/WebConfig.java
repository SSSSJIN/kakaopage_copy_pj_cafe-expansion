package com.kakaopage.expansion.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry; // 추가
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private AdminInterceptor adminInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(adminInterceptor)
                .addPathPatterns("/admin/**");
    }

    // 추가: 정적 리소스 핸들러
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // /resources/** 로 들어오는 정적 파일 요청을 /resources/ 폴더 하위에서 서빙
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");
    }
}
