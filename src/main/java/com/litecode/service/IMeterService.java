package com.litecode.service;

import com.litecode.model.vo.MeterInstantVo;
import com.litecode.model.vo.MeterVo;

import java.util.Map;

/**
 * IMeterService
 *
 * @author peakliuz
 * @since 2024/3/7 21:21
 */
public interface IMeterService {

    /**
     * 获取电表列表
     */
    MeterVo meterInfo();

    MeterInstantVo getMeterInstant();

    Map<Integer, Double> meterMonthInfo();
}
