package com.litecode.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.annotation.Resource;

/**
 * WebConfig
 *
 * @author peakliuz
 * @since 2024/3/7 21:02
 */
@Component
public class WebConfig extends WebMvcConfigurationSupport {


    @Resource
    private AuthInterceptor authInterceptor;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(authInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/health");
    }
}