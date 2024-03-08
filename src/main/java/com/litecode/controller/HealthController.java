package com.litecode.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description: 健康检查控制器
 *
 * @author peakliuz
 * @since 2023/11/23 10:09:18
 */
@Slf4j
@RestController
public class HealthController {

    @GetMapping("/health")
    public String healthCheck(){
        log.info("调用健康检查成功!");
        return "ojbk";
    }
}
