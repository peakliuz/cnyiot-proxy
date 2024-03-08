package com.litecode.controller;

import com.litecode.model.vo.MeterInstantVo;
import com.litecode.model.vo.MeterVo;
import com.litecode.service.IMeterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Description: 健康检查控制器
 *
 * @author peakliuz
 * @since 2023/11/23 10:09:18
 */
@Slf4j
@RestController
public class MeterController {

    @Resource
    IMeterService meterService;

    @GetMapping("/meterInfo/{key}")
    public MeterVo meterInfo(@PathVariable String key){
        return meterService.meterInfo();
    }

    @GetMapping("/meterInstant/{key}")
    public MeterInstantVo getMeterInstant(@PathVariable String key){
        return meterService.getMeterInstant();
    }

    @GetMapping("/meterMonthInfo/{key}")
    public Map<Integer, Double> meterMonthInfo(@PathVariable String key){
        return meterService.meterMonthInfo();
    }
}
