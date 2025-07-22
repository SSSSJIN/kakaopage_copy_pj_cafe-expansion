package com.kakaopage.expansion.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public AdminInterceptor adminInterceptor() {
        return new AdminInterceptor();
    }
}
